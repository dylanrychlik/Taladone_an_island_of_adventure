/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author dylan
 */
public class DetermineHand {

    protected String suit, cardname;
   protected int cardnum;
   

    // int suit = 13;
    //private String CardValue[];
    public DetermineHand() {
        this.suit = "";
        this.cardname = "";
        this.cardnum = 0;

        //this.CardValue = new String[12];
    }

    public DetermineHand(String suit, String cardname, int cardnum) {
        this.suit = suit;
        this.cardname = cardname;
        this.cardnum = cardnum;

        //this.CardValue = new String[12];
    }

    public int cardNum() {
        this.cardnum = (int) Math.ceil(Math.random() * 52);
        return cardnum;
    }

    public int determineSuit(int num) {
      
        if (num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9 || num == 10 || num == 11
                || num == 12 || num == 13) {
            this.suit = "Clubs";
            this.cardnum = num;
         

        } else if (num == 14 || num == 15 || num == 16 || num == 17 || num == 18 || num == 19 || num == 20 || num == 21 || num == 22 || num == 23 || num == 24
                || num == 25 || num == 26) {
            this.suit = "Spades";
           this.cardnum = num - 13;
        
        } else if (num == 27 || num == 28 || num == 29 || num == 30 || num == 31 || num == 32 || num == 33 || num == 34 || num == 35 || num == 36 || num == 37
                || num == 38 || num == 39) {
            this.suit = "Hearts";
         this.cardnum = num - 26;

        } else if (num == 40 || num == 41 || num == 42 || num == 43 || num == 44 || num == 45 || num == 46 || num == 47 || num == 48 || num == 49 || num == 50
                || num == 51 || num == 52) {
            this.suit = "Diamonds";
            this.cardnum = num - 39;
          

        }

        return this.cardnum;
    }

    public String initializesuit(int num) {

        switch (num) {
            case 1:
                this.cardname = "Two of " + suit;
                break;
            case 2:
                this.cardname = "Three of " + suit;
                break;
            case 3:
                this.cardname = "Four of " + suit;
                break;
            case 4:
                this.cardname = "Five of " + suit;
                break;
            case 5:
                this.cardname = "Six of " + suit;
                break;
            case 6:
                this.cardname = "Seven of " + suit;
                break;
            case 7:
                this.cardname = "Eight of " + suit;
                break;
            case 8:
                this.cardname = "Nine of " + suit;
                break;
            case 9:
                this.cardname = "Ten of " + suit;
                break;
            case 10:
                this.cardname = "Jack of " + suit;
                break;
            case 11:
                this.cardname = "Queen of " + suit;
                break;
            case 12:
                this.cardname = "King of " + suit;
                break;
            case 13:
                this.cardname = "Ace of " + suit;
                break;
        }

        return this.cardname;
    }
}
