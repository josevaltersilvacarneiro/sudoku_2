import java.util.ArrayList;

public abstract interface Interaction {
	public abstract int getDimension();
        public abstract String[] getPlayers();
        public abstract void update(ArrayList<Player> players);
        public abstract Move getMove(String playerName);
}
