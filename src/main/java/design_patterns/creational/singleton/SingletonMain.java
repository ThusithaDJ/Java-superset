package design_patterns.creational.singleton;

public class SingletonMain {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(15000);
		System.out.println(SingletonClient.getInstance());
		System.out.println(SingletonClient.getInstance());
		System.out.println(SingletonClient.getInstance());
		System.out.println(SingletonClient.getInstance());
		System.out.println(TestClass.classname);
		System.out.println(TestClass.classname);
		System.out.println(TestClass.classname);
		System.out.println(TestClass.classname);
		Thread.sleep(15000);
	}

}
