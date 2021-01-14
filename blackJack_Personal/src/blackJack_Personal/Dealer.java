package blackJack_Personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer {
	
	private static int[] spades = new int[13];
	private static int[] clubs = new int[13];
	private static int[] hearts = new int[13];
	private static int[] diamonds = new int[13];
	public static List<Card> playerHand = new ArrayList<Card>();
	public static List<Card> dealerHand = new ArrayList<Card>();

	static Random rdm = new Random();
	public static boolean over21 = false;
	public static boolean blackJack = false;
	static int ptotal;
	static int dtotal;
	
	
	public static void reShuffel() {
		for( int i = 0; i<13; i++) {
			spades[i] = i + 1;
			clubs[i] = i + 1;
			hearts[i] = i + 1;
			diamonds[i] = i + 1;
		}
	}
	
	public static void dealPlayer() {
		int card = rdm.nextInt(12);
		int cardType = rdm.nextInt(3);
		
		if(cardType == 0) {
			//spades
			do {
				card = rdm.nextInt(12);
			}while (spades[card] == 0 );
			spades[card] = 0;
			dealerHand.add(new Card(card, cardType));
			
		} else if ( cardType == 1) {
			//clubs
			do {
				card = rdm.nextInt(12);
			}while (clubs[card] == 0 );
			clubs[card] = 0;
			dealerHand.add(new Card(card, cardType));
			
		} else if (cardType == 2) {
			//hearts
			do {
				card = rdm.nextInt(12);
			}while (hearts[card] == 0 );
			hearts[card] = 0;
			dealerHand.add(new Card(card, cardType));
			
		}else {
			//diamonds
			do {
				card = rdm.nextInt(12);
			}while (diamonds[card] == 0 );
			diamonds[card] = 0;
			dealerHand.add(new Card(card, cardType));
		}
	}
	
	public static void dealDealer() {
		int card = rdm.nextInt(12);
		int cardType = rdm.nextInt(3);
		
		if(cardType == 0) {
			//spades
			do {
				card = rdm.nextInt(12);
			}while (spades[card] == 0 );
			spades[card] = 0;
			dealerHand.add(new Card(card, cardType));
			
		} else if ( cardType == 1) {
			//clubs
			do {
				card = rdm.nextInt(12);
			}while (clubs[card] == 0 );
			clubs[card] = 0;
			dealerHand.add(new Card(card, cardType));
			
		} else if (cardType == 2) {
			//hearts
			do {
				card = rdm.nextInt(12);
			}while (hearts[card] == 0 );
			hearts[card] = 0;
			dealerHand.add(new Card(card, cardType));
			
		}else {
			//diamonds
			do {
				card = rdm.nextInt(12);
			}while (diamonds[card] == 0 );
			diamonds[card] = 0;
			dealerHand.add(new Card(card, cardType));
		}
	}
	
	public static int count (List<Card> hand) {
		int cardCount = 0;
		for( int i = 0; i<hand.size(); i++) {
			cardCount += hand.get(i).getCard();
		}
		return cardCount;
	}
	
	public static void checkHand(List<Card> hand) {
		hand.forEach(x -> System.out.println(x.toString()));
	}
	
	public static void checkTotal() {
		if( ptotal < 21 ) {
			blackJack = false;
			over21 = false;
			System.out.println(ptotal + ". You need " + (21-ptotal) + " until 21");
		} else if (ptotal == 21) {
			blackJack = true;
			over21 = false;
			System.out.println("Blackjack");
		} else {
			blackJack = false;
			over21 = true;
			System.out.println(ptotal + " over!");
		}
	}
	
	public static void addCard(List<Card> hand) {
		int card = rdm.nextInt(12);
		int cardType = rdm.nextInt(3);
		
		if(cardType == 0) {
			//spades
			do {
				card = rdm.nextInt(12);
			}while (spades[card] == 0 );
			spades[card] = 0;
			hand.add(new Card(card, cardType));
			
		} else if ( cardType == 1) {
			//clubs
			do {
				card = rdm.nextInt(12);
			}while (clubs[card] == 0 );
			clubs[card] = 0;
			hand.add(new Card(card, cardType));
			
		} else if (cardType == 2) {
			//hearts
			do {
				card = rdm.nextInt(12);
			}while (hearts[card] == 0 );
			hearts[card] = 0;
			hand.add(new Card(card, cardType));
			
		}else {
			//diamonds
			do {
				card = rdm.nextInt(12);
			}while (diamonds[card] == 0 );
			diamonds[card] = 0;
			hand.add(new Card(card, cardType));
		}
	}
}
