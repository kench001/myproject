class GetTheHighestNumberInTheGivenArrayLoyola{
	public static void main(String [] args){
	
		/*
			Exercise 10.3 (10 pts.)
			Using the above values, have the programme print out the
			highest number in the array.
		*/
		System.out.println("Getting the highest number in the given array");
		
		int arrayNumbers[] = {23,6,47,35,2,14,};
		int highestNumber = arrayNumbers[0];
		
		for(int count = 1; count < arrayNumbers.length; count++){
			if(arrayNumbers[count] > highestNumber){
				highestNumber = arrayNumbers[count];
			}
		}
	
		System.out.println(highestNumber);
	
	}
}