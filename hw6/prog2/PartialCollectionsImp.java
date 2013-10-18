
/*
 * PartialCollectionsImp.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : A class that implements PartialCollections interface
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/13/2012 10.55 PM
*
*/
import java.util.*;
import java.lang.String;
public class PartialCollectionsImp implements PartialCollections

{
    /*
     * sort           Performs sort on the given list
     * @param   list  List 
     */
    
    public void sort(List list)
    {   //Converting the list to an array     
        Object array[]=list.toArray();
        //try catches exceptions if not of int,double or String type
        try{
            //Checking if array is of Integer type
        if(array[0] instanceof Integer)       
        {
            for(int i=0;i<array.length-1;i++)
            {
                for(int j=i+1;j<array.length;j++)
                {
                    if((Integer)array[i]>(Integer)array[j])
                    {
                        //Performs swap
                        int temp=(Integer)array[i];
                        array[i]=array[j];
                        array[j]=temp;                        
                    }
                }
            }
         //Makes changes to the original copy of the list
        for(int i=0;i<array.length;i++)
        list.set(i, array[i]);
        }
        //Checking if array is of Double type
        if(array[0] instanceof Double)       
        {
            for(int i=0;i<array.length-1;i++)
            {
                for(int j=i+1;j<array.length;j++)
                {
                    if((Double)array[i]>(Double)array[j])
                    {
                        //Performs swap
                        double temp=(Double)array[i];
                        array[i]=array[j];
                        array[j]=temp;                        
                    }
                }
            }
            //Makes changes to the original copy of the list
        for(int i=0;i<array.length;i++)
        list.set(i, array[i]);
        }
       //Checking if array is of String type 
        if(array[0] instanceof String)       
        {
            for(int i=0;i<array.length-1;i++)
            {
                for(int j=i+1;j<array.length;j++)
                {
                                        
                    int val=((String)array[i]).compareTo((String)array[j]);
                    if(val > 0)
                    {
                        //Performs swap
                        String temp=(String)array[i];
                        array[i]=array[j];
                        array[j]=temp;                        
                    }
                }
            }
            //Makes changes to the original copy of the list
        for(int i=0;i<array.length;i++)
        list.set(i, array[i]);
        } 
        }
        catch(Exception e)
        {
            System.out.println("Invalid Type of Object");
            System.exit(0);
        }
    }
    
    /*
     * sort           Performs sort on the given list using a comparator
     * @param   list  List 
     * @param   c     Comparator
     */
    
    public void sort(List list,Comparator c)
    {
        //try catches exceptions if not of int type
        try
        {
        Object array[]=list.toArray();
        for(int i=0;i<array.length-1;i++)
        {
            for(int j=i;j<array.length;j++)
            {
                //Uses the custom comparator function
                if(c.compare(array[i], array[j])<0)
                {
                    int temp=(Integer)array[i];
                    array[i]=array[j];
                    array[j]=temp;                
                }
            }
        }
        //Makes changes to the original copy of the list
        for(int i=0;i<array.length;i++)
            list.set(i, array[i]);
    }
     
    catch(Exception e)
        {
            System.out.println("Invalid Type of Object");
            System.exit(0);
        }
    }
    
    /*
     * shuffle           Performs a shuffle on the given list
     * @param   list  List 
     */
    
    public void shuffle(List list)
    {
        //Catching exceptions of non int,double,string types
        try
        {
            //Converting list to an array
        Object array[]=list.toArray();
        int len=array.length;
        //Declaring variables for random() function
        int random;
        int randomIndex;
        for(int i=0;i<len;i++)
        {
            random=(int)(Math.random()*(len-i));
            randomIndex=i+random;
            //System.out.println(randomIndex);
            //Performing swap
            int temp=(Integer)array[i];
            array[i]=array[randomIndex];
            array[randomIndex]=temp;
        }  
        //Makes changes to the original copy of the list      
        for(int i=0;i<array.length;i++)
            list.set(i, array[i]);
    }
     
        catch(Exception e)
        {
            System.out.println("Invalid Type of Object");
            System.exit(0);
        }
    }
}

            
                
            
            
      
  

                   
    
    
                    
   