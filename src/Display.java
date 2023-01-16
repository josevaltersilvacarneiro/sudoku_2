class Display {
	int dimension;
	int length;
	Board board;
	boolean quit;

	public Display() {
		this.dimension = 2;
		this.length = this.dimension * this.dimension;
		this.board = new Board();
		this.quit = false;
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
}
