package Davenrun;

import Davenrun.PokerCard;
import java.util.*;
public class CardList {

	final static int TOTALCARDS = 52;

	private PokerCard[] myCards;
	private int numCards;

	// Empty Card List, capable of storing up tp 52 cards.
	public CardList() {
		myCards = new PokerCard[TOTALCARDS];
		numCards = 0;
	}

	// Adds c as the last card in the CardList.
	public void addCard(PokerCard c) {
		myCards[numCards] = c;
		numCards++;
	}

	// Removes the last card in the CardList and returns it.

    /**
     *
     * @return
     */
    	public PokerCard removeCard() {
		PokerCard c = myCards[numCards-1];
		numCards--;
		return c;
	}

	// Pre-condition: 0 <= index < numCards for this object.
	// Removes a card from the index slot and returns it.
	public PokerCard removeCard(int index) {
		PokerCard c = myCards[index];
		myCards[index] = myCards[numCards-1];
		numCards--;
		return c;
	}

	// Shuffles this collections of cards in random order.
	public void shuffle() {

		Random r = new Random();

		// Repeatedly swap randomly chosen cards.
		for (int i=0; i<200; i++) {
			int place1 = Math.abs(r.nextInt() % numCards);
			int place2 = Math.abs(r.nextInt() % numCards);
			PokerCard temp = myCards[place1];
			myCards[place1] = myCards[place2];
			myCards[place2] =  temp;
		}
	}

	// Returns the number of cards in this list that match kind.
	public int numMatches(String kind) {

		// Go through each card.
		int cnt=0;
		for (int i = 0; i<numCards; i++)
			if (myCards[i].sameKind(kind))
				cnt++;

		// Return the number of matches.
		return cnt;
	}

	// Create the a full deck of cards in this CardList.
	public void makeDeck() {

		for (int i=0; i<4; i++)
			for (int j=0; j<13; j++)
				myCards[13*i+j] = new PokerCard(i,j);

		numCards = 52;
	}

    // Returns a string representation of this CardList.
	public String toString() {
		String ans = new String();
		for (int i=0; i<numCards; i++)
			ans = ans + (i+1) + ". " + myCards[i] +"\n";

		return ans;
	}
}