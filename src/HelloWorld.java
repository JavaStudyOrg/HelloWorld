import controllers.IndexController;

public class HelloWorld {
	public static void main(String[] args) {
		IndexController index = new IndexController();
		index.printHello();
		index.printAtt();
		System.out.println("deu");
	}
}
