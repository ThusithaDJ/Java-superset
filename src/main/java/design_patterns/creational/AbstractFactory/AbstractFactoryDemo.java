package design_patterns.creational.AbstractFactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		CreditCardAbstractFactory abstractFactory = CreditCardAbstractFactory.getCreditCardAbsctractFactory(775);
		CreditCard creditCard = abstractFactory.getCreditCard(CardType.PLATINUM);
		System.out.println(creditCard.getClass());
		
		abstractFactory = CreditCardAbstractFactory.getCreditCardAbsctractFactory(54);
		CreditCard creditCard2 = abstractFactory.getCreditCard(CardType.GOLD);
		System.out.println(creditCard2.getClass());
	}
}
