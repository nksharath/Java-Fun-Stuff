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
*@Problem       : To Create objects and check if they are eligible for voting and fire fighting
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 09/23/2012 10.45 AM
*
*/
package person;
import java.io.*;
public class FireFighter extends Person
{
    //Declaring instance variables
    int height;
    int weight;
    String eligible;
    
    //Initializing instance variables using a constructor
    FireFighter()
    {
        height=0;
        weight=0;
        eligible="NO";
    }
    
    /*
     * getExtraData()  Gets additional data from the user such as 
     * Height
     * Weight
     * Checks if input is valid
     * 
     */
    void getExtraData()throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String temp;
        do
        {
            System.out.println("Enter the height in Cms ");
            temp=in.readLine();
            if(isNumeric(temp))
                height=Integer.parseInt(temp);
        }while(!isNumeric(temp));
        
        
       do
        {
            System.out.println("Enter the weight in Pounds ");
            temp=in.readLine();            
            
            if(isNumeric(temp))
                weight=Integer.parseInt(temp);
        } while(!isNumeric(temp));
       
    }
    
    /*
     * checkEligible  Checks if person is eligible to be a firefighter
     * 
     */
    
    void checkEligible()throws IOException
    {
        if(age>20 && age<50)
        {
            eligible="YES";
            getExtraData();
        }
        
    }
    
    
}
