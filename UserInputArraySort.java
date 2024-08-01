import java.util.*;
class UserInputArraySort{
	public static void main(String [] args){
		
		Scanner userInput = new Scanner(System.in);
	
		System.out.println("Enter a number of storage you want");
		int numbers = userInput.nextInt();
		
		System.out.println("Now enter " + numbers + " Integers");
		
		int integers[] = new int[numbers];
		
		for(int count = 0; count < numbers; count++){
			integers[count] = userInput.nextInt();
		}
		Arrays.sort(integers);
		
		for(int count = 0; count < numbers;	count++){
			
			System.out.print("The sort for the user input intergers are: ");
			System.out.println(integers[count]);
		}
		
	}
}