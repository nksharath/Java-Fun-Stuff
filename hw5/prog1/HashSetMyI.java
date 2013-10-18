

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
 

public class HashSetMyI implements AnotherHashSet
{
    //Declaring MAX SIZE 
    private static int MAX_SIZE=1000001;
    //Creating cutom Link List
    MyHashTable[] nodeList; 
    //Declaring counter - for Hash Table size
    int counter=0;
    
    /*
     * HashSetMyI   Default Constructor
     */
    public HashSetMyI()
    {
        nodeList=new MyHashTable[MAX_SIZE];
        //Initialises objects to null
        for(int i=0;i<MAX_SIZE;i++)
            nodeList[i]=null;
    }
    /*
     * generateHash         Generates the Hash Code
     * @param   temp        Object 
     */
    private int generateHash(Object temp)
    {
        int hashValue=temp.hashCode()%nodeList.length;
        if(hashValue<0)
            hashValue+=nodeList.length;
        return hashValue;
    }
    
    /*
     * add         Adds an object to the hash table
     * @param   o  Object 
     */
    public boolean add(Object o)
    {
        int hashValue=generateHash(o);
        //If no collision , inserts into hashtable
        if(nodeList[hashValue]==null)
        {
            nodeList[hashValue]=new MyHashTable(o);
            counter++;
            return true;
        }
        //else creates a link list and chains the elements 
        else
        {
            MyHashTable record=nodeList[hashValue];
            //boolean flag=record.getMethod().equals(o);
            while(record.getNextMethod()!=null && !record.getMethod().equals(o))
            {
                record=record.getNextMethod();
            }
            if( record.getMethod().equals(o))
            {
                record.setMethod(o);
                return true;
            }
            else
            {
                record.setNextMethod(new MyHashTable(o));
                counter++;
                return true;
            }
        }        
    }
    /*
     * clear       clears the Hash Table
     */
    
    public void clear()
    {
        nodeList=new MyHashTable[MAX_SIZE];
        counter=0;
        //for(int i=0;i<MAX_SIZE;i++)
            //nodeList[i]=null;
        
    }
    
    /*
     * contains     Checks if object is present
     * @param   o  Object 
     */
    
    public boolean contains(Object o)
    {
        //generates hash code
        int hashValue=generateHash(o);
        if(nodeList[hashValue]==null)        
            return false;
        else
        {
            MyHashTable record=nodeList[hashValue];
            //checks if available
            if(record.getMethod().equals(o))
                return true;
                              
                    
            while(record!=null)
            {
                record=record.getNextMethod();
            }
            if(record==null)
                return false;
            else
                return true;
        }
    }
    
    /*
     * isEmpty     checks if hash table is empty 
     */
    public boolean isEmpty()
    {
        if(counter==0)
            return true;
        else
            return false;
    }
    
    /*
     * remove         removes an object to the hash table
     * @param   o  Object 
     */
    public boolean remove(Object o)
    {
        int hashValue=generateHash(o);
        //Search is performed untill null found
        if(nodeList[hashValue]!=null)
        {
            MyHashTable prevRecord=null;
            MyHashTable record=nodeList[hashValue];
            while(record.getNextMethod()!=null && !record.getMethod().equals(o))
            {
                prevRecord=record;
                record=record.getNextMethod();
            }
            //Removes object by making it null . Reduces counter by 1
            if(record.getMethod().equals(o))
            {
                if(prevRecord==null)
                {
                    nodeList[hashValue]=record.getNextMethod();
                    counter--;
                    return true;
                }
                else
                {
                    prevRecord.setNextMethod(record.getNextMethod());
                    counter--;
                    return true;
                }   
            }
        }
        return false;
    }   
    
    /*
     * size         return size of hash Table
     */
    
    public int size()
    {
        return counter;
    }
}
