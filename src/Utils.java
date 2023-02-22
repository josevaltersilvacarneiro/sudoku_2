public abstract class Utils {
	/**
	 *
	 */

	static public int convertToRowSection(int dimension, int sectionRow, int houseColumn) {
		return (sectionRow / dimension) * dimension + houseColumn / dimension;
	}

	static public int convertToColumnHouse(int dimension, int sectionRow, int houseColumn) {
		return (sectionRow / dimension) * dimension + houseColumn / dimension;
	}
}
