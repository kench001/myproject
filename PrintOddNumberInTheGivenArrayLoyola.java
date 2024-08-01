class PrintOddNumberInTheGivenArrayLoyola{
	public static void main(String [] args){
	
		/*
			Exercise 10.4 (10 pts.)
			Using the same array above, have the programme print out only
			the odd numbers.
		*/
		System.out.println("Printing the odd numbers in the given array");
		
		int arrayNumbers[] = {23,6,47,35,2,14,};
		
		System.out.println("The odd numbers are: " );
		for(int count = 0; count < arrayNumbers.length; count++){
			if(arrayNumbers[count] % 2 != 0){
				System.out.println(arrayNumbers[count]);
			}
		}
	
	
	}
}