public class Sudoku {
        public static void main(String[] args) {
		boolean graphic = false;

		if (args.length == 1 && args[0].equals("-g"))
			graphic = true;

		Game game = new Game(graphic);

		while (!game.getQuit()) {

			game.show();
			game.play(
					game.getNextPlayer());
		}

		game.show(); // Ending
        }
}
