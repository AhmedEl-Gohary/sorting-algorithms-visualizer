import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
	
	JLabel title;
	Rectangle titlePos;
	JLabel name;
	JPanel panel;
	
	public App() {
		// Frame variables
		this.setTitle("Sorting Algorithms Visualizer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1600, 1200);
		
		// Upper Panel
		panel = new JPanel();
		panel.setBackground(new Color(64, 64, 64));
		
		// Title
		title = new JLabel("Sorting Algorithms Visualizer");
		title.setForeground(Color.white);
		title.setFont(new Font("MV Boli", Font.BOLD, 42));
		panel.add(title);
		
		// 
		
		this.add(panel);
		this.setVisible(true);
	}
}