/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplepokerjavafx;

import java.util.Arrays;

/**
 *
 * @author dylan
 */
public class DetermineRank {

    private String Hand[];
    private int value[];

    public DetermineRank(String Hand[]) {
        this.Hand = Hand;
        this.value = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    }

    public void printHand() {
        for (int x = 0; x < Hand.length; x++) {
            System.out.println(Hand[x]);
        }
        DetermineHighCard();
    }

    public int[] ExtractRank() {
        String[] cardspliter1 = Hand[0].split(" of ");
        String[] cardspliter2 = Hand[1].split(" of ");
        String[] cardspliter3 = Hand[2].split(" of ");
        String[] cardspliter4 = Hand[3].split(" of ");
        String[] cardspliter5 = Hand[4].split(" of ");
        int[] Intarray = new int[5];
        Intarray[0] = DetermineHighCard(cardspliter1[0]);
        Intarray[1] = DetermineHighCard(cardspliter2[0]);
        Intarray[2] = DetermineHighCard(cardspliter3[0]);
        Intarray[3] = DetermineHighCard(cardspliter4[0]);
        Intarray[4] = DetermineHighCard(cardspliter5[0]);
        return Intarray;
    }

    public String[] ExtractSuit() {
        String[] cardspliter1 = Hand[0].split(" of ");
        String[] cardspliter2 = Hand[1].split(" of ");
        String[] cardspliter3 = Hand[2].split(" of ");
        String[] cardspliter4 = Hand[3].split(" of ");
        String[] cardspliter5 = Hand[4].split(" of ");
        String[] Stringarray = new String[5];
        Stringarray[0] = cardspliter1[1];
        Stringarray[1] = cardspliter2[1];
        Stringarray[2] = cardspliter3[1];
        Stringarray[3] = cardspliter4[1];
        Stringarray[4] = cardspliter5[1];
        return Stringarray;
    }

    public boolean royalFlush() {
        int[] Intarray = ExtractRank();
        if (Intarray[0] == 9 && Intarray[1] == 10 && Intarray[2] == 11
                && Intarray[3] == 12 && Intarray[4] == 13) {
            return true;
        } else {
            return false;
        }
    }

    public boolean straightFlush() {
        int[] Intarray = ExtractRank();
        String[] Stringarray = ExtractSuit();
        for (int counter = 1; counter < 5; counter++) {
            if (!Stringarray[0].equals(Stringarray[counter])) {
                return false;
            }
        }
        for (int counter2 = 1; counter2 < 5; counter2++) {
            if (Intarray[counter2 - 1] != (Intarray[counter2] - 1)) {
                return false;
            }

        }
        return true;

    }

    public boolean Fourofakind() {

        int[] Intarray = ExtractRank();

        Arrays.sort(Intarray);
        int count = 1;
        for (int x = 1; x < Intarray.length; x++) {
            if (Intarray[x] == Intarray[x - 1]) {
                count++;
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fullHouse() {

        int[] Intarray = ExtractRank();

        int comparison = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (Intarray[counter - 1] == Intarray[counter]) {
                comparison++;
            }
        }
        if (comparison == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Flush() {

        String[] Stringarray = ExtractSuit();

        for (int counter = 1; counter < 5; counter++) {
            if (!Stringarray[0].equals(Stringarray[counter])) {
                return false;
            }
        }

        return true;
    }

    public boolean Sequence() {

        int[] Intarray = ExtractRank();

        for (int counter1 = 1; counter1 < 5; counter1++) {
            if (Intarray[counter1 - 1] != (Intarray[counter1] - 1)) {
                return false;
            }

        }
        return true;
    }

    public boolean Triple() {

        int[] Intarray = ExtractRank();

        Arrays.sort(Intarray);
        for (int x = 1; x < Intarray.length - 1; x++) {
            if (Intarray[x - 1] == Intarray[x] && Intarray[x] == Intarray[x + 1]) {
                return true;

            }
        }

        return false;

    }
// checks for two pairs

    public boolean twoPairs() {
        int[] Intarray = ExtractRank();

        int check = 0;
        for (int x = 1; x < Intarray.length; x++) {

            if (Intarray[x] == Intarray[x - 1]) {
                check++;
            }
        }

        if (check == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsPair() {

        String[] cardspliter1 = Hand[0].split(" of ");
        String[] cardspliter2 = Hand[1].split(" of ");
        String[] cardspliter3 = Hand[2].split(" of ");
        String[] cardspliter4 = Hand[3].split(" of ");
        String[] cardspliter5 = Hand[4].split(" of ");
        if (cardspliter1[0].equals(cardspliter2[0]) || cardspliter1[0].equals(cardspliter3[0])
                || cardspliter1[0].equals(cardspliter4[0]) || cardspliter1[0].equals(cardspliter5[0])
                || cardspliter2[0].equals(cardspliter1[0]) || cardspliter2[0].equals(cardspliter3[0])
                || cardspliter2[0].equals(cardspliter4[0]) || cardspliter2[0].equals(cardspliter5[0])
                || cardspliter3[0].equals(cardspliter1[0]) || cardspliter3[0].equals(cardspliter2[0])
                || cardspliter3[0].equals(cardspliter4[0]) || cardspliter3[0].equals(cardspliter5[0])
                || cardspliter4[0].equals(cardspliter1[0]) || cardspliter4[0].equals(cardspliter2[0])
                || cardspliter4[0].equals(cardspliter3[0]) || cardspliter4[0].equals(cardspliter5[0])
                || cardspliter5[0].equals(cardspliter1[0]) || cardspliter5[0].equals(cardspliter2[0])
                || cardspliter5[0].equals(cardspliter3[0]) || cardspliter5[0].equals(cardspliter4[0])) {
            return true;
        } else {
            return false;
        }

    }

    public int DetermineHighCard(String rank) {
          
        switch (rank) {

            case "Two":
                return 1;

            case "Three":
                return 2;

            case "Four":
                return 3;

            case "Five":
                return 4;

            case "Six":
                return 5;

            case "Seven":
                return 6;

            case "Eight":
                return 7;

            case "Nine":
                return 8;

            case "Ten":
                return 9;

            case "Jack":
                return 10;

            case "Queen":
                return 11;

            case "King":
                return 12;

            case "Ace":
                return 13;

        }

        return 0;
    }

    public String DetermineHighCard() {
        int temp, high = 0;
        String[] cardrank;
        for (int x = 0; x < Hand.length; x++) {
            cardrank = Hand[x].split(" of ");

            temp = DetermineHighCard(cardrank[0]);

            if (temp > high) {
                high = temp;
            }
        }
        switch (high) {
            case 1:
               return "highest card is Two";
               
            case 2:
                return "highest card is Three";
              
            case 3:
                return "highest card is Four";
            
            case 4:
               return "highest card is Five";
              
            case 5:
                return "highest card is Six";
               
            case 6:
                return "highest card is Seven";
             
            case 7:
               return "highest card is Eight";
                
            case 8:
                return "highest card is Nine";
              
            case 9:
                return "highest card is Ten";
               
            case 10:
                return "highest card is Jack";
             
            case 11:
              return "highest card is Queen";
              
            case 12:
                return "highest card is King";
               
            case 13:
                return "highest card is Ace";
                
        }
       return " ";
    }

}
