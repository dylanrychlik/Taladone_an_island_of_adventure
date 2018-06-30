
package Davenrun;

public class Armor {
        protected  String itemID;
    protected   String name, description; 
 protected   int cost;
 protected  int Armor; 

 
  public Armor(){
        this.itemID = "";
        this.name = "";
        this.description =  "";
        
        this.Armor = 0;
        this.cost = 0;
  }
    public Armor(String ID,String Name, String Description, int health, int Cost)
    {
   
        this.itemID = ID;
        this.name = Name;
        this.description =  Description;
        
        this.Armor = health;
        this.cost = Cost;
                }
    public void update(Armor thisThing)
{
   itemID = thisThing.itemID;
    name = thisThing.name;
     description = thisThing.description;
     Armor = thisThing.Armor;
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
    return Armor;
}
public void sethealthrating(int Healthrating)
{
    Healthrating = Armor;
}
public String toString()
{
        String outputString;
 outputString =  "\n Item_ID: " + itemID + "\n" + "Name: " + name + "\n" + "Description: " + description + "\n" + "Armor value: " +Armor + "\n"  + "cost: " + cost;

return outputString; 
    
}  
}
