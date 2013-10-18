/*
 * Lucas.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To Generate first 10 Lucas Numbers 
* 
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
* @Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.4
*@LastModified  : 09/15/2012 2.04 PM
*
*/

public class Lucas
{

    /*
     * generateLucas generates First 10 Lucas Numbers
     * @param   numberPrevious  represents previous number in series
     * @param   numberPresent   represents present number in series
     * 
     */
static void generateLucas(int numberPrevious, int numberPresent)
{
System.out.println(numberPrevious);

// To print first 10 Lucas numbers 
if(numberPresent < 100) 
generateLucas(numberPresent, numberPrevious+numberPresent);
}
//Invoking main
public static void main(String args[])
{ 
    //Starting values of Lucas Numbers are 2 and 1
generateLucas(2,1);
}
}