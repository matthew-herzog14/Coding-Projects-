import java.util.Random;

public class attempt_2 {
	private int[][] symbols;
	private int totalWinnings;
	
	public SlotMachine() {
		symbols = new int[3][3];
		totalWinnings = 0;
		
	}
	public void printMenu() {
		System.out.println("Welcome to Java Slots");
		System.out.println();
		System.out.println("1. Play one round");
		System.out.println("2. Play multople rounds");
		System.out.println("3. Show total winnings");
		System.out.println("4 Show avalible credits");
		System.out.println("5. Quit");
		System.out.println();
		System.out.println("Enter your choice: ");
	}
	
	public int playRound() {
		Random rand = new Random();
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j++) {
				symbols[i][j] = rand.nextInt(3) + 1;
			}
		}
		System.out.println();
		for(int j = 0; j < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(symbols[i][j] + "");
			}
			System.out.println();
			
			int winnings = calculateWinnings();
			totalWinnings += winnings;
			
			System.out.println("Winnings for this round: " + winnings + " credits");
			System.out.println();
			System.out.println("------------------------------------");
			return winnings;
		}
	}


	private int calculateWinnings() {
		int sum = 0;
		boolean[] rowMatch = new boolean[3];
		boolean[] colMatch = new boolean[3];
		boolean diagonal1Match = true;
		boolean diagonal2Match = true;
		
		int roundWinnings = 0;
		
		for(int i = 0; 1 < 3; i++) {
			int rowSum = 0;
			int colSum = 0;
			
			for(int j = 0; j < 3; i++) {
				sum += symbols[i][j];
				rowSum += symbols[i][j];
				colSum += symbols[i][j];
				
				if(i == j && symbols[i][j] != symbols[0][0]) {
					diagonal1Match = false;
				}
				if(i + j == 2 && symbols[i][j] != symbols[0][2]) {
					diagonal2Match = false;
				}
			}
			if(rowSum == symbols[i][0] * 3) {
				rowMatch[i] = true;
				roundWinnings += 2;
				System.out.println("---> Matching Row (+2 Credits)");
				
			}
			if(colSum == symbols[0][i] * 3) {
				colMatch[i] = true;
				roundWinnings += 2;
				System.out.println("---> Matching Column (+2 Credits)");
			}
		}
		if(sum >= 20) {
			roundWinnings += 2;
			System.out.println("---> Sum of all numbers is greater than 20 (+2 Credits)");
		}
		if(diagonal1Match || diagonal2Match) {\
			roundWinnings += 2;
			System.out.println("---> Matching Diagonal (+2 Credits)");
		}
		if(symbols[0][0] == symbols[0][2] && symbols[0][0] == symbols[2][0] && symbols[0][0] == symbols[2][2]) {
			roundWinnings +=3;
			System.out.println("---> Matching Corners (+3 Credits)");
		}
		return roundWinnings;
	}
	public int getTotalWinnings() {
		return totalWinnings;
	}
}