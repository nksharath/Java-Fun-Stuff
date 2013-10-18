
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
*@Problem       : To Test the Hash Table
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/06/2012 2.55 PM
*
*/
public class Test 
{
    // Invoking Main Function
     public static void main(String args[])
    {
        // Declaring variable milliSeconds to record Time
       long milliSeconds = System.currentTimeMillis();
       //Creating custom hash set
        HashSetMyI object=new HashSetMyI();
        String name1="sharath";
        
        //Adding string 100000 times and check if it contains the same string
        for(int i=0;i<100000;i++)
        {
        System.out.println("ADD "+object.add(name1));        
        System.out.println("CONTAINS : "+object.contains(name1));        
        }
        //Removes only 1 entry of string : Shows Duplicate copies not stored
        for(int i=0;i<100000;i++)
        System.out.println("REMOVE "+object.remove(name1));
        
        //Checks if HashTable is empty
        System.out.println("EMPTY "+object.isEmpty());  
        //Prints HashTable's size
        System.out.println("SIZE "+object.size());

	System.out.println("ADD "+object.add(name1));
	//Clears the Hash Table
	System.out.println("SIZE "+object.size());
	System.out.println("CLEAR ");
	object.clear();	
	System.out.println("SIZE "+object.size());
        //Displays running time for above algorithm
        System.out.println("Time for all:       " + ( System.currentTimeMillis() - milliSeconds) );
    }
    

}
