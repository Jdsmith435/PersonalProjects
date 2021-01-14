package blackJack_Personal;

public class Card {
	int card;
	int kind;

	public Card(int card, int kind) {
		this.card = card;
		this.kind = kind;
	}

	@Override
	public String toString() {
		if (kind == 0) {
			return card + " of Spades";
		} else if (kind == 1) {
			return card + " of Clubs";
		} else if (kind == 2) {
			return card + " of Hearts";
		} else if (kind == 3) {
			return card + " of diamonds";
		} else {
			return "Empty Hand";
		}
	}
	
	public int getCard() {
		return this.card;
	}
}
