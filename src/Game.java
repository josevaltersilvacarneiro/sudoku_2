import java.util.ArrayList;

public class Game {
	int     nextPlayer;
	int     numberOfPlayers;
	boolean diagonal;
	boolean quit;

	ArrayList<Player> players;
	Display 	  display;

	public Game() {
		this.display  	     = new Display();
		this.players         = new ArrayList<Player>();

		for (String playerName : this.display.getPlayers())
			this.players.add(new Player(playerName));
		
		this.numberOfPlayers = this.players.size();
		this.nextPlayer	     = 0;
		this.diagonal 	     = false;
		this.quit            = false;
	}

	Player next_player() {
		this.nextPlayer += 1;
		this.nextPlayer %= this.numberOfPlayers;

		return this.players.get(this.nextPlayer);
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
		
		if (!this.display.isDiagonalFree() && !this.diagonal) {
			player.setScore(
					this.display.diagonalSum());
			this.diagonal = true;
		}
	}
}
