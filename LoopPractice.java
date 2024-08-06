import java.util.*;

public class LoopPractice{
	public static void main (String [] args){
	
		Scanner userInput = new Scanner (System.in);
	
		System.out.println("Practice Looping");
	
		System.out.println("Basic Looping");
	
		for(int i = 0; i <=3; i++){
			System.out.println(i);
		}
		
		System.out.println("Looping an array");
		int grades [] = {99,91,92,95};
		
		for (int i = 0; i < grades.length; i++){
			System.out.println(grades[i]);
		}
		
		System.out.println("Looping and getting user Input");
		
		int getNum;
		
		System.out.println("Input your 3 numbers here: ");
		getNum = userInput.nextInt();
		
		for(int i = 0; i<2; i++){
			getNum = userInput.nextInt();
		}
	
	}
}