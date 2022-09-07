import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class Visualizer extends JFrame {
	
	int WIDTH = 1620;
	int HEIGHT = 1200;
	JLabel title, name, timeComplexity, spaceComplexity;
	Dimension titleSize, tcSize, scSize;
	JPanel mainPanel;
	
	
	public Visualizer() throws InterruptedException {
		// Frame variables
		this.setTitle("Sorting Algorithms Visualizer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setSize(WIDTH, HEIGHT);
		
		// Panels
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(64, 64, 64));
		mainPanel.setBounds(0, 0, WIDTH, 230);
		ArrayList<Integer> heights = this.generateArr();
		
		
		DrawRect rectArr = new DrawRect(heights);
		rectArr.setBackground(new Color(64, 64, 64));
		rectArr.setBounds(0, 230, WIDTH, 900);
		
		BubbleSort bs = new BubbleSort();
		heights = bs.sort(heights, rectArr);
		
		// Displayed Labels
		title = new JLabel("Sorting Algorithms Visualizer");
		title.setForeground(Color.WHITE);
		titleSize = title.getPreferredSize();
		title.setBounds(440, 20, titleSize.width + 545, titleSize.height + 65);
		title.setFont(new Font("Panton", Font.BOLD, 44));
		
		timeComplexity = new JLabel("Time Complexity: ");
		timeComplexity.setForeground(Color.WHITE);
		tcSize = timeComplexity.getPreferredSize();
		timeComplexity.setBounds(10, 20, tcSize.width + 150, tcSize.height + 50);
		timeComplexity.setFont(new Font("MV Boli", Font.BOLD, 22));
		
		spaceComplexity = new JLabel("Space Complexity: ");
		spaceComplexity.setForeground(Color.WHITE);
		scSize = spaceComplexity.getPreferredSize();
		spaceComplexity.setBounds(0, 70, scSize.width + 150, scSize.height + 50);
		spaceComplexity.setFont(new Font("MV Boli", Font.BOLD, 22));
		
		
		mainPanel.add(title);
		mainPanel.add(timeComplexity);
		mainPanel.add(spaceComplexity);
		mainPanel.setLayout(new BorderLayout());
		this.add(mainPanel);
		this.add(rectArr);
		this.setVisible(true);
	}
	public ArrayList<Integer> generateArr() {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int y = 1100; y >= 265; y -= 18)
			arr.add(y);
		Collections.shuffle(arr);
		System.out.println(arr);
		return arr;
	}
}