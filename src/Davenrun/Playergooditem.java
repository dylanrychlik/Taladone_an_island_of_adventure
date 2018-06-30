/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Davenrun;


public class Playergooditem {
    String itemID;
    String name, description; 
int cost;
int healthrating; 

  
  public Playergooditem(){
        this.itemID = "";
        this.name = "";
        this.description =  "";
        
        this.healthrating = 0;
        this.cost = 0;
  }
    public Playergooditem(String ID,String Name, String Description, int health, int Cost)
    {
   
        this.itemID = ID;
        this.name = Name;
        this.description =  Description;
        
        this.healthrating = health;
        this.cost = Cost;
                }
    public void update(goodItem thisThing)
{
   itemID = thisThing.itemID;
    name = thisThing.name;
     description = thisThing.description;
     healthrating = thisThing.healthrating;
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
public void setname(String Name)
{
    Name = name;
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
    return healthrating;
}
public void sethealthrating(int Healthrating)
{
    Healthrating = healthrating;
}
public String toString()
{
        String outputString;
 outputString =  itemID + "\n" + name + "\n" + description + "\n" + healthrating + "\n" + cost;

return outputString; 
    
} 
}
