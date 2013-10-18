/*
* WordCount.java
* 
* Version:
*          $Id$
* 
* Revisions:
*          $Log$
* 
*/

/*
*@Problem       : To determine the number of words in a file
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 09/22/2012 2.45 PM
*
*/
import java.util.Scanner;
import java.io.File;

class WordCount {

	/*checkArguments validates whether input file has been specified or not
        *@param args represents the command line arguements
	*
	*/

	public static void checkArguments(String args[]) {
		if(args.length == 0) {
			System.out.println("Please enter the name of the file as an argument");
			System.exit(0);
		}
	}
	//Invoking main function
	public static void main(String args[]) {
		WordCount.checkArguments(args);
		// Counter to count number of words
		int noOfWords = 0;
		try {
			// Using Scanner Object to read file and divide the content into token using whitespace and new line as a delimiter.
			Scanner wordCount = new Scanner(new File(args[0])).useDelimiter("\\s+|"+System.getProperty("line.separator")+"+");
			while(wordCount.hasNext()) {
				wordCount.next();
				noOfWords++;
			}
		} catch(Exception f) {
			// Exception if file is not found
			System.out.println("File Not Found");
			System.exit(0);
		}
		System.out.println("Number of words in "+args[0]+" are "+noOfWords);
	}
}
