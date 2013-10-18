/*
 * Prime.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To check if the given numbers are prime or not using threads
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 10/20/2012 11.45 AM
*
*/

public class Prime extends Thread
{
    //Declaring instance variables
    //An array to store by order - 1 if prime else 0
    static int store[];
    //A current prime number id for each thread
    int current;
    //The prime number to be checked for each thread
    int number;
    
    Prime(){}
    
    //A constructor that initializes current prime no. id and the prime number to be checked 
    Prime(String number,int a)
    {
        current=a;
        this.number=Integer.parseInt(number);
    }
    
     /*
     * check    Checks if the number is prime or not
     * @param   num      represents the number to checked
     * @param   loopId   represents the prime no Id - loopId 
     * 
     */
    public void check(int num,int loopId)
    {
        int i=2;int flag=1;
        if(num==1)
         flag=0;
              
          
        while(i<num && i!=num && num!=1)
        {
            if(num==1)
            {
                flag=0;
                break;
            }
            else
            {
            if(num%i==0)
                flag=0;
            i++;
            }
        }
        if(flag==1)
           store[loopId]=1;     
       
        else
            store[loopId]=0;           
        
    }
    /*
     * run   Thread Execution - Calls for check method 
     *  
     */
    public void run()
    {
        check(number,current);
    }
    
    /*
     * display    Display the results - whether given numbers were prime or not
     * 
     */
    static public void display()
    {
        for(int i=0;i<store.length;i++)
        {
            if(store[i]==1)
                System.out.println("i="+i+" prime");
            else
                System.out.println("i="+i+" not prime");
        }
    }
    
    //Invoking main function
    
    public static void main(String[] args) 
    {
        //currenThread gives the main thread
        Thread obj=Thread.currentThread();
        //Stores flags of prime numbers after check method
        store=new int[args.length];
        //Creating new threads every iteration and initializing with number and loopId
        for(int i=0;i<args.length;i++)
            new Prime(args[i],i).start();
        
        try{
            obj.sleep(1000);
        }catch(Exception e){}
        //Displaying the results whether prime or not
        display();
        
    }
}
