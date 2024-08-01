import java.util.*;
class SortPractice{
	public static void main (String [] args){
	
		System.out.println("Array sorting");
		
		int arr[] = {2,3,43,23,12,3,5};
		Arrays.sort(arr);
		
		
		for(int count = 0; count < arr.length; count++){
			
			System.out.println(arr[count]);
		}
		
	}
}