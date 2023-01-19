import java.util.Scanner;

class TerminalDisplay extends Display {

        public int getDimension() {
                return 2;
        }

	public String[] getPlayers() {
                String[] playerNames = {"Jose", "Maria"};
                
		return playerNames;
        }

	private int getNumber() {
                int     number;

                Scanner read;

                read   = new Scanner(System.in);
                number = read.nextInt();
                
                return number;
        }
	
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
