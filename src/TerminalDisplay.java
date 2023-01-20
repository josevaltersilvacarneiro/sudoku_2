import java.util.Scanner;

class TerminalDisplay extends Display {

	public TerminalDisplay() {
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
                        section = getNumber("Enter section, " + playerName + ": ");
                        number  = getNumber("Enter number, "  + playerName + ": ");

			house 	= this.board.getSection(section).index(number);

                        row     = this.convertToRow(section, house);
                        column  = this.convertToColumn(section, house);

                        move    = new Move(
                                                this.length,
                                                row,
                                                column
                                          );
                } while (
                                !move.isOptionValid() ||
                                !this.board.isSectionFree(section) ||
                                !this.board.isHouseFree(section, house)
                        );

                return move;
        }
	
	@Override
	public void update() {
                String repr;

                repr = "";
                for (int i = 0; i < 30; i++)
                        repr += "=";
                repr += "\n";

		for (int row = 0; row < this.getLength(); row++) {
                        for (int column = 0; column < this.getLength(); column++) {
                                int section, house;

                                section = this.convertToSection(row, column);
                                house   = this.convertToHouse(row, column);

                                repr   += Integer.toString(this.board.getSection(section).index(house));
                        }
                        repr += "\n";
                }

                for (int i = 0; i < 30; i++)
                        repr += "=";

                System.out.println(repr);
        }
}
