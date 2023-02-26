import java.util.Scanner;
import java.util.ArrayList;

class TerminalDisplay extends Display {

	public TerminalDisplay() {
        }

	private void printHyphens() {
		int amountOfHyphens = 5 * this.getLength();

		for (int i = 0; i < amountOfHyphens; i++)
			System.out.print("=");
		System.out.println();
	}

	private int getNumber(String message) {
        	int     number;

                Scanner read;

                read   = new Scanner(System.in);
		System.out.print(message);
                number = read.nextInt();
                
                return number;
        }
	
	@Override
        public int getDimension() {
                return 2;
        }

	@Override
	public String[] getPlayers() {
                String[] playerNames = {"Jose", "Maria"};
                
		return playerNames;
        }

	@Override
	public Move getMove(String playerName) {
                int section, house;
                int row, column;
		int number;

                Move move;
                
                do {
			do {
                        	section = getNumber("Enter section, " + playerName + ": ");
                        	number  = getNumber("Enter number, "  + playerName + ": ");

			} while (!this.isOptionValid(section, number));
			
			section--; // The matrix index starts at zero

			house 	= this.board.getSection(section).index(number);

                        row     = this.convertToRow(section, house);
                        column  = this.convertToColumn(section, house);

                        move    = new Move(
                                                this.length,
                                                row,
                                                column
                                          );
                } while (
                                !this.board.isSectionFree(section) ||
                                !this.board.isHouseFree(section, house)
                        );

		this.board.getSection(section).getHouse(house).setFree(false); // chosen house
                return move;
        }
	
	@Override
	public void update(ArrayList<Player> players) {
                int section, house;

		this.printHyphens();
		System.out.print(this.board); /* Board representation in string form */
		this.printHyphens();

		for (Player player : players) {
			System.out.printf("%s\t\t%05d%n", player.getName(), player.getScore());
		}

		this.printHyphens();
        }
}
