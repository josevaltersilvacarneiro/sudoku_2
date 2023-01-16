public class Sudoku {
        public static void main(String[] args) {
		Game game = new Game();
		game.quit = false;

		while (!game.quit) {

			game.show();
			game.play(game.next_player());
		}
        }       
}       
