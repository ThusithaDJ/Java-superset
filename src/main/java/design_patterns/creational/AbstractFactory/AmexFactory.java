package design_patterns.creational.AbstractFactory;

public class AmexFactory extends CreditCardAbstractFactory{

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
		case GOLD:
			return new AmexGoldCreditCard();
		case PLATINUM:
			return new AmexPlatinumCreditCard();
		default:
			return null;
		}
	}

	@Override
	public Validator getValidator(CardType cardType) {
		switch (cardType) {
		case GOLD:
			new AmexGoldValidator();
		case PLATINUM:
			new AmexPlatinumValidator();
		}
		return null;
	}

}
