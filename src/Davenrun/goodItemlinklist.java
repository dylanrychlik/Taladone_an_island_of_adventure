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
public class goodItemlinklist {
     //globaldataitems
    protected  goodItemNode first, last;
     protected goodItemlinklist list;
       protected   goodItemNode newNode = new goodItemNode();
    private int Length; 
    //Countructor 
  public goodItemlinklist()
    {
        first = last = null; 
        Length = 0;
    }
    public void addFirst(goodItem ThisgoodItem)
    {
       
    newNode.Info.update(ThisgoodItem);    
        newNode.Next = first; 
        first = newNode;
       
        Length++;
        if (Length == 1) 
        {
            last = first; 
           
        }
        
           
    }
    public  void addLast(goodItem ThisgoodItem)
    {
        goodItemNode newNode = new goodItemNode();
        newNode.Info.update(ThisgoodItem);
        last.Next = newNode; 
        newNode.Next = null; 
        last = newNode; 
        Length++;
        if (Length == 1)
        {
            first = last; 
        }
       
    }
     public void addMiddle(int position, goodItem ThisgoodItem)
        {
            int x; 
            goodItemNode Mark2 = first;
            goodItemNode Mark1 = null; 
            goodItemNode newNode; 
            if (position == 1) addFirst(ThisgoodItem);
            else 
            {
                for (x = 1; x < position; x++)
                {
                   if(Mark1.Next == null) break; 
                   else {Mark1 = Mark2; Mark2 = Mark2.Next;}}
            newNode = new goodItemNode();
            newNode.Info.update(ThisgoodItem);
            newNode.Next = Mark2;
            Length++;
            }
            }
     public void removefirst()
     {
         goodItemNode Current = first;
         first = first.Next;
         Destory(Current); Length--;
     }
     public void removeLast()
     {
         goodItemNode Current, Penultimate;
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
         goodItemNode Current = first; 
         goodItemNode Prevcurrent = first;
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
     public void update(int position, goodItem ThisgoodItem)
     {
         int x = 1; 
         goodItemNode Current = first; 
         while ((Current.Next != null) && (x < position)){Current = Current.Next; x++;}
         Current.Info.update(ThisgoodItem);
     }
     public  int getSize()
     {return Length;}
     public void clearList()
     {
         goodItemNode Current = first; 
         goodItemNode prevcurrent = first;
         while (Current != null){prevcurrent = Current; Current = Current.Next; Destory(prevcurrent);}
         {
             first = last= null; 
             Length = 0; 
             
         }
     }
             
     public  goodItem getInfo(int position)
     {
         int x = 1; 
         goodItemNode Current = first; 
         while ((Current.Next != null)&& (x < position)){Current = Current.Next; x++;}
         return Current.Info;
     }
     public goodItem[] toArray()
     {
         int x = 1; 
         goodItem[] goodItemArray = new goodItem[Length];
         goodItemNode Current = first;
         for (x = 1; ((Current != null) && (x <= Length));x++)
         {
             goodItemArray[x-1] = new goodItem();
             goodItemArray[x-1].update(Current.Info);
             Current = Current.Next; 
         
         }
         return goodItemArray;
         
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
     public goodItemlinklist getList(){
         if (list == null) list = new goodItemlinklist();
         return list;
     }
}
