package design_patterns.creational.factory;

public class ShopWebsite extends Website {

	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ProductsPage());
	}

}
