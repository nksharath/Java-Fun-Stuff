/*
 * CashRegister.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To develop a Cash Register environment
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 09/21/2012 4.55 PM
*
*/
import java.io.*;
public class CashRegister 
{
    // Instance Variables itemCount and price declared
    int itemCount;
    double price;
    
    //Constructor to initialise instance variables
    CashRegister()
    {
        itemCount=0;
        price=0.0;
    }
    
     /*
     * clear() clears the values of,
     * 
     * itemCount    No. of items
     * price        Price of the item
     * 
     */
    void clear()
    {
        itemCount=0;
        price=0.0;
    }
    
     /*
     * addItem  adds an item and increaments item count
     * @param   price  represents price of the item     * 
     * 
     */
    
    void addItem(double price)
    {
        this.price+=price;
        itemCount++;
    }
    
    /*
     * getCount() returns
     * 
     * itemCount  No. of items   
     * 
     */
    int getCount()
    {
        return itemCount;
    }
    
    
    /*
     * isNumeric  Checks if input is a number
     * @param  number   represents the input string
     * 
     */
    boolean isNumeric(String number)
    {
        try
        {
           Double.parseDouble(number);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
        
    }          
    
    //Invoking the main function
    public static void main(String[] args)throws IOException
    {
        //Creating a new CashRegister Object
        CashRegister customer=new CashRegister();
        int choice;
        //Preparing for console-input
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        //Display options to the user and call corresponding functions
            do
                {
                    System.out.println("\n1.Clear Items\n2.Add Items\n3.Get Item Count\n4.Exit");
                    choice=Integer.parseInt(in.readLine());
                    switch(choice)
                    {
                        case 1: //Clears all contents
                                customer.clear();
                                break;
                                
                                //Accepts the price of the item
                        case 2: System.out.println("Enter the price of the item");
                                String temp=in.readLine();
                                //Checks if input is numeric
                                if(customer.isNumeric(temp))
                                {
                                    customer.addItem(Double.parseDouble(temp));
                                    break;
                                }
                                else
                                {
                                System.out.println("Invalid Input Format");
                                break;   
                                }
                                //Gets the item count
                        case 3: System.out.println("Item Count = "+customer.getCount());
                                break;
                        case 4: System.exit(-1);
                        default:System.out.println("Invalid Choice");
                    }
                }while(choice!=4);
    }
}
