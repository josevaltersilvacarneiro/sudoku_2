class House {
	boolean free;
	int value;

	public House(int value) {
		this.free = true;
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isFree() {
		return this.free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}
}
