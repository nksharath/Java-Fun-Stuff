
/*
 * PatialLinkedListImpl.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : A class that implements PatialLinkedList interface
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/14/2012 10.45 AM
*
*/
import java.util.ListIterator;
import java.util.Iterator;


public class PatialLinkedListImpl implements PatialLinkedList
{
    //Creating the first element of linked list , and declaring counter
    MyLinkedList nodeFirst;
    int counter=0;
    
    //Non Parameterised constructor
    public PatialLinkedListImpl()
    {
        nodeFirst=null;
        
    }
    /*
     * add         adds an object to the linked list
     * @param   e  Object 
     */
   public boolean add(Object e)
   {
       try
       {
       
       MyLinkedList node=new MyLinkedList(e);
       node.nextData=null;

       MyLinkedList current=nodeFirst;
       if (nodeFirst == null) {
           nodeFirst = node;
           
       } else {
            while(current.nextData!=null)
            {  
                current=current.nextData;
            }
            current.nextData=node;
            
       }
       counter++;
       }
       catch(Exception err)
       {
           System.out.println("hi"+err);
           return false;
           
       }
       
       return true;
   }
   /*
     * add         adds an object to the linked list at a given index
     * @param   index  int
     * @param   Element Object
     */
   public void add(int index,Object Element)
   {
       MyLinkedList current=nodeFirst;
       MyLinkedList node=new MyLinkedList(Element);
               int i=1;
       while(i<index)
       {
        current=current.nextData;
        i++;
       }
       node.nextData=current.nextData;
       current.nextData=node;
       counter++;
   }
 
   /*
     * remove         removes an object from the linked list
     * @param   o  Object 
     */
   
   public boolean remove(Object o)
   {
     if(nodeFirst==null)
         return false;     
      MyLinkedList current=nodeFirst.nextData;
      MyLinkedList prev=nodeFirst;
      
      while(current!=null)
      {
          
          if(current.Data.equals(o))
          {
              prev.nextData=current.nextData;
              return true;
              
          }
          prev=current;
          current=current.nextData;
          
      }
      return false;
   } 
   /*
     * removeLastOccurence         removes the Last Occurence of an object
     * @param   o  Object 
     */
   
   public boolean removeLastOccurrence(Object o)
   {
       int noOfOccurances=0;
       int position=-1;
       int i=1;
       int j=1;
       MyLinkedList current=nodeFirst.nextData;
       MyLinkedList prev=nodeFirst;
       while(current!=null)
       {
           if(current.Data.equals(o))
               position=i;
           current=current.nextData;  
           i++;
       }
       current=nodeFirst.nextData;
       while(j<position)
       {
           current=current.nextData;
           prev=prev.nextData;
           j++;
       }
       prev.nextData=current.nextData;
       return true;
       
   }
   /*
     * removeFirstOccurence         removes the First Occurence of an object
     * @param   o  Object 
     */
   
   public boolean removeFirstOccurrence(Object o)
   {
       int noOfOccurances=0;
       int position=-1;
       int i=1;
       int j=1;
       MyLinkedList current=nodeFirst.nextData;
       MyLinkedList prev=nodeFirst;
       while(current!=null)
       {
           if(current.Data.equals(o))
           {
               position=i;
               break;
           }
           current=current.nextData;  
           i++;
       }
       current=nodeFirst.nextData;
       while(j<position)
       {
           current=current.nextData;
           prev=prev.nextData;
           j++;
       }
       prev.nextData=current.nextData;
       return true;
       
   }
   /*
     * addFirst         adds an object to the start of linked list
     * @param   Element  Object 
     */
   
  public void addFirst(Object Element)
  {
      MyLinkedList node=new MyLinkedList(Element);
      node.nextData=nodeFirst;
      nodeFirst=node;
  }
  
  /*
     * addLast         adds an object to the end of linked list
     * @param   Element  Object 
     */
  
  public void addLast(Object e)
  {
      add(e);
  }
  /*
     * getFirst         returns first object from linked list
     * 
     */
  
  public Object getFirst()
  {
      MyLinkedList current=nodeFirst;
      return current.Data;
  }
  /*
     * getlast         returns last object from linked list
     * 
     */
  public Object getLast()
  {
      MyLinkedList current=nodeFirst;
      while(current.nextData!=null)
          current=current.nextData;
      return current.Data;
  }
  /*
     * toArray()         returns an array of objects 
     *  
     */
  public Object[] toArray()
  {
      int i=0;
      int j=0;
      MyLinkedList current=nodeFirst;
      while(current!=null)
      {
          current=current.nextData;
          i++;          
      }
      Object a[]=new Object[i];
      current=nodeFirst;
      while(current!=null)
      {
          a[j]=current.Data;
          current=current.nextData;
          j++;
      }
      return a;
      
  }
  /*
     * printList         prints the linked list
     * 
     */
   
   public void printList()
   {
       MyLinkedList current=nodeFirst;
       System.out.println("List ");
       while(current!=null)
       {
           current.printLink();
           current=current.nextData;
       }
       System.out.println(" ");
   }
   
   /*
     * traverse       traverses the linked list to given index
     * @param   index  int 
     */
   public MyLinkedList traverse(int index)
   {
        int i=0;
       MyLinkedList current=nodeFirst; 
       while(i<index && current!=null)
        {
         current=current.nextData;
         i++;
        }
       if(current==null)
           return null;
       else
       return current;
   }
   /*
     * traverseprev    traverses the linked list to given index, recording prev value
     * @param   index  int 
     */
   public MyLinkedList traverseprev(int index)
   {
       int i=0;
       MyLinkedList current=nodeFirst.nextData;
       MyLinkedList prev=null;
       while(i<index-1)
       {
           if(i==0)
           prev=nodeFirst;
           
           if(current==null)
               return null;
           else
           {
           prev=current;
           current=current.nextData; 
           i++;
           }
       }
       if(prev!=null)
           return prev;
       else
           return null;
   }
   
  /*
     * reverseList       reverses the linked list
     * 
     */
public void reverseList()
{
MyLinkedList current = nodeFirst; 
nodeFirst = null;
for (; current != null; )
{
MyLinkedList next = current.nextData;
current.nextData = nodeFirst;
nodeFirst = current;
current = next;
}
}

    //Declaring temporary objects of class MyLinkedList type 
   int tempIndex = 0;
   MyLinkedList tempCurrent;
   MyLinkedList tempPrev;
   
   /*
     * ListIterator       returns ListIterator for given index
     * @param   index  int 
     */
   
    public ListIterator listIterator(int index)
    {
        //Assigning temp values created above, here      
        tempIndex = index;
        tempCurrent = traverse(tempIndex);
        tempPrev = traverseprev(tempIndex);          
              
      
       return new ListIterator() 
        {
       
            /*
            * hasNext       returns true if linked list has next element
            * 
            */
            
            public boolean hasNext() {
                if(tempCurrent==null)
                    return false;
                if(tempCurrent!=null)
                {
                                    
                    return true;
                }
                else
                    return false;
            }

            /*
            * hasNext       returns next element from linked list 
            * 
            */
            public Object next() {
                if(tempCurrent==null)
                    return null;
                else
                {   
                    MyLinkedList tmp=new MyLinkedList();
                    tmp.Data=tempCurrent.Data;
                    tempCurrent=tempCurrent.nextData;
                    if(tmp.Data==null)return null;
                    return tmp.Data;    }                    
                
            }

           /*
            * hasPrevious       returns true if linked list has previous element
            * 
            */
            public boolean hasPrevious() {
                if(tempPrev==null)
                    return false;
                else
                    return true;
            }

            /*
            * previous       returns previous element from linked list
            * 
            */
            public Object previous() {
                if(tempPrev==null)
                    return false;
                else
                    return tempPrev.Data;
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void set(Object e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void add(Object e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
    //Temp objects of class MyLinkedList
    MyLinkedList tempCurrent1; 
    
    /*
     * descendingIterator       returns an Iterator in reverse direction
     * 
     */
    public Iterator descendingIterator()
    {
        MyLinkedList temp=nodeFirst;
        int index=0;
        
        //Reversing the linked list
        reverseList();              
        
       
        tempCurrent1=nodeFirst;    
        
      
        return new Iterator() {

            /*
            * hasNext       returns true if linked list has next element
            * 
            */       
                public boolean hasNext() {
                if(tempCurrent1==null)
                    return false;
                if(tempCurrent1!=null)
                {                   
                    
                    return true;
                }
                else
                    return false;
            }
            /*
            * next       returns element if linked list has next element
            * 
            */  

            public Object next() {
                if(tempCurrent1==null)
                    return null;
                else
                {
                    MyLinkedList tmp=new MyLinkedList();
                    tmp.Data=tempCurrent1.Data;
                    tempCurrent1=tempCurrent1.nextData;
                    if(tmp.Data==null)return null;
                    return tmp.Data;  }                      
                
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
    }
     
}


       
       
       
       
       
           
   