package design_patterns.creational.singleton;

public class SingletonClient {
	
//	volatile key will guarantees that this object is thread-safe
//	assigning null to variable, it will lazy-load the object. which means it only create only when necessary.
	
	public static volatile SingletonClient client = null;
	
	private SingletonClient() {
//		this will restrict the usage of reflection.
		if (client != null) {
			throw new RuntimeException("Please use getInstance() method");
		}
	}
	
	public static SingletonClient getInstance() {
		
		if (client == null) {
//			adding thread-safe by adding the synchronized block. instead of adding it into the whole method, this will o
			synchronized (SingletonClient.class) {
				if (client == null) {
					client = new SingletonClient();
				}
			}
		}
		return client;
	}

}
