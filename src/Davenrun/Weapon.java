/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;

/**
 *
 * @author The flash
 */
public class Weapon {
      protected   String itemID;
      protected String name, description; 
   protected int cost;
  protected int attackdamage; 

    /**
     *
     * @param Name
     * @param Description
     * @param Cost
     * @param health
     */
  public Weapon(){
        this.itemID = "";
        this.name = "";
        this.description =  "";
        
        this.attackdamage = 0;
        this.cost = 0;
  }
  
    public Weapon(String ID,String Name, String Description, int health, int Cost)
    {
   
        this.itemID = ID;
        this.name = Name;
        this.description =  Description;
        
        this.attackdamage = health;
        this.cost = Cost;
                }
    public void update(Weapon thisThing)
{
   itemID = thisThing.itemID;
    name = thisThing.name;
     description = thisThing.description;
     attackdamage = thisThing.attackdamage;
     cost = thisThing.cost;
  
}
     public String getID()
    {
        return itemID;
    }
public void setID(String ID)
{
    ID = itemID;
}
    public String getname()
    {
        return name;
    }

public String setname(String Name)
{
   this.name = Name;
   return Name;
}
public String getdescription()
{
 return description;   
}
public void setdescription(String Description)
{
    Description = description;
}
public int getcost()
{
    return cost;
}
public void setcost(int Cost)
{
    Cost = cost; 
}
public int gethealthrating()
{
    return attackdamage;
}
public void sethealthrating(int Healthrating)
{
    Healthrating = attackdamage;
}
public String toString()
{
        String outputString;
 outputString =  "\n Item_ID: " + itemID + "\n" + "Name: " + name + "\n" + "Description: " + description + "\n" + "Attack damage value: " + attackdamage + "\n"  + "cost: " + cost;

return outputString; 
    
}  
}
