import java.util.ArrayList;

public class Game {
	int next_player;
	int num_of_players = 2;
	boolean diagonal;
	boolean quit;

	ArrayList<Player> players;
	Display display;

	public Game() {
		this.display  = new Display();
		this.players = new ArrayList<Player>();

		for (String playerName : this.display.getPlayers())
			this.players.add(new Player(playerName));
		
		this.diagonal = true;
		this.quit     = false;
	}

	Player next_player() {
		this.next_player += 1;
		this.next_player %= this.num_of_players;

		return this.players.get(this.next_player);
	}

	void show() {
		System.out.println(this.display.show());
	}

	void play(Player player) {
		Move move;

		move = this.display.getMove();

		if (!this.display.isRowFree(move.row))
			player.setScore(
					this.display.rowSum(move.row));
		if (!this.display.isColumnFree(move.column))
			player.setScore(
					this.display.columnSum(move.column));
		if (!this.display.isDiagonalFree() && this.diagonal) {
			player.setScore(
					this.display.diagonalSum());
			this.diagonal = false;
		}
	}
}
