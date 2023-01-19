public class Sudoku {
        public static void main(String[] args) {
		Game game = new Game();

		while (!game.getQuit()) {

			game.show();
			game.play(
					game.getNextPlayer());
		}
        }       
}       
