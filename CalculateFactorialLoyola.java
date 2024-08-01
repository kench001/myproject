import java.util.*;

public class CalculateFactorialLoyola{
	public static void main(String [] args){
	
		int positiveInteger;
		
		System.out.println("Calculate the Factorial");
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter a positive integer number: ");
		positiveInteger = userInput.nextInt();
		
		int factorial = 0;
		
		for(int i = 1; i <= positiveInteger ; i++){
			factorial *= 1;
		}
		
		System.out.println("The factorial of " + positiveInteger + " is " + factorial);
	
	}
}