/*
 * DeadLock.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To create a DeadLock Situation between two threads
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 10/27/2012 1.45 PM
*
*/

import java.util.*;

public class DeadLock extends Thread
{
    //Declaring Member Variables 
    //Declaring Thread Id
    String ThreadId;
    //Creating two static vectors to demonstrate inter-thread dependency
    static Vector v1=new Vector();
    static Vector v2=new Vector();
    
    //Constructor to initialize Thread Id 
    public DeadLock(String temp)
    {
        ThreadId=temp;
    }
    /*
     * functionA    synchronized on vector v1 : And tries to enter functionB
     * 
     */
    void functionA()
    {
        synchronized(v1)
        {
            System.out.println("Thread "+ThreadId);
            try
            {
                sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Error");
            }
            //Calls functionB here 
            functionB();
            //This line is un-reachable becuase of dead lock situation
            System.out.println("Thread "+ThreadId+" End");
        }
    }
    /*
     * functionB    synchronized on vector v2 : And tries to enter functionA
     * 
     */
    void functionB()
    {
        synchronized(v2)
        {
            System.out.println("Thread "+ThreadId);
            try
             {
                sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Error");
            }
            //Calls functionA here 
            functionA();
            //This line is un-reachable becuase of dead lock situation
            System.out.println("Thread "+ThreadId+" End");
        }       
       
    }
    
    public void run()
    {
        if(ThreadId=="A")
        functionA();
        else
            functionB();      
        
    }
    
    public static void main(String args[])
    {
        Thread current=Thread.currentThread();
        //Starting two threads A and B to demonstrate DeadLocks
        
        new DeadLock("A").start();
        /*try
        {
        current.sleep(1000);
        }catch(InterruptedException e)
        {
            System.out.println("Error");
        }*/
        new DeadLock("B").start();
    }
}
    
    
    

 