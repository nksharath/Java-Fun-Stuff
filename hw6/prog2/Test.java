
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
*@Problem       : A class that tests sort,sort-comparator and shuffle functions
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/13/2012 10.55 PM
*
*/
import java.util.*;
public class Test 
{  
   
    public static void main(String args[])
    {
       // Declaring variable for recording excecution time
       long milliSeconds = System.currentTimeMillis();
       //Creating a new ArrayList
       List myList=new ArrayList();
       //Adding Test Elements
       myList.add(5);
       myList.add(2);
       myList.add(1);
       myList.add(4);
       myList.add(3);      
       
       //Creating an object of PartialCollectionsImp type
       PartialCollectionsImp obj=new PartialCollectionsImp();
       //Calling the custom sort function
       obj.sort(myList);
       System.out.println("EXAMPLE OF SORT ");
       System.out.println(myList); 
       
       //Creating comparator object , and defining the comparator
       Comparator comp=new Comparator() {

            @Override
     /*
     * compare           Compares given two objects, and returns 0 if ==, -1 if <, 1 if >
     * @param   o1  Object 
     * @param   o2  Object
     */
            public int compare(Object o1, Object o2) 
            {
                if((Integer)o1==(Integer)o2)
                    return 0;
                else
                    if((Integer)o1>(Integer)o2)
                        return 1;
                else
                        return -1;
            }
        };
       //Testing custom function sort with comparator
       System.out.println("EXAMPLE OF SORT WITH COMPARATOR");
       obj.sort(myList,comp);
       System.out.println(myList);
       //Testing Shuffle algorithm
       System.out.println("EXAMPLE OF SHUFFLE ALGORITHM");
       obj.shuffle(myList);
       System.out.println(myList);
       //Displaying Exceution Time
       System.out.println("Time for all: " + ( System.currentTimeMillis() - milliSeconds) );
       
               
       
    }
    
}
