package design_patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

	private Map<String, Item> items = new HashMap<>();
	
	public Registry() {
		loadItems();
	}
	
	public Item createItem(String type) {
		Item item = null;
		
		try {
			item = (Item) items.get(type).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	private void loadItems() {
		Movie movie = new Movie();
		movie.setTitle("Avengers");
		movie.setPrice(24.99);
		movie.setRuntime("2 hours");
		items.put("Movie", movie);
		
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setNumberOfPages(324);
		book.setPrice(19.99);
		items.put("Book", book);
		
	}
}
