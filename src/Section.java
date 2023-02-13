import java.security.SecureRandom;

class Section {
	int dimension;
	int length;

	House section[];

	public Section() {
		this.dimension = 2;
		this.length    = this.dimension * this.dimension;

		this.section = new House[this.length];

		for (int i = 0; i < this.length; i++)
			this.section[i] = new House(this.rand(i));
	}

	public int getLength() {
		return this.length;
	}

	public boolean getFree() {
		for (int i = 0; i < this.getLength(); i++)
			if (this.isHouseFree(i))
				return true;

		return false;
	}

	public House getHouse(int house) {
		return this.section[house];
	}

	public boolean isHouseFree(int house) {
		return this.section[house].free;
	}

	protected int rand(int end) {
		boolean found;
		int randN;

		SecureRandom generator = new SecureRandom();

		do {
			found = false;

			randN = 1 + generator.nextInt(this.length);

			for (int i = 0; i < end && !found; i++)
				if (randN == this.section[i].value)
					found = true;
		} while (found);

		return randN;
	}

	public int index(int number) {
		int i = 0;

		for (House house : this.section) {
			if (house.getValue() == number)
				return i;
			i++;
		}

		return -1;
	}
}
