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
import java.text.*;
import java.util.*;
public class Person 
{

   //Declaring required Instance Variables
    String givenName;
    String familyName;
    int socialSecurityNumber;
    String dateOfBirth;
    int age;
    String vote;
    String seniorCitizen;
    
    //Initializing all Instance Variables
    Person()
    {
        givenName="";
        familyName="";
        socialSecurityNumber=0;
        dateOfBirth="";
        vote="NO";
        seniorCitizen="NO";
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
     /*
     * getData()  Accepts all required data fields from user
     * Validates if SSN is a number
     * Checks if the given Date of birh is a valid date.
     * 
     */
    
    void getData()throws IOException
    {
        String tempSsn;
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Given Name ");
        givenName=in.readLine();
        System.out.println("Enter the Family Name ");
        familyName=in.readLine();
        
        do
        {
            System.out.println("Enter the Social Security Number");
            tempSsn=in.readLine();
            
            if(isNumeric(tempSsn))
                socialSecurityNumber=Integer.parseInt(tempSsn);
        }while(!isNumeric(tempSsn));        
        System.out.println("Enter your Date of Birth");
        dateOfBirth=in.readLine(); 
        while(!checkDate(dateOfBirth))
        {
            System.out.println("Invalid Date : MM/DD/YYYY : Re-Enter DOB ");
            dateOfBirth=in.readLine();
        }
    }
    /*
     * checkDate  Checks if a given date is valid
     * @param  date   represents the date in string format
     * 
     */
    boolean checkDate(String date)
    {
        Date result;
        Calendar test=Calendar.getInstance();
        test.setLenient(false);
        SimpleDateFormat validate=new SimpleDateFormat("mm/dd/yyyy");
        try
        {
            //date format validation
            result=validate.parse(date);               
            
        }
        catch(Exception e)
        {
            return false;
        }
        
        try
        {
            //Checks if the date is valid 
            int month=Integer.parseInt(date.substring(0,2));
            int day=Integer.parseInt(date.substring(3,5));
            int year=Integer.parseInt(date.substring(6,10));
            month-=1;
            
            test.set(year,month,day);
            Date temp=test.getTime();
        }
        catch(Exception e)
        {
           return false;
        }
        if(!validate.format(result).equals(date))
        {
            return false;
        }
        return true;
    }    
            
    /*
     * ageCalculate  Calculates the age from date of birth
     * Valdidates age if >110 
     */
    void ageCalculate()throws IOException
    {
       
        age=(2012-Integer.parseInt(dateOfBirth.substring(6,10)));
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        while(age>110)
        {
            System.out.println("Please enter the correct Date of Birth");
            dateOfBirth=in.readLine();
            if(!checkDate(dateOfBirth))
            {
                System.out.println("Invalid Date : MM/DD/YYYY : Re-Enter DOB ");
                dateOfBirth=in.readLine();
            }
            age=(2012-Integer.parseInt(dateOfBirth.substring(6,10)));
        }
            
    }
    
    /*
     * checkSimilarity  Checks for duplicate copies of person
     * @param  objectArray[]   represents the array of persons 
     * 
     */
    static void checkSimilarity(FireFighter objectArray[])
    {
        
        int length=objectArray.length;
        for(int i=0;i<length;i++)
        {
            //checking with each element of the object-array
            for(int j=i+1;j<length;j++)
            { 
                if(objectArray[i].givenName.equals(objectArray[j].givenName) && 
                   objectArray[i].familyName.equals(objectArray[j].familyName))
                {
                    objectArray[j].givenName+=("(C)");
                            
                }
            }
        }
    }
    /*
     * checkVote  Checks if person is eligible to vote     
     * 
     */
    void checkVote()
    {
        if(age>18)
            vote="YES";        
    }
    /*
     * checkSenior  Checks if person is a senior citizen 
     * 
     */
    
    void checkSenior()
    {
        if(age>65)
            seniorCitizen="YES";
    }    
    
}
                  
    
    