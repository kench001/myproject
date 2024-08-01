import java.io.*;
public class PracticeExeptionLoyola{
	public static void main (String [] args) Throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter your name: ");
		String name = reader.readLine();
		
		System.out.print("Your name is " + name );
	
	
	}
}