/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepokerjavafx;

public class DetermineHand {

    private String suit, cardname;
 
    // int suit = 13;
    //private String CardValue[];

    public DetermineHand() {
        this.suit = "";
        this.cardname = "";
     
        //this.CardValue = new String[12];
    }

    public int determineSuit(int num) {
        int suitnum = 0;
        if (num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9 || num == 10 || num == 11
                || num == 12 || num == 13) {
            this.suit = "Clubs";
            suitnum = num;
            cardname = initializesuit(suitnum);
        } else if (num == 14 || num == 15 || num == 16 || num == 17 || num == 18 || num == 19 || num == 20 || num == 21 || num == 22 || num == 23 || num == 24
                || num == 25 || num == 26) {
            this.suit = "Spades";
            suitnum = num - 13;
            cardname = initializesuit(suitnum);
        } else if (num == 27 || num == 28 || num == 29 || num == 30 || num == 31 || num == 32 || num == 33 || num == 34 || num == 35 || num == 36 || num == 37
                || num == 38 || num == 39) {
            this.suit = "Hearts";
            suitnum = num - 26;
            cardname = initializesuit(suitnum);
        } else if (num == 40 || num == 41 || num == 42 || num == 43 || num == 44 || num == 45 || num == 46 || num == 47 || num == 48 || num == 49 || num == 50
                || num == 51 || num == 52) {
            this.suit = "Diamonds";
            suitnum = num - 39;
            cardname = initializesuit(suitnum);
        }
        
        return suitnum;
    }

    public String initializesuit(int num) {
        String result = " ";
        switch (num) {
            case 1:
                result = "Two of " + suit;
                break;
            case 2:
                result = "Three of " + suit;
                break;
            case 3:
                result = "Four of " + suit;
                break;
            case 4:
                result = "Five of " + suit;
                break;
            case 5:
                result = "Six of " + suit;
                break;
            case 6:
                result = "Seven of " + suit;
                break;
            case 7:
                result = "Eight of " + suit;
                break;
            case 8:
                result = "Nine of " + suit;
                break;
            case 9:
                result = "Ten of " + suit;
                break;
            case 10:
                result = "Jack of " + suit;
                break;
            case 11:
                result = "Queen of " + suit;
                break;
            case 12:
                result = "King of " + suit;
                break;
            case 13:
                result = "Ace of " + suit;
                break;
        }

        return result;
    }
}
