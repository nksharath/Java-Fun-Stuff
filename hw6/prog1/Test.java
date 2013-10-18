

/*
 * Test.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : A class that tests PatialLinkedList and its functions
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/14/2012 10.45 AM
*
*/
import java.util.*;
public class Test 
{
    public static void main(String args[])
    {
        long milliSeconds = System.currentTimeMillis();
        PatialLinkedListImpl myList=new PatialLinkedListImpl(); 
        //Adding Test elements to linked list using add(object) 
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("a");
        myList.add("f");
        //Example of LinkedList to array conversion 
        Object a[];
        a=myList.toArray();
        //Printing the list
        System.out.println("EXAMPLE OF boolean add(Object e)");
        myList.printList();
        
        
        //Example of Adding an element at a given index
        
        myList.add(4,"d");
        myList.add(3,"6");
        a=myList.toArray();
        //Printing the list
        System.out.println("EXAMPLE OF void add(int index, Object element)");
        myList.printList();
       
        
        
        //Example of addFirst()
        myList.addFirst("B");
        myList.addFirst("A");
        a=myList.toArray();
        //Printing the list
        System.out.println("EXAMPLE OF void addFirst(Object e)");
        myList.printList();
       
        
         //Example of addLast(object)
        myList.addLast("a");
        myList.addLast("a");
        myList.addLast("a");
        myList.addLast("a");
        myList.addLast("a");
        myList.addLast("END");  
        a=myList.toArray();
        //Printing the list
        System.out.println("EXAMPLE OF void addLast(Object e)");
        myList.printList();
        
        
               
        
       //Example of remove(object) 
        myList.remove("c");
        myList.remove("b");
        a=myList.toArray();
        //Printing the list
        System.out.println("EXAMPLE OF boolean remove(Object o)");
        myList.printList();
        
            
              
        //Example of removeLastOccurance(object)
        myList.removeLastOccurrence("d");
        a=myList.toArray();
        //Printing the list
        System.out.println("EXAMPLE OF removeLastOccurrence(Object o)");
        myList.printList();
       
        
        
        //Example of removeFirstOccurance(object)
        myList.removeFirstOccurrence("a");
        a=myList.toArray();
        //Printing the list
        System.out.println("EXAMPLE OF removeFirstOccurrence(Object o)");
        myList.printList();
        
        
        //Example of getFirst function
        System.out.println("EXAMPLE OF Object getFirst() "+myList.getFirst());
        
        //Example of getLast function
        System.out.println("EXAMPLE OF Object getLast() "+myList.getLast());
        
           
        
        //Example of Custom ListIterator
        ListIterator iter=myList.listIterator(0);
        
        System.out.println("EXAMPLE OF ListIterator listIterator(int index)");
        
        //Testing hasNext()
        while(iter.hasNext())
        {
                                
            //Testing the next() function
            System.out.print("{"+iter.next()+"} ");  
        }System.out.println();
           iter=myList.listIterator(5);
            //Testing hasPrevious()
            System.out.println("EXAMPLE hasPrevious : "+iter.hasPrevious());
        
            //Testing previous()
            System.out.println("EXAMPLE previous : = "+iter.previous());       
            
        
        
        //Creating Custom descendingIterator
        Iterator iter1=myList.descendingIterator();
        
        System.out.println("EXAMPLE OF Iterator descendingIterator()");
        while(iter1.hasNext())
        {
        //Testing hasNext()          
        //Testing next()
        System.out.print("{"+iter1.next()+"} ");
        }System.out.println();                             
        System.out.println("Time for all: " + ( System.currentTimeMillis() - milliSeconds) );
    }
    
    
    
        
}
