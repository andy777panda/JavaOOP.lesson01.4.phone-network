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

public class Network {

	private String name; // назва мережі
	private int count; // кількість зареєстрованих номерів в мережі
	private String[] numbers = new String[1]; // масив номерів мережі.
	// початкова розмірність 10 елементів

	/* конструктор дефолтний */
	public Network() {
		super();
	}

	/*
	 * основний конструктор - лише назва мережі. інші параметри внутрішні і
	 * можуть визначитися з часом
	 */
	public Network(String name) {
		super();
		this.name = name;
	}

	/* сеттери + геттери */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public String[] getNumbers() {
		return numbers;
	}

	public String getNumber(int i) {
		return this.numbers[i];
	}

	/* додавання номеру до масиву оператора */
	public void addNumber(String number) {
		if (this.count == this.numbers.length ) {
			this.resize();// за потреби - розширюємо масив
		}
		this.numbers[this.count++] = number;
	}

	/* розширення масиву для номерів */
	private void resize() {
		String[] temp = new String[numbers.length + 1];
		System.arraycopy(numbers, 0, temp, 0, numbers.length);
		numbers = temp;
	}

	/* перевірка наявності номера в мережі */
	public boolean isNumber(String number) {
		for (int i = 0; i < this.getCount(); i++) {
			if (this.getNumber(i) == number) {
				return true;
			}
		}
		return false;
	}

	/* друк реквізитів мережі */
	public String toString() {
		return "Network[" + "name=" + name + ", count registered numbers="
				+ count + "]";
	}

	/* друк номерів мережі */
	public void printNumbers() {
		System.out.println(this.toString());
		System.out.println(" such numbers are REGISTERed in the network "
				+ this.getName() + ":");
		for (int i = 0; i < this.getCount(); i++) {
			System.out.println((i + 1) + ". " + this.getNumber(i) + " "
					+ this.getName());
		}
	}
}