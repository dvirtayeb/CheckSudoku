package Task3;

public class Cage {
	// Variables:
	private static final double MAX_WEIGHT_IN_CAGE = 100;
	private static final int MAX_NUMBER_OF_DOGS_IN_CAGE = 4;

	private int counterDogs;
	private double currectWeightInCage;
	private boolean hasMaleComeIn;
	private Dog[] dogInCage;
	private int cageNumber;
	private static int counterCages = 1;

	// Constructor:
	public Cage() {
		this.currectWeightInCage = 0;
		this.counterDogs = 0;
		hasMaleComeIn = false;
		this.cageNumber = counterCages++;
		dogInCage = new Dog[MAX_NUMBER_OF_DOGS_IN_CAGE];

	}

	public int getCounterCages() {
		return cageNumber;
	}

	public int getCounterdogs() {
		return counterDogs;
	}

	public boolean cageIsEmpty() {
		if (dogInCage.length == 0) {
			return true;
		}
		return false;
	}

	public boolean addDogToCage(Dog dog) {
		// check all the term we have for get the dog in the cage.
		if ((dog.isMale() && hasMaleComeIn) || MAX_WEIGHT_IN_CAGE <= currectWeightInCage + dog.getWeight()
				|| counterDogs > MAX_NUMBER_OF_DOGS_IN_CAGE) {
			return false;
		}
		for (int i = 0; i < MAX_NUMBER_OF_DOGS_IN_CAGE; i++) {
			if (dog.equals(dogInCage[i])) {
				return false;
			}
		}
		for (int i = 0; i < MAX_NUMBER_OF_DOGS_IN_CAGE; i++) {
			if (dogInCage[i] == null) {
				dogInCage[i] = dog;
				counterDogs++;
				// count total k"g of the dogs:
				currectWeightInCage += dog.getWeight();
				if (dog.isMale() == true) {
					hasMaleComeIn = true;
				}
				return true;
			}
		}
		return false;
	}

	public boolean removeDog(Dog dog) {
		if (counterDogs == 0) {
			return false;
		}
		for (int i = 0; i < MAX_NUMBER_OF_DOGS_IN_CAGE; i++) {
			if (dogInCage[i].getId() == dog.getId()) {
				counterDogs--;
				currectWeightInCage -= dog.getWeight();
				if (dog.isMale())
					hasMaleComeIn = false;
				dogInCage[i] = null;
				return true;
			}
		}
		return false;
	}

	public Dog findDogByID(int ID) {
		for (int i = 0; i < MAX_NUMBER_OF_DOGS_IN_CAGE; i++)
			if (dogInCage[i] != null)
				if (dogInCage[i].getId() == ID)
					return dogInCage[i];
		return null;
	}

	public String toString() {
		String cage = "In Cage " + cageNumber + " there are " + getCounterdogs() + " dogs\n";
		StringBuffer sb = new StringBuffer(cage);
		for (int i = 0; i < dogInCage.length; i++) {
			if (dogInCage[i] != null) {
				sb.append(dogInCage[i] + " is in cage number " + cageNumber + "\n");
			}
		}
		return sb.toString();
	}
}
