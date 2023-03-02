import java.util.ArrayList;

public abstract interface Interaction {
	/**
	 * This interface defines all interactions of the player
	 * with the game.
	 *
	 * getDimension() returns the dimension typed by the player.
	 * getPlayers()   returns the players who will participate in the match.
	 * getMove()	  returns the player's move in the match.
	 * update()	  refreshes the display.
	 */

	public abstract int getDimension();
        public abstract String[] getPlayers();
        public abstract Move getMove(String playerName);
        public abstract void update(ArrayList<Player> players);
}
