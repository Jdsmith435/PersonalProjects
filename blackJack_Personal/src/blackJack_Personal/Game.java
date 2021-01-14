package blackJack_Personal;

import java.util.Scanner;

public class Game {
	
	public static Scanner sc = new Scanner(System.in);
	public static int input;
	
	public static void main (String [] args){
		 init();
	}
	
	public static void init() {
		Dealer.reShuffel();
		Dealer.dealPlayer();
		Dealer.dealDealer();
		Dealer.dealPlayer();
		Dealer.dealDealer();
		Dealer.checkHand(Dealer.dealerHand);
		Dealer.checkHand(Dealer.playerHand);
		System.out.println("Hit?");
		dealerAction();
	}
	
	public static void dealerAction() {
		input = sc.nextInt();
		if(input == 1) {
			Dealer.addCard(Dealer.playerHand);
		}
		Dealer.checkHand(Dealer.playerHand);
	}
}
