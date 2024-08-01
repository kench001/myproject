import javax.swing.JOptionPane;
public class GetTheAreaOfRectangleLoyola{
	public static void main(String [] args){
	
		/*
        Exercise 11.1 - 50pts.
        Input boxes are not just used for text: they can accept numbers as well.
        Write a programme that prompts the user for two numbers, the  breadth of
        a rectangle and the height of a rectangle. Use a message box to 
        calculate the area of the rectangle. (Remember: the area of a rectangle 
        its breadth multiplied by the height.)
        */
	
		JOptionPane.showMessageDialog(null, "Getting the area of the rectangle");
		
		String breadth = JOptionPane.showInputDialog("First number for Width");
		double breadthNumber = Double.parseDouble(breadth);
		
		String height = JOptionPane.showInputDialog("Second number for Height");;
		double heightNumber = Double.parseDouble(height);
		
		double areaOfRectangle = breadthNumber * heightNumber;
		
		JOptionPane.showMessageDialog(null, "The are of rectangle is " + areaOfRectangle);
		
		System.exit(0);
	}
}