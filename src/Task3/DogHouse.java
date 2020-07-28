/*
 * ID: 316522341
 * NAME: Dvir Tayeb
 * 
 */

package Task3;

public class DogHouse {
	// variables:
	private final int MAX_NUMBER_CAGES = 20;
	private final double MIN_PRICE = 30;
	private final double PRICE_KG = 0.8;

	private int cagesInUse;
	private Cage[] numberOfCages;
	private String name;

	// Constructor:
	public DogHouse(String name) {
		this.name = name;
		numberOfCages = new Cage[MAX_NUMBER_CAGES];
		numberOfCages[cagesInUse++] = new Cage();
	}

	// let's try to bring the dog to house pension
	public boolean addDog(Dog dog) {
		int counter = 0;
		for (int i = 0; i < cagesInUse; i++) {
			// if we cannot get the dog in this cage we need to open a new one
			if (!numberOfCages[i].addDogToCage(dog))
				// let's count the cages..
				counter++;
			else {
				return true;
			}
		}
		// we check if we got the maximum cages.
		if (counter == cagesInUse) {
			if (cagesInUse >= MAX_NUMBER_CAGES) {
				return false;
			}
			// now we can open a new cage for the dog.
			else {
				numberOfCages[cagesInUse] = new Cage();
				cagesInUse++;
				if (numberOfCages[cagesInUse - 1].addDogToCage(dog)) {
					return true;
				}
			}
		}
		return true;
	}

	// we let the dog to go from the house pension.
	public int outDog(int id, MyDate outDate) {
		for (int i = 0; i < numberOfCages.length; i++) {
			Dog dog;
			// Looking for the the dog in the cages by id
			dog = numberOfCages[i].findDogByID(id);
			if (dog != null) {
				if (numberOfCages[i].removeDog(dog)) {
					// term that say if the cage is empty we we take him out and start the count
					// from the one before
					if (numberOfCages[i].getCounterdogs() == 0) {
						for (int j = i + 1; j < cagesInUse; j++)
							numberOfCages[j - 1] = numberOfCages[j];
						cagesInUse--;
						// change the cage to null
						numberOfCages[cagesInUse] = null;
					}
					return dog.getDate().daysCount(outDate);
				}
			}
		}
		return -1;
	}

	public int getDogsCount() {
		int dogCounter = 0;
		for (int i = 0; i < cagesInUse; i++) {
			dogCounter += numberOfCages[i].getCounterdogs();
		}
		return dogCounter;
	}

	public int getCagesCount() {
		return cagesInUse;
	}

	public void makePriceStatment(Dog dog, int days) {
		double price = 0;
		int year = 365;
		if (days < year)
			price = days * dog.getWeight() * PRICE_KG;
		if (dog.getWeight() * PRICE_KG < MIN_PRICE)
			price = days * MIN_PRICE;
		System.out.println(dog + " Need to pay " + price + " IS");
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("In house " + this.name + " there are " + getDogsCount() + " dogs\n");
		for (int i = 0; i < cagesInUse; i++) {
			if (numberOfCages[i] == null) {
				continue;
			}
			sb.append(numberOfCages[i] + "\n");
		}
		sb.append("There are " + getCagesCount() + " cages");
		return sb.toString();
	}

}
