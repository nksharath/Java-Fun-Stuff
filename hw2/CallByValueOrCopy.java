/*
 * CallByValueOrCopy.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To demonstrate call by value and reference 
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
* @Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 09/14/2012 1.12 PM
*
*/
public class CallByValueOrCopy
{
    //Creating instance varianle
    String name;
    
    /*
     * Non Parameterized Constructor
     * 
     */
    
    CallByValueOrCopy()
    {
        name="PRATIK DILIP MEHTA";
    }
    
    /*
     * valueExample demonstrates a swap between two numbers.
     * @param   a  represents first number
     * @param   b   represents second number
     * 
     */
    
    void valueExample(int a,int b)
    {
        int temp;
        temp=a;
        a=b;
        b=temp;
        System.out.println("VALUES OF A & B FROM METHOD : "+a+" : "+b);
        
    }  
    
    /*
     * referenceExample demonstrates changing the value of the object passed.
     * @param   object  An object of CallByValueOrCopy type     
     * 
     */
    
    void referenceExample(CallByValueOrCopy object)
            
    {
       //Changes the value of the local object.
        object.name="SHARATH NAVALPAKKAM KRISHNAN";
        System.out.println("VALUES OF DEMO-OBJECT2 FROM METHOD : "+object.name);
    }
    
   
    // Invoking main function
    
    public static void main(String args[])
    {
        //Creating an object for calling the functions.
        CallByValueOrCopy demoObject1=new CallByValueOrCopy();
        // Using two variables to demonstrate call by value
        int a=10,b=20;
        
        //Demonstrating call by value by performing swap in method.
        System.out.println("VALUES OF A & B FROM MAIN :"+a+" : "+b);
        System.out.println("CALLING valueExample METHOD");
        demoObject1.valueExample(a,b);
        System.out.println("BACK TO MAIN ");
        System.out.println("VALUES OF A & B FROM MAIN :"+a+" : "+b);
        System.out.println();
        
        
        //Demonstrating call by reference using objects.
        CallByValueOrCopy demoObject2=new CallByValueOrCopy();
        System.out.println("VALUE OF DEMO-OBJECT2 FROM MAIN :  "+demoObject2.name);
        System.out.println("CALLING referenceExample METHOD");
        demoObject1.referenceExample(demoObject2);
        System.out.println("BACK TO MAIN");
        System.out.println("VALUE OF DEMO-OBJECT2 FROM MAIN :  "+demoObject2.name);
        
        
    }
}
