import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Visualizer extends JFrame {
	
	public static final int WIDTH = 1620;
	public static final int HEIGHT = 1200;
	public static boolean sorted = false;
	JLabel title, name, timeComplexity, spaceComplexity;
	JButton shuffle, visualize;
	JComboBox<String> algorithms;
	String sortingAlgo;
	Dimension titleSize, tcSize, scSize;
	JPanel mainPanel = new JPanel();
	ArrayList<Integer> heights = generateArr();
	DrawRect rectArr = new DrawRect(heights);
	
	
	public Visualizer() throws InterruptedException {
		// Frame variables
		this.setTitle("Sorting Algorithms Visualizer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setSize(WIDTH, HEIGHT);
		
		// Panels
		mainPanel.setBackground(new Color(64, 64, 64));
		mainPanel.setBounds(0, 0, WIDTH, 230);
		mainPanel.setLayout(null);
		
		rectArr.setBackground(new Color(64, 64, 64));
		rectArr.setBounds(0, 230, WIDTH, 900);
		
		
		
		// Displayed Labels
		title = new JLabel("Sorting Algorithms Visualizer");
		title.setForeground(Color.WHITE);
		titleSize = title.getPreferredSize();
		title.setBounds(440, 20, titleSize.width + 545, titleSize.height + 65);
		title.setFont(new Font("Panton", Font.BOLD, 44));
		
		name = new JLabel("Developed by: Ahmed El-Gohary");
		name.setForeground(Color.WHITE);
		name.setBounds(600, 100, 545, 65);
		name.setFont(new Font("Panton", Font.BOLD, 24));
		
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
		
		
		// Buttons
		String[] sorting = {"Select Algorithm", "Bubble Sort", "Quick Sort", "Insertion Sort", "Merge Sort"};
		algorithms = new JComboBox<String>(sorting);
		algorithms.setBounds(1320, 30, 280, 40);
		algorithms.setFont(new Font("MV Boli", Font.BOLD, 26));
		
		visualize = new JButton("Visualize");
		visualize.setBounds(1370, 90, 200, 40);
		visualize.setFont(new Font("MV Boli", Font.BOLD, 26));
		
		shuffle = new JButton("Shuffle");
		shuffle.setBounds(1370, 150, 200, 40);
		shuffle.setFont(new Font("MV Boli", Font.BOLD, 26));
		
		mainPanel.add(algorithms);
		mainPanel.add(visualize);
		mainPanel.add(shuffle);
		mainPanel.add(title);
		mainPanel.add(name);
		mainPanel.add(timeComplexity);
		mainPanel.add(spaceComplexity);
		
		this.add(mainPanel);
		this.add(rectArr);
		this.validate();
		this.setVisible(true);
		
		BubbleSort bs = new BubbleSort();
		bs.sort(heights, rectArr);
	/*	
		// Event Handling
		BubbleSort bs = new BubbleSort();
		algorithms.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				sortingAlgo = (String) algorithms.getSelectedItem();
			}
			
		});
		
		visualize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sortingAlgo.equals(sorting[1])) {
					try {
						bs.sort(heights, rectArr);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else if (sortingAlgo.equals(sorting[2])){
					
				} else if (sortingAlgo.equals(sorting[3])) {
					
				} else if (sortingAlgo.equals(sorting[4])) {
					
				} 
			}
		});
		shuffle.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				heights = generateArr();
				rectArr.setArr(heights);
				repaint();
			}
		});
		
		*/
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