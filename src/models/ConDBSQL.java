package models;
import java.sql.*;

public class ConDBSQL {

	public static void main(String args[]) {

		// Criando as vari�veis de conex�o e de statement
		Connection con;
		Statement stmt;
		String query = "select name , id from sysobjects";

		// Verificando se o driver JDBC est� instalado e pode ser utilizado
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			// Abrindo a conex�o com o servidor MAURO, login sa e sem senha
			con = DriverManager.getConnection(
					"jdbc:microsoft:sqlserver://MAURO:1433", "sa", "");

			stmt = con.createStatement();
			// Criando a instru��o a partir do SELECT que est� dentro da
			// vari�vel query
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("Lista de linhas da tabela sysobjects:");

			// Fazendo um loop para mostrar tudo o que foi retornado do banco
			while (rs.next()) {

				// Obtendo o campo name em um string
				String s = rs.getString("name");
				// Obtendo o campo id em um inteiro
				int i = rs.getInt("id");
				System.out.println(s + "   " + i);
			}

			// Fechamdno a instru��o e a conex�o
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}
