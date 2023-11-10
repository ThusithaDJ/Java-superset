package design_patterns.creational.prototype;

public class PrototypeDemo {

	public static void main(String[] args) {
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Fifty Shades of Gray");
		movie.setRuntime("1.5 hours");
		
		System.out.println(movie);
		System.out.println(movie.getTitle());
		System.out.println(movie.getRuntime());
		System.out.println(movie.getUrl());
		
		Movie spiderMan = (Movie) registry.createItem("Movie");
		spiderMan.setTitle("Spider Man");
		
		System.out.println(spiderMan);
		System.out.println(spiderMan.getTitle());
		System.out.println(spiderMan.getRuntime());
		System.out.println(spiderMan.getUrl());
	}
}
