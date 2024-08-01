import java.util.*;
public class LoyolaGuessTheNumberGame{
	public static void main (String [] args){
		
		Scanner userInput = new Scanner (System.in);
		
		int randomNumber = (int) (Math.random() * 50 + 1);
		
		int guess;
		int attempts = 1;
		
		System.out.println("Welcome to the Guessing The Number Game!!");
		
		System.out.println("Instruction: You need to guess the number between 1 - 50  and you have multiple tries until you get the correct number.");
		
		System.out.print("Enter your Guess Number here (Attempt #" + attempts +"): ");
		
		do{
			guess = userInput.nextInt();
			++attempts;
				if (guess > randomNumber){
					System.out.println("The guess number is lower than " + guess);
					System.out.print("Enter a number again (Attempt #" + attempts +"): ");
				}else if (guess < randomNumber) {
					System.out.println("The guess number is higher than " + guess);
					System.out.print("Enter a number again (Attempt #" + attempts +"): ");
				}
				
		} while (guess != randomNumber);
				System.out.println("Congratulations, you got it right after " + (attempts - 1) + " attempts");
				
	}//end of method
}//end of class