class MultiDimentionalArraySpreadSheetLoyola{
	public static void main(String [] args){
		/*
			Write a program that will print out all the valuest of MultiDimensional Array in a table form like in spreadsheet.
			Use for Loop.
		*/
		
		System.out.println("MultiDimentional Array Spreadsheet");
		
		int givenArray [] [] = {
			{1, 4, 43},
			{2, 2, 13},
			{3, 4, 23},
			{5, 7, 19},
			{5, 2, 1},
			{11, 12, 51}};
			
		for(int row = 0; row < givenArray.length; row++){
			for(int column = 0; column < givenArray[row].length; column++){
			System.out.printf("\t%d\t",givenArray[row][column]);	
			}
			System.out.println();
		}
		
		
	}
}