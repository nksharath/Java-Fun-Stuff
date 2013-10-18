/*
 * Expression.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To Evaluate an expression with Paranthesis
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
* @Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.7
*@LastModified  : 09/16/2012 7.23 PM
*
*/


public class Expression
{
    
    /*
     * evaluateExpression evaluates the given expression
     * @param   expr    holds the expression to be evaluated
     * 
     */
    
    static double evaluateExpression(String expr)
    {
        //bracketCount keeps track of the number of '(' or ')'
        //previousOperator is used to keep track of operator during function break
        //previousPosition is used to keep track of operator position during function break
         int bracketCount=0;    
         char previousOperator=' ';
         int previousPosition=-1;
       
       // Iteration valid : till end of expression . In reverse order         
       for(int i=expr.length() -1;i>=0;i--)
       {
           if(expr.charAt(i)==')')
               bracketCount++;
           if(expr.charAt(i)=='(')
               bracketCount--;
          
           if (bracketCount > 0)
               continue;                               
          // Checks if operator is + , and hence calls evaluateExpression recursively
           if(expr.charAt(i)=='+')
           {  // System.out.println(expr.substring(0,i));
              //System.out.println(expr.subSequence(i+1,expr.length()));
               return evaluateExpression(expr.substring(0,i)) + 
                      evaluateExpression(expr.substring(i+1,expr.length()));
           }
           
           else
               // Checks if operator is - , and hence calls evaluateExpression recursively
           if(expr.charAt(i)=='-')
           {
               return evaluateExpression(expr.substring(0,i)) -
                      evaluateExpression(expr.substring(i+1,expr.length()));
           }
           
           else
               // Checks if operator is * , and breaks to process multiplication
           if(expr.charAt(i)=='*')
           {
               
               if(previousPosition<0)
               {    //System.out.println("Inside");
                   previousPosition=i;
                   previousOperator='*';
               }
               break;
           }
           
           
           else    
               // Checks if operator is / , and breaks to process division
           if(expr.charAt(i)=='/')
           {
               if(previousPosition<0)
               {
                   previousPosition=i;
                   previousOperator='/';
               }
               break;
           }
           
           else
               // Checks if operator is % , and breaks to process mod
           if(expr.charAt(i)=='%')
           {
               if(previousPosition<0)
               {
                   previousPosition=i;
                   previousOperator='%';
               }
               break;
           }
           
           
           else
               // Checks if operator is ^ , and breaks to process power function
           if(expr.charAt(i)=='^')
           {
               if(previousPosition<0)
               {
                   previousPosition=i;
                   previousOperator='^';
               }
               break;
           }           
           
       } 
       // Loop jumps to here, on *
       if(previousOperator=='*')
       {  // System.out.println("here"); 
       //System.out.println(expr.substring(0,previousPosition));
       //System.out.println(expr.substring(previousPosition+1,expr.length()));
        // System.out.println(evaluateExpression(expr.substring(0,previousPosition)));
           return (evaluateExpression(expr.substring(0,previousPosition))) * 
                   evaluateExpression(expr.substring(previousPosition+1,expr.length()));
       }
       // Loop jumps to here, on /
       if(previousOperator=='/')
       {    
           return evaluateExpression(expr.substring(0,previousPosition)) /
                   evaluateExpression(expr.substring(previousPosition+1,expr.length()));
       }
       // Loop jumps to here, on %
       if(previousOperator=='%')
       {
           return evaluateExpression(expr.substring(0,previousPosition)) %
                   evaluateExpression(expr.substring(previousPosition+1,expr.length()));
       }
       // Loop jumps to here, on ^
       if(previousOperator=='^')
       {
          // System.out.println(evaluateExpression(expr.substring(0,previousPosition)));
           return Math.pow(evaluateExpression(expr.substring(0,previousPosition)),
                   evaluateExpression(expr.substring(previousPosition+1,expr.length())));
       }
       //Checks brackets at the beginning and end of expression
       if(expr.charAt(0)=='(' && expr.charAt(expr.length()-1)==')')
       {
           return evaluateExpression(expr.substring(1,expr.length()-1));
       }
       
       //System.out.println("VALUE "+expr );
       //returns the value after converting the string to double
       return Double.parseDouble(expr);
    }
    
    public static void main(String args[])
    {
        System.out.println(evaluateExpression("2^(3^2)"));
    }
}

       
       
           
           
                   
       
