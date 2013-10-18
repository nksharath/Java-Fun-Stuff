/**
*@Problem       : To Print the Operating System Name.  
* 
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 09/09/2012 8.45 PM
*
*/
import java.util.Enumeration;
import java.util.Properties;

class OsName
{
    public static void main (String args []) 
    {  
        /* Usage : String getProperty(String Key)
         * Key : os.name
         * Returns : The user operating system name
         */
        System.out.println("OS: "+System.getProperty("os.name")); 
    }
}