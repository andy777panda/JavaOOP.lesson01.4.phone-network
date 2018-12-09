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

public class Phone {

	private String number; // номер
	private String vendor; // виробник апарату
	private String model; // модель апарату
	private Network network;
	
	/* конструктор дефолтний */
	public Phone() {
		super();
	}

	/*
	 * основний конструктор - лише номер (інші параметри внутрішні і можуть
	 * визначитися з часом)
	 */
	public Phone(String number) {
		super();
		this.number = number;
	}

	/* сеттери + геттери */
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	/* реєстрація в мережі */
	public void networkRegistration(Network network) {
		if (network.isNumber(this.getNumber())) {
			System.out.println("number " + this.getNumber()
					+ " already is registered in network " + network.getName());
		} else {
			network.addNumber(this.getNumber());
			this.setNetwork(network);
			System.out.println("number " + this.getNumber()
					+ " SUCSESSfully registered in network "
					+ this.network.getName());
		}
	}

	/*
	 * здійснення дзвінка на заданий номер у мережі телефона, з якого
	 * здійснюється дзвінок
	 */
	public void call(String number) {
		if (this.getNumber() == number) {
			System.out
					.println("WRONG NUMBER. You can't call to your oun number");
		} else if (this.getNetwork().isNumber(number)) {
			System.out.println("phone " + this.number + " CALLing to phone "
					+ number + " in network " + this.getNetwork().getName());
		} else {
			System.out.println("WRONG NUMBER. phone " + number
					+ " is no registered in network " + network.getName());
		}
	}

	/* здійснення дзвінка на заданий номер у заданій мережі */
	public void call(String number, Network network) {
		if (network.isNumber(number)) {
			System.out.println("phone " + this.number + " CALLing to phone "
					+ number + " in network " + network.getName());
		} else {
			System.out.println("WRONG NUMBER. phone " + number
					+ " is no registered in network " + network.getName());
		}
	}

	/* друк реквізитів телефону */
	public String toString() {
		return "Phone[" + "number=" + number + ", network=" + network + "]";
	}
}