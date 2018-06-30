
package Davenrun;


public class Weaponlinklist {
      //globaldataitems
protected WeaponNode first, last;
      private  Weaponlinklist list; 
   protected int Length; 

    //Countructor 
  public Weaponlinklist()
    {
        first = last = null; 
        Length = 0;
    }
    public  void addFirst(Weapon ThisWeapon)
    {
       WeaponNode newNode = new WeaponNode();
    newNode.Info.update(ThisWeapon);    
      newNode.Next = first; 
        first = newNode;
       
        Length++;
        if (Length == 1) 
        {
            last = first; 
           
        }
        
           
    }
    public void addLast(Weapon ThisWeapon)
    {
        WeaponNode newNode = new WeaponNode();
        newNode.Info.update(ThisWeapon);
        last.Next = newNode; 
        newNode.Next = null; 
        last = newNode; 
        Length++;
        if (Length == 1)
        {
            first = last; 
        }
       
    }
     public void addMiddle(int position, Weapon ThisWeapon)
        {
            int x; 
            WeaponNode Mark2 = first;
            WeaponNode Mark1 = null; 
            WeaponNode newNode; 
            if (position == 1) addFirst(ThisWeapon);
            else 
            {
                for (x = 1; x < position; x++)
                {
                   if(Mark1.Next == null) break; 
                   else {Mark1 = Mark2; Mark2 = Mark2.Next;}}
            newNode = new WeaponNode();
            newNode.Info.update(ThisWeapon);
            newNode.Next = Mark2;
            Length++;
            }
            }
     public void removefirst()
     {
         WeaponNode Current = first;
         first = first.Next;
         Destory(Current); Length--;
     }
     public void removeLast()
     {
         WeaponNode Current, Penultimate;
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
         WeaponNode Current = first; 
         WeaponNode Prevcurrent = first;
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
     public void update(int position, Weapon ThisWeapon)
     {
         int x = 1; 
         WeaponNode Current = first; 
         while ((Current.Next != null) && (x < position)){Current = Current.Next; x++;}
         Current.Info.update(ThisWeapon);
     }
     public  int getSize()
     {return Length;}
     public void clearList()
     {
         WeaponNode Current = first; 
         WeaponNode prevcurrent = first;
         while (Current != null){prevcurrent = Current; Current = Current.Next; Destory(prevcurrent);}
         {
             first = last= null; 
             Length = 0; 
             
         }
     }
             
     public  Weapon getInfo(int position)
     {
         int x = 1; 
         WeaponNode Current = first; 
         while ((Current.Next != null)&& (x < position)){Current = Current.Next; x++;}
         return Current.Info;
     }
     public Weapon[] toArray()
     {
         int x = 1; 
         Weapon[] WeaponArray = new Weapon[Length];
         WeaponNode Current = first;
         for (x = 1; ((Current != null) && (x <= Length));x++)
         {
             WeaponArray[x-1] = new Weapon();
             WeaponArray[x-1].update(Current.Info);
             Current = Current.Next; 
         
         }
         return WeaponArray;
         
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
     public  Weaponlinklist getList(){
         if (list == null){
             list = new Weaponlinklist();
         }
         return list;
     }
}
