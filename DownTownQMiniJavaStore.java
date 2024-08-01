import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DownTownQMiniJavaStore{
	public static void main(String [] args){
		
		String data[][] = {
            {"A", "3-in-1 Coffee", "10.00"},
            {"B", "Cup Noodles", "20.00"},
            {"C", "Laundry Soap", "25.00"},
            {"D", "Bottled water-1 liter", "20.00"},
			{"E", "Bottled water-500 ml", "12.00"}
        };
		
		String columnNames [] = {"Item code","Item Descriptopn","Price"};
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		JTable table = new JTable(model);
		
		table.setFillsViewportHeight(true);
		
		JFrame menuFrame = new JFrame(); //menu frame
		menuFrame.setTitle("DowntownQ Mini JAVA STORE");
		menuFrame.setResizable(false);
		menuFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		menuFrame.setSize(800,800);
		menuFrame.setVisible(true);
		menuFrame.add(table);
		table.setVisible(true);
		
	}
}