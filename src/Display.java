import java.util.Scanner;

class Display {
	int dimension;
	int length;
	Board board;
	boolean quit;

	public Display() {
		this.dimension = this.get_dimension();
		this.length    = this.dimension * this.dimension;
		this.board     = new Board();
		this.quit      = false;
	}

	private int getNumber() {
		int number;
		Scanner read = new Scanner(System.in);

		number = read.nextInt();
		
		return number;
	}

	private int convertToRow(int section, int house) {
		return (section / this.dimension) * this.dimension + house / this.dimension;
	}

	private int convertToColumn(int section, int house) {
		return (section % this.dimension) * this.dimension + house % this.dimension;
	}

	String show() {
		String repr;

		repr = "";
		for (int i = 0; i < 30; i++)
			repr += "=";
		repr += "\n";
		repr += this.board.show();
		for (int i = 0; i < 30; i++)
			repr += "=";

		return repr;
	}

	int get_dimension() {
		return 2;
	}

	String[] getPlayers() {
		String[] playerNames = {"Jose", "Maria"};
		return playerNames;
	}

	Move getMove() {
		int section, house;
		int row, column;
		Move move;
		
		do {
			section = getNumber();
			house   = getNumber();
			row	= this.convertToRow(section, house);
			column	= this.convertToColumn(section, house);

			move    = new Move(
						this.length,
						row,
						column
					  );
		} while (
				!move.isOptionValid() ||
				!this.board.isSectionFree(section) ||
				!this.board.isHouseFree(section, house)
			);

		return move;
	}

	boolean isRowFree(int row) {
		return true;
	}

	boolean isColumnFree(int column) {
		return true;
	}

	boolean isDiagonalFree() {
		return true;
	}

	int rowSum(int row) {
		return 0;
	}

	int columnSum(int column) {
		return 0;
	}

	int diagonalSum() {
		return 1;
	}
}
