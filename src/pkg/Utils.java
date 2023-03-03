package pkg;

public abstract class Utils {
	/**
	 *
	 */
	
	public static int convertToRowSection(int dimension, int sectionRow, int houseColumn) {
		return (sectionRow / dimension) * dimension + houseColumn / dimension;
	}

	public static int convertToColumnHouse(int dimension, int sectionRow, int houseColumn) {
		return (sectionRow % dimension) * dimension + houseColumn % dimension;
	}
}
