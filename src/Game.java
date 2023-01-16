public class Game {
	boolean quit;
	int next_player;
	int num_of_players = 2;

	Player players[] = new Player[this.num_of_players];
	Display display;

	public Game() {
		for (int i = 0; i < this.num_of_players; i++) {
			this.players[i] = new Player();

			this.players[i].name = "José";
			this.players[i].score = 0;
		}
		display = new Display();
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
		System.out.println(player.name + " playing");
	}
}
