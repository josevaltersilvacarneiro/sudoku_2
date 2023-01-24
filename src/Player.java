class Player implements Comparable<Player> {
	/*
	 * When instantiating a new Player object,
	 * the player's name must be passed as ar-
	 * gument. For example:
	 *
	 * Player newPlayer = new Player("John");
	 *
	 * Tha name and score attributes are pri-
	 * vate. To access them, use the methods
	 * below:
	 *
	 * newPlayerName = newPlayer.getName();
	 * newPlayerScore = newPlayer.getScore();
	 *
	 * The player's score can be changed.
	 * However, the value will be incre-
	 * mented, i.e. it's not possible to
	 * decrease it. See below:
	 *
	 * System.out.println(newPlayerScore); // 5
	 * newPlayer.setScore(5);
	 * System.out.println(newPlayer.getScore()); // 10
	 */

	private String name;
	private int score;

	public Player(String name) {
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	@Override
	public int compareTo(Player player) {
		if (this.getScore() > player.getScore())
			return -1;
		else if (this.getScore() < player.getScore())
			return 1;
		else
			return 0;
	}
}
