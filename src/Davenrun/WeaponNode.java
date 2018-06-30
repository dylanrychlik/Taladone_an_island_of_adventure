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
public class WeaponNode {
     // Global Data Items
   
 protected  Weapon Info;
    
protected  WeaponNode Next;
    
    
// Constructor
    
public WeaponNode() 
    
{
        
Info = new Weapon ();
        
Next = null;
   
 } 
// End of constructor
    
    
// Modify method
    
public void Modify(WeaponNode ThisNode)
   
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
