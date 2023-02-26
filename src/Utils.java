public abstract class Utils {
	/**
	 *
	 */

	public static int dimension;

	public static int convertToRowSection(int sectionRow, int houseColumn) {
		return (sectionRow / dimension) * Utils.dimension + houseColumn / Utils.dimension;
	}

	public static int convertToColumnHouse(int sectionRow, int houseColumn) {
		return (sectionRow / dimension) * Utils.dimension + houseColumn / Utils.dimension;
	}
}
