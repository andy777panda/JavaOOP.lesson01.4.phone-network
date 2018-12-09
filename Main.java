package net.ukr.andy777;

/*
 Описать класс "Phone" (одним из свойств должен быть его номер).
 Описать класс "Network" (сеть мобильного оператора). 
 Телефон должен иметь метод регистрации в сети мобильного оператора.
 Также у телефона должен быть метод call (номер другого телефона), 
 который переберет все телефоны, зарегистрированные в сети.
 Если такой номер найден, то осуществить вызов, 
 если нет - вывести сообщение о неправильности набранного номера.
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("Lesson1 Task4");
		phoneNetwork();
	}

	private static void phoneNetwork() {

		/* ініціалізація мереж */
		Network net1 = new Network("Operator1");
		Network net2 = new Network("Operator2");

		/* ініціалізація телефонів */
		Phone phone1 = new Phone("380671234501");
		Phone phone2 = new Phone("380671234502");
		Phone phone3 = new Phone("380671234503");
		Phone phone4 = new Phone("380671234501");

		/* реєстрація телефонів в мережах */
		phone1.networkRegistration(net1);
		phone2.networkRegistration(net1);
		phone3.networkRegistration(net1);
		phone4.networkRegistration(net1);
		phone4.networkRegistration(net2);
		// останнє нереально. але для цього треба додатково писати модулі контролю
		System.out.println();

		/* друк всіх номерів в мережах */
		net1.printNumbers();
		System.out.println();
		net2.printNumbers();
		System.out.println();

		/* здійснення дзвінків у мережі телефона, я кого здійснюється дзвінок */
		phone1.call(phone2.getNumber());
		phone1.call(phone3.getNumber());
		phone1.call(phone4.getNumber());
		System.out.println();

		/* здійснення дзвінків на задану мережу */
		phone1.call(phone2.getNumber(), net1);
		phone1.call(phone3.getNumber(), net1);
		phone1.call(phone4.getNumber(), net1);
		phone1.call(phone4.getNumber(), net2);
		phone1.call(phone2.getNumber(), net2);
		System.out.println();
	}
}