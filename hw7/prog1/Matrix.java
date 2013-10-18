/*
 * Matrix.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To perform matrix multiplication using threads
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 10/20/2012 3.45 PM
*
*/

import java.util.*;
class Mat extends Thread
{
    //Declaring member variables
    //Declaring first matrix
    static int[][] matrixOne=new int[1][4];
    //Declaring second matrix
    static int[][] matrixTwo=new int[4][4];
    //Declaring Result matrix
    static int[][] matrixResult=new int[1][4];   
    //Declaring variables to keep track of current row and col for each thread
    int currentRow,currentCol;
    
    Mat(){}
    //Constructor that initializes row and column for each thread created
    Mat(int a,int b)
    {
        currentRow=a;
        currentCol=b;
    }
   /*
     * setMethod    Sets values to two matrices with default values
     * 
     */
    
    static void setMethod()
    {
       //Local counter variables 
       int elementOne=1;
       int elementTwo=1;
       //Adding elements every iteration to first matrix
       for(int i=0;i<4;i++)
           for(int j=0;j<4;j++)
           matrixTwo[i][j]=elementTwo++; 
       //Adding elements every iteration to second matrix and initializing result matrix with 0
       for(int i=0;i<1;i++)
           for(int j=0;j<4;j++)
           {
               matrixOne[i][j]=elementOne++;  
               matrixResult[i][j]=0;
           }
       
    }
    
    /*
     * displayMatrix    Displays the resultant matrix after multiplication
     * 
     */
    
   static public void displayMatrix()
    {
        System.out.println("Matrix 1");
        for(int i=0;i<matrixOne.length;i++)
        {
            for(int j=0;j<matrixOne[0].length;j++)
                System.out.print(matrixOne[i][j]+"  ");
            System.out.println();
        }
        
        System.out.println("Matrix 2");
        
        for(int i=0;i<matrixTwo.length;i++)
        {
            for(int j=0;j<matrixTwo[0].length;j++)
                System.out.print(matrixTwo[i][j]+"  ");
            System.out.println();
        }
        
        System.out.println("Resultant Matrix");
        
        for(int i=0;i<matrixResult.length;i++)
        {
            for(int j=0;j<matrixResult[0].length;j++)
                System.out.print(matrixResult[i][j]+" ");
            
          System.out.println();
        }
    }
   
    /*
     * product   performs matrix multiplication based on row and column values
     * @param   row      represents the row number
     * @param   col      represents the column number
     * 
     */
   
   public void product(int row,int col)
   {
       for(int i=0;i<matrixOne[0].length;i++)
       matrixResult[row][col]=matrixResult[row][col]+(matrixOne[row][i]*matrixTwo[i][col]);
   }               
    
    /*
     * run    Thread-Execution - calls product method for every thread created
     * 
     */
    public void run()
    {    
       product(currentRow,currentCol);             
    } 
}
// Public class - that defines Main function

public class Matrix
{   
    //Invoking Main function
    public static void main(String[] args) 
    {
        //Creating currentThread - Main Thread
        Thread current=Thread.currentThread();
        //setting default values to matrices
        Mat.setMethod();
        //Creating new threads every iteration 
        for(int i=0;i<Mat.matrixOne.length;i++)
            for(int j=0;j<Mat.matrixTwo[0].length;j++)
               new Mat(i,j).start();         
        try
        {
        current.sleep(100);
        }catch(Exception e){}
        //Displaying the resultant matrix
        Mat.displayMatrix();
    }
}
