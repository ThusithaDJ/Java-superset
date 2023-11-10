package design_patterns.creational.factory;

public class WebsiteFactory {

	public static Website getWebsite(WebsiteType type) {
		switch (type) {
		case SHOP:
			return new ShopWebsite();
		case BLOG:
			return new BlogWebsite();

		default:
			return null;
		}
	}
}
