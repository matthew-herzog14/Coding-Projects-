/*
public class Card {

	private int rank;
	private String suit;
	
	public Card(int r, String s) {
		this.rank = r;
		this.suit = s;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public String toString() {
		return this.rank + " of " +this.suit;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
}
*/

if(sumOfRows()) {
  System.out.println("--> Sum of all numbers is greater than 20 (+2 credit)");
  total_winnings +=2;
}
if(diagonals_left_to_right()) {
  System.out.println("--> Matching Diagonals (+2 credit)");
  total_winnings +=2;
}
if(diagonals_right_to_left()) {
  System.out.println("--> Matching Diagonals (+2 credit)");
  total_winnings +=2;
}
if(check_matching_rows()) {
  System.out.println("--> Matching Row (+2 credit)");
  total_winnings +=2;
}
if(check_matching_columns()) {
  System.out.println("--> Matching Column (+2 credit)");
  total_winnings +=2;
}
if(check_corners()) {
  System.out.println("--> Matching Corners (+2 credit)");
  total_winnings +=3;
}