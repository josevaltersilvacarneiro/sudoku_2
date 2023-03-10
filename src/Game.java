import java.util.ArrayList;
import java.util.Collections;

public class Game {
	/**
	 * This is the main class of the game and
	 * therefore it provides the communication
	 * interface with the game.
	 *
	 * To instantiate it, use the command
	 * below:
	 *
	 * bool graphicalDisplay = true;
	 * Game newGame = Game(graphicalDisplay);
	 *
	 * To find out if the user has quit, use
	 * the command below:
	 *
	 * bool quit = newGame.getQuit();
	 *
	 * To show the interaction interface, use
	 * the command below:
	 *
	 * newGame.show();
	 *
	 * To find out who is the next player to
	 * play, use the command below:
	 *
	 * Player nextPlayer = newGame.getNextPlayer();
	 *
	 * To wait for a player to play and pro-
	 * cess his move, use the command below:
	 *
	 * newGame.play(nextPlayer);
	 */

	private int     numberOfPlayers;
	private int     nextPlayer;
	private boolean diagonal;
	private boolean quit;

	private ArrayList<Player> players;
	private Display   	  display;

	public Game(boolean graphic) {
		this.display  	     = graphic ? new GraphicDisplay() : new TerminalDisplay();
		this.players         = new ArrayList<Player>();

		for (String playerName : this.display.getPlayers())
			this.players.add(new Player(playerName));
		
		this.numberOfPlayers = this.players.size();
		this.nextPlayer	     = 0;
		this.diagonal 	     = false;
		this.quit            = false;
	}

	public boolean getQuit() {
		return this.display.getQuit();
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
		@SuppressWarnings("unchecked")
		ArrayList<Player> sortedPlayers = (ArrayList<Player>) this.players.clone();

		Collections.sort(sortedPlayers); // Sorting the players before showing them
		this.display.update(sortedPlayers);
	}

	public void play(Player player) {
		Move move;

		move = this.display.getMove(player.getName());

		if (!this.display.isRowFree(move.getRow()))
			player.setScore(
					this.display.rowSum(move.getRow()));

		if (!this.display.isColumnFree(move.getColumn()))
			player.setScore(
					this.display.columnSum(move.getColumn()));
		
		if (!this.display.isDiagonalFree() && !this.diagonal) {
			player.setScore(
					this.display.diagonalSum() * 2);
			this.diagonal = true;
		}
	}
}
