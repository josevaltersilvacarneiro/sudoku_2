import java.security.SecureRandom;

class Section {
	/**
	 * This class represents a Section of
	 * the Game Board.
	 *
	 * When instantiating a new Section object,
	 * the dimension must be passed as argument.
	 * For example:
	 *
	 * Section newSection = new Section(2);
	 */

	private int dimension;
	private int length;

	private House section[];

	public Section(int dimension) {
		this.dimension = dimension;
		this.length    = (int) Math.pow(this.dimension, 2);

		this.section   = new House[this.length];

		for (int i = 0; i < this.length; i++)
			this.section[i] = new House(this.rand(i));
	}

	public boolean isFree() {
		for (int i = 0; i < this.length; i++)
			if (this.getHouse(i).isFree())
				return true;

		return false;
	}

	public House getHouse(int house) {
		return this.section[house];
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
