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
public class Armornode {
  

    // Global Data Items
   
 protected  Armor Info;
    
protected  Armornode Next;
    
    
// Constructor
    
public Armornode() 
    
{
        
Info = new Armor();
        
Next = null;
   
 } 
// End of constructor
    
    
// Modify method
    
public void Modify(Armornode ThisNode)
   
 {
       
 Info.update(ThisNode.Info);
       
 Next = ThisNode.Next;
    }
 // End of Modify method
    
   
 // InputData method
   
 
     
// PrintMe method
     
public String Print()
   
 { 
return Info.toString();
} 
// End of PrintMe method
}
