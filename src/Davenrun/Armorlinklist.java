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
public class Armorlinklist {
      //globaldataitems
    protected  Armornode first, last;
     protected   Armorlinklist list; 
    protected int Length; 
 
    //Countructor 
  public Armorlinklist()
    {
        first = last = null; 
        Length = 0;
    }
    public  void addFirst(Armor ThisArmor)
    {
    Armornode newNode = new Armornode();
    newNode.Info.update(ThisArmor);    
      newNode.Next = first; 
        first = newNode;
       
        Length++;
        if (Length == 1) 
        {
            last = first; 
           
        }
        
           
    }
    public void addLast(Armor ThisArmor)
    {
        Armornode newNode = new Armornode();
        newNode.Info.update(ThisArmor);
        last.Next = newNode; 
        newNode.Next = null; 
        last = newNode; 
        Length++;
        if (Length == 1)
        {
            first = last; 
        }
       
    }
     public void addMiddle(int position, Armor ThisArmor)
        {
            int x; 
            Armornode Mark2 = first;
            Armornode Mark1 = null; 
            Armornode newNode; 
            if (position == 1) addFirst(ThisArmor);
            else 
            {
                for (x = 1; x < position; x++)
                {
                   if(Mark1.Next == null) break; 
                   else {Mark1 = Mark2; Mark2 = Mark2.Next;}}
            newNode = new Armornode();
            newNode.Info.update(ThisArmor);
            newNode.Next = Mark2;
            Length++;
            }
            }
     public void removefirst()
     {
         Armornode Current = first;
         first = first.Next;
         Destory(Current); Length--;
     }
     public void removeLast()
     {
         Armornode Current, Penultimate;
         if (first == last){Current = last; first = last = null; Destory(Current);}
         else 
         {
             Penultimate = first; 
             while (Penultimate.Next!= last) Penultimate = Penultimate.Next;
            Current = last; 
            Penultimate.Next = null; 
            Destory(Current); 
             last = Penultimate; 
         }
         Length--; 
     }
     public void removeMiddle(int Position)
     {
         int x = 1; 
         Armornode Current = first; 
         Armornode Prevcurrent = first;
         if (Position == 1) removefirst();
        if ((Position == Length)&&(first != last)) removeLast();
         if ((Position != 1) && (Position != Length))
         {
             while ((Current.Next != null)&&(x < Position)){Prevcurrent = Current; Current = Current.Next; x++;}
             Prevcurrent.Next = Current.Next; 
             Destory(Current);
                 
             if(Prevcurrent.Next == null) last = Prevcurrent;
             Length--;
         }
             
         
     }
     public void update(int position, Armor ThisArmor)
     {
         int x = 1; 
         Armornode Current = first; 
         while ((Current.Next != null) && (x < position)){Current = Current.Next; x++;}
         Current.Info.update(ThisArmor);
     }
     public  int getSize()
     {return Length;}
     public void clearList()
     {
         Armornode Current = first; 
         Armornode prevcurrent = first;
         while (Current != null){prevcurrent = Current; Current = Current.Next; Destory(prevcurrent);}
         {
             first = last= null; 
             Length = 0; 
             
         }
     }
             
     public  Armor getInfo(int position)
     {
         int x = 1; 
         Armornode Current = first; 
         while ((Current.Next != null)&& (x < position)){Current = Current.Next; x++;}
         return Current.Info;
     }
     public Armor[] toArray()
     {
         int x = 1; 
         Armor[] ArmorArray = new Armor[Length];
         Armornode Current = first;
         for (x = 1; ((Current != null) && (x <= Length));x++)
         {
             ArmorArray[x-1] = new Armor();
             ArmorArray[x-1].update(Current.Info);
             Current = Current.Next; 
         
         }
         return ArmorArray;
         
     }
     protected void finalize() throws java.lang.Throwable
     {
         Destory(this);
         
     }
     
     protected void Destory(Object ThisObj)
     {
         ThisObj = null; 
         System.gc();
     }
     public  Armorlinklist getList(){
         if (list == null) list = new Armorlinklist();
         return list;
     }
     
}
