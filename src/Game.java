public class Game {
	int next_player;
	int num_of_players = 2;
	boolean diagonal;
	boolean quit;

	Player players[] = new Player[this.num_of_players];
	Display display;

	public Game() {
		this.display  = new Display();
		int i = 0;
		for (String playerName : this.display.getPlayers()) {
			this.players[i] = new Player(playerName);
			i++;
		}
		this.diagonal = true;
		this.quit     = false;
	}

	Player next_player() {
		this.next_player += 1;
		this.next_player %= this.num_of_players;

		return this.players[next_player];
	}

	void show() {
		System.out.println(this.display.show());
	}

	void play(Player player) {
		Move move;

		move = this.display.getMove();

		if (!this.display.isRowFree(move.row))
			player.score += this.display.rowSum(move.row);
		if (!this.display.isColumnFree(move.column))
			player.score += this.display.columnSum(move.column);
		if (!this.display.isDiagonalFree() && this.diagonal) {
			player.score += this.display.diagonalSum();
			this.diagonal = false;
		}
	}
}
