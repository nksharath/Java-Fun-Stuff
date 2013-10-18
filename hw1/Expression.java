/**
*@Problem       : To Evaluate an Expression 
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707 
*@Version       : 1.0.4
*@LastModified  : 09/12/2012 11.50 PM
*
*/
import java.util.*;
import java.io.*;
import java.math.*;

public class Expression {
    
   static int precedence(char operator)
    {
        switch(operator)
        {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return 1;
    }               
        
    
    
    public static void main(String args[])
    {
        String postfix="";
        Stack<Character> operatorStack=new Stack<Character>();
        Stack<Double> result=new Stack<Double>();   
        String expr="2*3^5";
        String temp="";
        String number="";
        //System.out.println(expr.length());
        
       
        for(int i=0;i<expr.length();i++)
        {
          
            if(expr.charAt(i)!='+'
                    && expr.charAt(i)!='-'
                    && expr.charAt(i)!='*'
                    && expr.charAt(i)!='/'
                    && expr.charAt(i)!='%'
                    && expr.charAt(i)!='^')
            {
             number+=(number+Character.toString(expr.charAt(i)));  
             postfix+=(number);
             //i++;             
            }        
            //System.out.println(postfix);
            
            
            if(expr.charAt(i)=='+'
                    || expr.charAt(i)=='-'
                    || expr.charAt(i)=='*'
                    || expr.charAt(i)=='/'
                    || expr.charAt(i)=='%'
                    || expr.charAt(i)=='^')
            {
                if(operatorStack.empty())
                    operatorStack.push(expr.charAt(i));
                
                else                
                    while(!operatorStack.empty() && (precedence(expr.charAt(i))<=precedence(operatorStack.peek())))
                    {
                        operatorStack.pop();
                        postfix+=(Character.toString(operatorStack.peek()));
                    }
                    operatorStack.push(expr.charAt(i));
            }
        
        }       
        
        
        while(!operatorStack.empty())
            postfix+=(Character.toString(operatorStack.pop()));
        
       // System.out.println(postfix);
        
 
        
        for(int i=0;i<postfix.length();i++)
        {
            if(postfix.charAt(i)!='+'
                    && postfix.charAt(i)!='-'
                    && postfix.charAt(i)!='*'
                    && postfix.charAt(i)!='/'
                    && postfix.charAt(i)!='%'
                    && postfix.charAt(i)!='^')       
            result.push(Double.parseDouble(Character.toString(postfix.charAt(i))));
            
            if(postfix.charAt(i)=='+')
            {
                double operandOne=result.pop();
                double operandTwo=result.pop();
                double solution=operandOne+operandTwo;
                result.push(solution);
            }
            if(postfix.charAt(i)=='-')
            {
                double operandOne=result.pop();
                double operandTwo=result.pop();
                double solution=operandOne-operandTwo;
                result.push(solution);
            }
            if(postfix.charAt(i)=='*')
            {
                double operandOne=result.pop();
                double operandTwo=result.pop();
                double solution=operandOne*operandTwo;
                result.push(solution);
            }
            if(postfix.charAt(i)=='/')
            {
                double operandOne=result.pop();
                double operandTwo=result.pop();
                double solution=operandOne/operandTwo;
                result.push(solution);
            }
            if(postfix.charAt(i)=='%')
            {
                double operandOne=result.pop();
                double operandTwo=result.pop();
                double solution=operandOne%operandTwo;
                result.push(solution);
            }
            if(postfix.charAt(i)=='^')
            {
                double operandOne=result.pop();
                double operandTwo=result.pop();
                double solution=Math.pow(operandOne,operandTwo);
                result.push(solution);
            }
            
        }
        System.out.println("Result: "+result.pop());
    }
}
            
                
                
                
            
        
        
        
        
        
        
            
           
            
        
                
        