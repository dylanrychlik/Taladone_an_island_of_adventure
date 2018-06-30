package Davenrun;

/**
 *
 * @author Dylan
 */
public class goodItem {
   protected String itemID;
    protected  String name, description; 
  protected int cost;
   protected int healthrating; 

    /**
     *
     * @param Name
     * @param Description
     * @param Cost
     * @param health
     */
  public goodItem(){
        this.itemID = "";
        this.name = "";
        this.description =  "";
        
        this.healthrating = 0;
        this.cost = 0;
  }
  
  public goodItem(int health){
      this.healthrating = health;
  }
    public goodItem(String ID,String Name, String Description, int health, int Cost)
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
 outputString =  "\n Item_ID: " + itemID + "\n" + "Name: " + name + "\n" + "Description: " + description + "\n" + "Health value: " + healthrating + "\n"  + "cost: " + cost;

return outputString; 
    
}  
}

    

