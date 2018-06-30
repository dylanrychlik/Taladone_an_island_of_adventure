/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.beans.property.StringProperty;

/**
 *
 * @author The flash
 */
public class Player {
// int attackdamage = 100, armor = 0, bank = 100, Game_ID = 0, Jarl_level_count = 0;
    private static Player player; 
    private static String name;
    private static int numhealthptoion = 3;
   private static int health,attackdamage,  armor, bank,  Game_ID,  Jarl_level_count;
    private Player (){
        health = 100;
        name = " ";
        attackdamage =100; 
        armor = 100; 
        bank = 0; 
        Game_ID =0;
        Jarl_level_count =0;
                
   }
   public static Player getPlayer(){
         if (player == null) player = new Player();
         return player;
     }
   public static String Getname(){
       return name;
   }
   public static void setName(String Playername){
       name = Playername;
   }
public static int getpotions(){
     return numhealthptoion;
}
public static void addpotions(){
    numhealthptoion++;
}
public static void subtractpotions(){
    numhealthptoion--;
}
    public static int gethealth() {
     
        return health;
    }
    public static int sethealth(final int healtheffect) {
      health =  healtheffect;
      return health;
    }
    public static void addhealth(final int healtheffect) {
      health = health + healtheffect;
    }
      public static  void subtracthealth(final int healtheffect) {
      health = health - healtheffect;
    } 
    public static int getarmor() {
    
        return armor;
    }

    public static void subtractarmor(final int armoreffect) {
     armor = armor - armoreffect;
    }
    public static void addactarmor(final int armoreffect) {
     armor = armor + armoreffect;
    }
     public static int setarmor(int armoreffect){
        armor= armoreffect;
        return armor;
     }
           
    public static int getbank() {
     
        return bank;
    }

    public static int subtractbank(int bankeffect) {
       bank = bank - bankeffect;
       return bank;
    }
        public static int setbank(int bankeffect){
   bank = bankeffect;
   return bank;
        }   
     public static int addbank(int bankeffect) {
       bank = bank + bankeffect;
       return bank;
    } 
    public static int getJarl_level_count () {
  
        return Jarl_level_count;
    }
 public static int setlevel(int level) {
  Jarl_level_count = level;
        return Jarl_level_count;
    }
    public static void setJarl_level_count() {
     Jarl_level_count++;
     // this.Jarl_level_count = Jarl_level_count;
    }
            

    public static int getattackdamage () {
        
        return attackdamage;
    }

    public static void setattackdamage(final int damage ) {
       attackdamage = attackdamage + damage;
       
    }
    public static int setATTACKDAMAGE(final int damage ){
         attackdamage =  damage;
         return attackdamage;
    }
                  
             
                   public String toString() {
       // String outputString;
        //outputString = Jarl_level_count + "\n";

       // return outputString;
       return null;

    }

    
}
