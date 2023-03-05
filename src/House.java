class House {
	/**
	 * This class represents a house on the board.
	 *
	 * To instantiate it, use the command below:
	 *
	 * House newHouse = new House(houseValue);
	 *
	 * To get the houseValue, use the command below:
	 *
	 * System.out.println(newHouse.getValue());
	 *
	 * To know if the house was chosen by a player,
	 * use the command below:
	 *
	 * if (newHouse.isFree())
	 * 	System.out.println("This house hasn't been chosen");
	 *
	 * To make the house "chosen", use the command below:
	 * 
	 * newHouse.setFree(false);
	 */

	private boolean free;
	private int	value;

	public House(int value) {
		this.free  = true;
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
