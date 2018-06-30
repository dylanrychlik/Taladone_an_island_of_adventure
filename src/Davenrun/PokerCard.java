package Davenrun;

public class PokerCard {
    final public static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

	final public static String[] kinds = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

	private int suit;
	private int kind;

    public PokerCard(int i, int j) {
        suit = i;
		kind = j;
    }
    // Given the string representation of the suit and kind of the card, this
	// constructor sets up the instance variables of the object.
	public PokerCard(String s, String k) {
		suit = lookup(suits, s);
		kind = lookup(kinds, k);
	}

	// If item is an element of list, this method returns the FIRST
	// index in which item is stored. If it is not, -1 is returned.
	private static int lookup(String[] list, String item) {

		// Go through each item in the list.
		for (int i=0; i<list.length; i++) {
			if (list[i].equals(item))
				return i;
		}

		// Item was not found, so return -1.
		return -1;
	}

	// Returns true iff this is the same kind as the kind s.
	public boolean sameKind(String s) {
		return kind == lookup(kinds, s);
	}

    // Returns a string representation of a card.
	public String toString() {
		return kinds[kind]+" of "+suits[suit];
	}
}
