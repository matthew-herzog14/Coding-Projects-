/*
import java.util.Random

public class SlotMachine {
	private int[] top_row;
	private int[] bottom_row;
	private int[] middle_row;
	private int total_winnings;
	public void printMenu() {
		System.out.println("1. Play the slot machine once(this cost one credit)");
		System.out.println("2. Play the slot machine N times(this costs N credits");
		System.out.println("3. Print out the slot machines total winnnings");
		System.out.println("4. Print out the players current number of credits");
		System.out.println("5. Exit progam");
	}
	
	public SlotMachine() {
		top_row = new int[3];
	    middle_row = new int[3];
	    bottom_row = new int[3];
		total_winnings = 0;
	}
		
	private boolean check_corners() {
		return(top_row[0] == top_row[2] && bottom_row[0] == bottom_row[2]);
		
	}

	private boolean check_matching_columns() {
		return(top_row[0] == top_row[1] && top_row[1] == top_row[2]); 
			
		
			
		}
		
		
		
	

	private boolean check_matching_rows() {
		return(top_row[0] == middle_row[0] && middle_row[0] == bottom_row[0]);
		
		
	}

	private boolean diagonals_right_to_left() {
		return(top_row[2] == middle_row[1] && middle_row[1] == bottom_row[0]);
	}

	private boolean diagonals_left_to_right() {
		return(top_row[0] == middle_row[1] && middle_row[1] == bottom_row[2]);
	}

	private boolean sumOfRows() {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += top_row[i] +middle_row[i] + bottom_row[i];
		}
		return sum > 20;

	}		
	public int getTotalWinnings(){
		
		return total_winnings;
	}
	
	
	public int playRound() {
		fillArrayWithRandomValues(top_row);
		fillArrayWithRandomValues(middle_row);
		fillArrayWithRandomValues(bottom_row);
		
		System.out.println("----------");
		System.out.println(arrayToString(top_row));
		System.out.println("----------");
		System.out.println(arrayToString(middle_row));
		System.out.println("----------");
		System.out.println(arrayToString(bottom_row));
		System.out.println("----------");
		System.out.println();
		System.out.println("Total Winnings");
		System.out.println();
		System.out.println("--------------");
		
		int credits_won_in_round = 0;
		
		
		if(sumOfRows()) {
			  System.out.println("--> Sum of all numbers is greater than 20 (+2 credit)");
			  credits_won_in_round +=2;
			}
			if(diagonals_left_to_right()) {
			  System.out.println("--> Matching Diagonals (+2 credit)");
			  credits_won_in_round +=2;
			}
			if(diagonals_right_to_left()) {
			  System.out.println("--> Matching Diagonals (+2 credit)");
			  credits_won_in_round +=2;
			}
			if(check_matching_rows()) {
			  System.out.println("--> Matching Row (+2 credit)");
			  credits_won_in_round +=2;
			}
			if(check_matching_columns()) {
			  System.out.println("--> Matching Column (+2 credit)");
			  credits_won_in_round +=2;
			}
			if(check_corners()) {
			  System.out.println("--> Matching Corners (+2 credit)");
			  credits_won_in_round +=3;
			}
				System.out.println("you won a total of: " + credits_won_in_round + " credits");	
				total_winnings += credits_won_in_round;
			return credits_won_in_round;
			
				}
	
	
	private void fillArrayWithRandomValues(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(3) + 1;
	}
}
		
	private String arrayToString(int[] array) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i < array.length - 1) {
				sb.append("    ");
			}
		}
		return sb.toString();
	
	}
		
}

import java.util.Random;

public class SlotMachine{
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
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(symbols[i][j] + "");
			}
			System.out.println();
		}
		System.out.println();
		int winnings = calculateWinnings();
		totalWinnings += winnings;
			
		System.out.println("Winnings for this round: " + winnings + " credits");
		System.out.println();
		System.out.println("------------------------------------");
		return winnings;
		
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
				rowMatch[i] = true;1
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
		
		if(diagonal1Match || diagonal2Match) {
			roundWinnings += 2;
			System.out.println("---> Matching Diagonal (+2 Credits)");
		}
		if(symbols[0][0] == symbols[0][2] && symbols[0][0] == symbols[2][0] && symbols[0][0] == symbols[2][2]) {
			roundWinnings +=3;
			System.out.println("---> Matching Corners (+3 Credits)");
		}
		
		return roundWinnings;{
	}
	public int getTotalWinnings() {
		return totalWinnings;
	}
}


import java.util.Random;

public class SlotMachine {
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
        System.out.println("2. Play multiple rounds");
        System.out.println("3. Show total winnings");
        System.out.println("4. Show available credits");
        System.out.println("5. Quit");
        System.out.println();
        System.out.println("Enter your choice: ");
    }

    public int playRound() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
       
                symbols[i][j] = rand.nextInt(3) + 1;
                
            }
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(symbols[i][j] + " "); // Fixed println to print
            }
            System.out.println();
            System.out.println("------");
        }
        System.out.println();
        System.out.println("---------");
        int winnings = calculateWinnings();
        totalWinnings += winnings;

        System.out.println("Winnings for this round: " + winnings + " credits");
        System.out.println();
        
        return winnings;
    }

    private int calculateWinnings() {
        int sum = 0;
        boolean[] rowMatch = new boolean[3];
        boolean[] colMatch = new boolean[3];
        boolean diagonal1Match = true;
        boolean diagonal2Match = true;

        int roundWinnings = 0;

        for (int i = 0; i < 3; i++) { // Fixed the condition from 1 to < 3
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < 3; j++) { // Fixed the condition from i to j
                sum += symbols[i][j];
                rowSum += symbols[i][j];
                colSum += symbols[j][i]; // Fixed to use j as the column index

                if (i == j && symbols[i][j] != symbols[0][0]) {
                    diagonal1Match = false;
                }
                if (i + j == 2 && symbols[i][j] != symbols[0][2]) {
                    diagonal2Match = false;
                }
            }
            if (rowSum == symbols[i][0] * 3) {
                rowMatch[i] = true;
                roundWinnings += 2;
                System.out.println("---> Matching Row (+2 Credits)");
            }
            if (colSum == symbols[0][i] * 3) {
                colMatch[i] = true;
                roundWinnings += 2;
                System.out.println("---> Matching Column (+2 Credits)");
            }
        }
        if (sum >= 20) {
            roundWinnings += 2;
            System.out.println("---> Sum of all numbers is greater than 20 (+2 Credits)");
        }
        if (diagonal1Match || diagonal2Match) {
            roundWinnings += 2;
            System.out.println("---> Matching Diagonal (+2 Credits)");
        }
        if (symbols[0][0] == symbols[0][2] && symbols[0][0] == symbols[2][0] && symbols[0][0] == symbols[2][2]) {
            roundWinnings += 3;
            System.out.println("---> Matching Corners (+3 Credits)");
        }

        return roundWinnings;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }
}
*/

import java.util.Random;

public class SlotMachine {
    private int[][] symbols;
    public int TotalWinnings;

    public SlotMachine() {
        symbols = new int[3][3];
        TotalWinnings = 0;
    }

    public void printMenu() {
        System.out.println("Welcome to Java Slots");
        System.out.println();
        System.out.println("1. Play one round");
        System.out.println("2. Play multiple rounds");
        System.out.println("3. Show total winnings");
        System.out.println("4. Show available credits");
        System.out.println("5. Quit");
        System.out.println();
        System.out.println("Enter your choice: ");
    }

    public int playRound() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
       
                symbols[i][j] = rand.nextInt(3) + 1;
                
            }
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(symbols[i][j] + " ");
            }
            System.out.println();
            System.out.println("------");
        }
        System.out.println();
        System.out.println("---------");
        int winnings = calculateWinnings();
        TotalWinnings += winnings;

        System.out.println("Winnings for this round: " + winnings + " credits");
        System.out.println();
        
        return winnings;
    }
	private int calculateWinnings() {
		int roundWinnings = 0;
	    boolean[] rowMatched = new boolean[3];
	    boolean[] colMatched = new boolean[3];
	    
	    
	
	    
	
	    for (int i = 0; i < 3; i++) {
	        boolean rowMatch = true;
	        boolean colMatch = true;
	        
	        for (int j = 0; j < 3; j++) {
	            if (symbols[i][j] !=  symbols[i][0]) {
	            	rowMatch = false;
	            }
	
	            if(symbols[j][i] != symbols[0][i]){
	            	colMatch = false;
	            }
	            
	           if(rowMatch && symbols[i][0] != 0 && !rowMatched[i]) {
	        	   roundWinnings += 2;
	        	   System.out.println("---> Matching Row (+2 Credits)");
	        	   rowMatched[i] = true;  
	            }
	           if(colMatch && symbols[0][i] != 0 && !colMatched[i]) {
	        	   roundWinnings += 2;
	        	   System.out.println("---> Matching column (+2 Credits}");
	        	   colMatched[i] = true;
	           }
	        }
	
	        boolean diagonal1Match 
	    }
	
	    if (sum >= 20) {
	        roundWinnings += 2;
	        System.out.println("---> Sum of all numbers is greater than 20 (+2 Credits)");
	    }
	    if (diagonal1Match || diagonal2Match) {
	        roundWinnings += 2;
	        System.out.println("---> Matching Diagonal (+2 Credits)");
	    }
	    if (symbols[0][0] == symbols[0][2] && symbols[0][0] == symbols[2][0] && symbols[0][0] == symbols[2][2]) {
	        roundWinnings += 3;
	        System.out.println("---> Matching Corners (+3 Credits)");
	    }
	
	    return roundWinnings;
	}

	public int getTotalWinnings() {
		return TotalWinnings;
	}

}