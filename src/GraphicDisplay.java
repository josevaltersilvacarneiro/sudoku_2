class GraphicDisplay extends Display {
	
	public GraphicDisplay() {
	}

	@Override
	public int getDimension() {
		return 2;
	}

	@Override
	public String[] getPlayers() {
		String[] playerNames = {"José", "Maria"};

		return playerNames;
	}

	@Override
	public Move getMove(String playerName) {
		Move move;
		
		move = new Move(this.length, 0, 0);

		return move;
	}

	@Override
	public void update(java.util.ArrayList<Player> players) {
		//
	}
}
