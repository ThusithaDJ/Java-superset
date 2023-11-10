package design_patterns.creational.AbstractFactory;

public abstract class CreditCardAbstractFactory {

	public static CreditCardAbstractFactory getCreditCardAbsctractFactory(int creditScore) {
		if (creditScore > 650) {
			return new AmexFactory();
		} else {
			return new VisaFactory();
		}

	}
	
	public abstract CreditCard getCreditCard(CardType cardType);
	
	public abstract Validator getValidator(CardType cardType);
}
