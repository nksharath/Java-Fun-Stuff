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
public class TestPerson 
{
    //Invoking the main function : throws Input-Output Exceptions
    public static void main(String agrs[])throws IOException
    {
        //Creating object array for FireFighter class
        FireFighter[] objectPerson=new FireFighter[2]; 
        FireFighter dummy=new FireFighter();
        
        //Getting all necessary data with respective functions
        
        for(int i=0;i<objectPerson.length;i++)
        {
            System.out.println("Person " +(i+1));
            objectPerson[i]=new FireFighter();
            objectPerson[i].getData();
            objectPerson[i].ageCalculate();
            objectPerson[i].checkVote();
            objectPerson[i].checkSenior();           
            objectPerson[i].checkEligible();           
        }
        //Check if duplicate copies present
        Person.checkSimilarity(objectPerson);  
        
        //Displays information with all necessary fields
        
        System.out.println("\n\nGIVEN NAME\tFAMILY NAME\tSSN\tDOB\t\tAGE\tVOTE"
                            +"\tSENIOR-CITIZEN\tFIRE-FIGHTER:ELIGIBLE");
        
            for(int i=0;i<objectPerson.length;i++)
            {
                 System.out.println(objectPerson[i].givenName+"\t\t"+objectPerson[i].familyName+"\t\t"
                    +objectPerson[i].socialSecurityNumber+"\t"+objectPerson[i].dateOfBirth+"\t"
                    +objectPerson[i].age+"\t"+objectPerson[i].vote+"\t"+objectPerson[i].seniorCitizen+"\t\t"
                    +objectPerson[i].eligible);
            }
    }
}
        
           
    

        
        
        
 
                
            
            
      
