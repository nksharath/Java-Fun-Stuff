
/*
 * MyLinkedList.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : A class that creates a Link List
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/14/2012 10.45 AM
*
*/
import java.util.*;
public class MyLinkedList 
{
    //Declaring elements of linked list 
    // object and a link to next data
    Object Data;
    MyLinkedList nextData;    
    
    //Parameterized Constructor , Initializing Member variables
    public MyLinkedList(Object temp)
    {
     Data=temp;
     nextData=null;
    }
    //Default Constructor , initializing member variables to null
    public MyLinkedList()
    {
        Data=null;
        nextData=null;
    }    
    /*
     * printLink         prints the linked list
     * 
     */
    public void printLink()
    {
        System.out.print("{ " + Data+" }   ");
    }   
    
}

    
