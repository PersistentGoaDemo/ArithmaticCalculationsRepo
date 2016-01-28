package com.persistent.ArithmeticOperations.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.persistent.ArithmeticOperations.exceptions.MyException;
import com.persistent.ArithmeticOperations.serviceImpl.ArithmeticOperationsImpl;
import com.persistent.ArithmeticOperations.util.FileReaderUtil;

public class ApplicationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws MyException{
	

		 BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
         ArithmeticOperationsImpl arithmeticOperations = new  ArithmeticOperationsImpl();
		 int n=0,n1=0;
		 String inputData,inputData2;
		 int choice=0;
		 do{
			 // Is this really required? -----//
		 System.out.println("Please Select Choice from below\n");
		 System.out.println("1. Revese and check for palindrom number, armstrong");
		 System.out.println("2. Find Factorial of a number");
		 System.out.println("3. Find LCM of two numbers");
		 System.out.println("4. Perform some random operations on two numbers");
		 System.out.println("5. Prime number (input from file)");
		 System.out.println("6. Some more random operations on two numbers");
		 System.out.println("7.  fibonacci series");
		 System.out.println("8. Exit\n");
							
		 try {
			 inputData=in1.readLine();
			 if(!isInteger(inputData))
				 throw new MyException("Invalid choice.");
			 else
				 choice = Integer.parseInt(inputData);
		} catch (Exception e) {
			
		} 
		 
		 switch(choice){
			 case 1:
				 System.out.println("Enter a number to reverse: ");
				 try {
					 inputData=in1.readLine();
					 if(!isInteger(inputData))
						 throw new MyException("Invalid input.");	 
					 n = Integer.parseInt(inputData);
					 System.out.println("Reverse of " + n + " is " + arithmeticOperations.reverse(n));
					 if(arithmeticOperations.palindrome(n)==true)
						 System.out.println("Palindrome number");
					 else
						 System.out.println("Not a Palindrome number");
					

					 
				 } catch (Exception  e) {

					 boolean status=arithmeticOperations.armstrong(n);
					 if(status==true)
						 System.out.println("Armstrong number");
					 else
						 System.out.println("Not a Armstrong number");
				 } catch (Throwable e) {
					 System.out.println(e);
				 }
				break;
				
			 case 2:
				 System.out.println("Enter a number to find the factorial: ");
				 try {
					 inputData=in1.readLine();
					 if(!isInteger(inputData))
						 throw new MyException("Invalid input.");	 
					 n = Integer.parseInt(inputData);
					 System.out.println("Factorial of " + n + " is " + arithmeticOperations.factorial(n));
					 
				 } catch (Exception  e) {
					 System.out.println(e);
				 }break;
			 
			 case 3:
				 try {
					 System.out.println("\nEnter first number :  ");
					 inputData=in1.readLine();
					 System.out.println("\nEnter second number :  ");
					 inputData2=in1.readLine();
					 if(!isInteger(inputData) || !isInteger(inputData2) )
						 throw new MyException("Invalid input.");	 
					 n = Integer.parseInt(inputData);
					 n1 = Integer.parseInt(inputData2);
					 System.out.println("LCM of "+n+" and "+n1+" is "+arithmeticOperations.lcm(n,n1));
					 
				 } catch (Exception  e) {
					 System.out.println(e);
				 }
			
				break;
			 case 4:
				 try {
					 System.out.println("\nEnter first number :  ");
					 inputData=in1.readLine();
					 System.out.println("\nEnter second number :  ");
					 inputData2=in1.readLine();
					 if(!isInteger(inputData) || !isInteger(inputData2) )
						 throw new MyException("Invalid input.");	 
					 n = Integer.parseInt(inputData);
					 n1 = Integer.parseInt(inputData2);
					 System.out.println("Addition :  " + n + "+" + n1 + " = " + arithmeticOperations.add(n, n1));
					 System.out.println("Remainder : " + n + "%" + n1 + " = " + arithmeticOperations.rem(n, n1));
					 System.out.println("Quotient : " + n + "/" + n1 + " = " + arithmeticOperations.quot(n, n1));
						 
					 
				 } catch (Exception  e) {
					 System.out.println(e);
				 }
			
				break;
				
				
				 
			 case 5:
				 FileReaderUtil fileReader = new FileReaderUtil();
				 String fileName = "src\\demo.txt";
				 arithmeticOperations.primeNumbers(Integer.parseInt(fileReader.readFile(fileName)));
				
				 break;
				 
			 case 6:
				 try {
					 System.out.println("\nEnter first number :  ");
					 inputData=in1.readLine();
					 System.out.println("\nEnter second number :  ");
					 inputData2=in1.readLine();
					 if(!isInteger(inputData) || !isInteger(inputData2) )
						 throw new MyException("Invalid input.");	 
					 n = Integer.parseInt(inputData);
					 n1 = Integer.parseInt(inputData2);
					 boolean oddEvenStatus=arithmeticOperations.OddEven(n);
					 if(oddEvenStatus)
						 System.out.println(n + " is Even");
					 else
						 System.out.println(n + " is odd");
					 System.out.println("Product : " + n + "*" + n1 + " = " + arithmeticOperations.product(n,n1));
					 System.out.println("Square root of " + n + " = " + arithmeticOperations.squareRoot(n));
					 try{
						 if(n1==0)
							 throw new MyException("Divide by zero.");
						 System.out.println("Division : " + n + "/" + n1 + " = " + arithmeticOperations.divide(n,n1));
					 
						  
						 
						
					        
					 
					 }
					 catch(Exception  ex){
						 System.out.println(ex);
					 }
						 
					 
				 } catch (Exception  e) {
					 System.out.println(e);
				 }
				 
				 break;
			
			 case 7:
				 //------------fibonacci--------------------//
				 System.out.print("Enter number upto which Fibonacci series to print: ");
			        int number = new Scanner(System.in).nextInt();
			        System.out.println("\n\nFibonacci series upto " + number +" numbers : ");
			     //printing Fibonacci series upto number
			     for(int i=1; i<=number; i++){
			        System.out.print(arithmeticOperations.fibonacciRecusion(i) +" ");
			      }
			        //-------------end fibonacci------------//
			        
			        
				 break;
			default : System.out.println("Invalid choice.");
				 
		 }
}while(choice<8);
		

		
}
	
	
	
	  
		
	
	public static boolean isInteger(String s) {
	      boolean isValidInteger = false;
	      try	      {
	         Integer.parseInt(s);
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         System.out.println(ex);
	      }
	 
      return isValidInteger;
	   }
	 

	  

}
