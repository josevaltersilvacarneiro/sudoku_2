public abstract class Utils {
	/**
	 *
	 */

	protected static int dimension;

	static public int convertToRowSection(int sectionRow, int houseColumn) {
		return (sectionRow / dimension) * Utils.dimension + houseColumn / Utils.dimension;
	}

	static public int convertToColumnHouse(int sectionRow, int houseColumn) {
		return (sectionRow / dimension) * Utils.dimension + houseColumn / Utils.dimension;
	}
}
