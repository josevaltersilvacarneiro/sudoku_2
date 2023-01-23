public abstract interface Interaction {
	public abstract int getDimension();
        public abstract String[] getPlayers();
        public abstract void update();
        public abstract Move getMove(String playerName);
}
