import java.util.Random;

class Section {
	int dimension;
	int length;
	boolean free;

	House section[];

	public Section() {
		this.dimension = 2;
		this.length    = this.dimension * this.dimension;
		this.free      = true;

		this.section = new House[this.length];

		for (int i = 0; i < this.length; i++)
			this.section[i] = new House(this.rand(i));
	}

	public boolean isHouseFree(int house) {
		return this.section[house].free;
	}

	protected int rand(int end) {
		boolean found;
		int randn;

		Random generator = new Random();

		do {
			found = false;

			randn = generator.nextInt(this.length)+1;

			for (int i = 0; i < end && !found; i++)
				if (randn == this.section[i].value)
					found = true;
		} while (found);

		return randn;
	}

	public int index(int index) {
		return this.section[index].value;
	}
}
