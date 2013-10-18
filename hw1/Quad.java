/**
*@Problem       : To Create all combinations for n actors.  
* 
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Version       : 1.0.4
*@LastModified  : 09/11/2012 10.44 PM
*
*/
import java.io.*;
import java.math.*;
public class Quad 
{
    public static void main(String args[])
    {
        
        int numberOfCodes; // Number of Binary Codes generated
        int count=0,k=0,j=0,m=1;// Local count and iteration variables.    
        
        int numberOfActors=args.length;//Determining the value of n, No. of actors             
                              
        numberOfCodes=(int)(Math.pow(2,numberOfActors));// For N actors, no. of solutions is pow(2,n)
        String binaryCode[]=new String[numberOfCodes];//A string array to store binary codes
        String resultSet[]=new String[numberOfCodes];//A string array to store solution.
        
        for(int i=0;i<resultSet.length;i++)
            resultSet[i]="";//Initializing with ""       
        
        for(int i=0;i<numberOfCodes;i++)
        {
        binaryCode[i]=Integer.toBinaryString(i);//Generating Binary code for each actor
        while(binaryCode[i].length()<numberOfActors)// This loop appends '0' to the start of string.
        {
            
            String temp;
            temp="0"+binaryCode[i];// Eg no.of.actors=3 : 000 , no.of.actors=4 :0000
            binaryCode[i]=temp;
           
        }
        }
       
        for(int i=0;i<binaryCode.length;i++) 
        {
        while(count < binaryCode[i].length())
        {            
            if(binaryCode[i].charAt(count)=='1')// When binary bit=1
            {  
                resultSet[k]=resultSet[k]+args[count];// Finds the corresponding actor and stores
                
                count++;                
            }    
            else
                count++;
            
        }        
        count=0;
        k++;
        }
         
        java.util.Arrays.sort(resultSet);// Sort : Acending
        
        System.out.println("{"+resultSet[0]+"}"); 
        
        for(int i=0;i<resultSet.length;i++) // Sorts : Lexicographically 
       {
        while(j<resultSet.length)
        {
            if(resultSet[j].length()==m)
            System.out.println("{"+resultSet[j]+"}");            
            j++;
        }
        j=0;
        m++;
       }          
    }
    
}
