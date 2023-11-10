package design_patterns.creational.AbstractFactory;


public class VisaFactory extends CreditCardAbstractFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
		case GOLD:
			return new VisaGoldCreditCard();
		case PLATINUM:
			return new VisaBlackCreditCard();
		default:
			return null;
		}
	}
	
	@Override
	public Validator getValidator(CardType cardType) {
//		return new VisaValidator();
		return null;
	}
}
