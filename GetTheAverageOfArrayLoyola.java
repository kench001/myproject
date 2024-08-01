class GetTheAverageOfArrayLoyola{
	public static void main(String [] args){
		
		/*
			Exercise 10.2 (10 pts.)
			Set up an array to hold the following values, and in this order:
			23, 6, 47, 35, 2, 14. Write a programme
			to get the average of all 6 numbers.
		*/
		System.out.println("Getting the average of the given array");
		
		double totalSum;
		double totalAverage;
		int arrayNumbers[] = {23,6,47,35,2,14,};
		
		System.out.println("The element given: ");
		for(int count = 0; count < arrayNumbers.length; count++){
			System.out.println(arrayNumbers[count]);
		}
		
		totalSum = arrayNumbers[0] + arrayNumbers[1] + arrayNumbers[2] + arrayNumbers[3] + arrayNumbers[4] + arrayNumbers[5];
		
		totalAverage = totalSum / arrayNumbers.length;
		
		System.out.println("\nThe total average is " + totalAverage);
	}
}