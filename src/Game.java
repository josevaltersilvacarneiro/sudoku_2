import java.util.ArrayList;
import java.util.Collections;

public class Game {
	private int     numberOfPlayers;
	private int     nextPlayer;
	private boolean diagonal;
	private boolean quit;

	private ArrayList<Player> players;
	private Display   	  display;

	public Game() {
		this.display  	     = new TerminalDisplay();
		this.players         = new ArrayList<Player>();

		for (String playerName : this.display.getPlayers())
			this.players.add(new Player(playerName));
		
		this.numberOfPlayers = this.players.size();
		this.nextPlayer	     = 0;
		this.diagonal 	     = false;
		this.quit            = false;
	}

	public boolean getQuit() {
		return this.quit;
	}

	public Player getNextPlayer() {
		/*
		 * To find out the next player to play,
		 * increase the nextPlayer attribute by
		 * one. After that, calculate the modu-
		 * lus in relation to the number of
		 * players.
		 */

		this.nextPlayer += 1;
		this.nextPlayer %= this.numberOfPlayers;

		return this.players.get(this.nextPlayer);
	}

	public void show() {
		ArrayList<Player> sortedPlayers = (ArrayList<Player>) this.players.clone();

		Collections.sort(sortedPlayers); // Sorting the players before showing them
		this.display.update(sortedPlayers);
	}

	public void play(Player player) {
		Move move;

		move = this.display.getMove(player.getName());

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
