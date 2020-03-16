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
public class DetermineRank extends DetermineHand {

    protected int cardvalue, cardtotal;

    public DetermineRank() {
        this.cardtotal = 0;

        this.cardvalue = 0;

        //this.CardValue = new String[12];
    }

    public DetermineRank(String suit, String card, int cardnum, int cardvalue, int cardtotal) {
        super(suit, card, cardnum);
        this.cardtotal = cardtotal;

    }

    public int CardTotal() {

        this.cardtotal = this.cardtotal + this.cardvalue;
       // result(this.cardtotal);
        return this.cardtotal;
    }

    public void result(int cardtotal) {
        if (cardtotal == 21) {
            System.out.println("You Max out Total is " + cardtotal);

        } else if (cardtotal > 21) {
            System.out.println("You bust Total is " + cardtotal);

        } else {
            System.out.println("Total is " + cardtotal);

        }
    }

    public int CardNumber(int cardnum) {
        switch (cardnum) {
            case 1:
                this.cardvalue = 2;
                break;
            case 2:
                this.cardvalue = 3;
                break;
            case 3:
                this.cardvalue = 4;
                break;
            case 4:
                this.cardvalue = 5;
                break;
            case 5:
                this.cardvalue = 6;
                break;
            case 6:
                this.cardvalue = 7;
                break;
            case 7:
                this.cardvalue = 8;
                break;
            case 8:
                this.cardvalue = 9;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                this.cardvalue = 10;
                break;
            case 13:
              
               this.cardvalue = 1;
            default:
                break;
        }
        return this.cardvalue;
    }
    public int getAceValue(int val)
    {
                  
          if (val + 10 <= 21 ){
              val = val + 10;
              System.out.println("High ace is: " + val);
               this.cardvalue = 11;

          return val;
          } else {
          return 1;
          }      
    
}
}
