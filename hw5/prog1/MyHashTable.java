
/*
 * HashSetMyI.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : A class that implements AnotherHashSet interface
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/06/2012 2.55 PM
*
*/
public class MyHashTable 
{
    //Instance varibales Data and nextData 
    Object Data;
    MyHashTable nextData;
    
    //Parameterized Constructor
    public MyHashTable(Object temp)
    {
     Data=temp;
     nextData=null;
    }
    //No argument constructor
    public MyHashTable()
    {
        Data=null;
        nextData=null;
    }
    /*
     * getMethod         returns Data
     * 
     */
    public Object getMethod()
    {
        return Data;    
    }
     /*
     * setMethod         sets the value
     * @param   temp    temporary object
     */
    
    public void setMethod(Object temp)
    {
        Data=temp;
    }
    
     /*
     * getNextMethod         returns nextData 
     */
    
    public MyHashTable getNextMethod()
    {
        return nextData;
    }
     /*
     * setNextMethod        sets the value
     * @param   temp        temporary object
     */
    
    public void setNextMethod(MyHashTable temp)
    {
        nextData=temp;
    }
}