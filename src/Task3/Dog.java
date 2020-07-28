/*
 * ID: 316522341
 * NAME: Dvir tayeb
 */
package Task3;

public class Dog {
	// Variables:
	private final int MIN_WEIGHT = 5;

	private static int counter = 100;
	private double weight;
	private int id;
	private boolean male;
	private MyDate date;
	private String name, type;

	// Constructor:
	public Dog(double weight, boolean male, MyDate date, String name, String type) {
		this.weight = setWeight(weight);
		this.male = male;
		this.date = date;
		this.name = name;
		this.type = type;
		id = counter++;

	}

	// copy Constructor:
	public Dog(Dog dog) {
		this.weight = dog.getWeight();
		this.male = dog.isMale();
		this.date = dog.getDate();
		this.name = dog.getName();
		this.type = dog.getType();
		this.id = dog.getId();
	}

	public double setWeight(double weight) {
		while (weight < MIN_WEIGHT) {
			weight = MIN_WEIGHT;
		}
		return weight;
	}

	public double getWeight() {
		return weight;
	}

	public int getId() {
		return id;
	}

	public boolean isMale() {
		return male;
	}

	public MyDate getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		if (this.male == true) {
			String doggy = "Dog id " + getId() + " " + getName() + " of type " + getType() + " Weight " + getWeight()
					+ " male enter to dog house on " + getDate();
			return doggy;
		}
		String doggy = "Dog id " + getId() + " " + getName() + " of type " + getType() + " Weight " + getWeight()
				+ " female enter to dog house on " + getDate();
		return doggy;
	}
}
