import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Visualizer extends JFrame implements ActionListener {
	
	public static final int WIDTH = 1620;
	public static final int HEIGHT = 1200;
	public static boolean sorted = false;
	public static char sortingAlgo;
	public static int noOfComparisons = 0;
	JLabel title, name, timeComplexity, spaceComplexity, comparisons;
	JButton shuffle, visualize;
	JComboBox<String> algorithms;
	Dimension titleSize, tcSize, scSize;
	JPanel mainPanel = new JPanel();
	ArrayList<Integer> heights = generateArr();
	DrawRect rectArr = new DrawRect(heights);
	
	// TODO: complete Initialization of sorting Algorithms
	BubbleSort bs = new BubbleSort();
	HeapSort hs = new HeapSort();
	InsertionSort is = new InsertionSort();
	MergeSort ms = new MergeSort();
	
	public Visualizer() throws InterruptedException {
		// Frame variables
		this.setTitle("Sorting Algorithms Visualizer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
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
		name.setBounds(580, 100, 545, 65);
		name.setFont(new Font("Panton", Font.BOLD, 26));
		
		timeComplexity = new JLabel("Time Complexity: ");
		timeComplexity.setForeground(Color.WHITE);
		tcSize = timeComplexity.getPreferredSize();
		timeComplexity.setBounds(10, 20, tcSize.width + 300, tcSize.height + 50);
		timeComplexity.setFont(new Font("MV Boli", Font.BOLD, 22));
		
		spaceComplexity = new JLabel("Space Complexity: ");
		spaceComplexity.setForeground(Color.WHITE);
		scSize = spaceComplexity.getPreferredSize();
		spaceComplexity.setBounds(10, 70, scSize.width + 300, scSize.height + 50);
		spaceComplexity.setFont(new Font("MV Boli", Font.BOLD, 22));
		
		comparisons = new JLabel("No. of Comparisons: ");
		comparisons.setForeground(Color.WHITE);
		comparisons.setBounds(10, 95, 400, 120);
		comparisons.setFont(new Font("MV Boli", Font.BOLD, 22));
		
		
		// Drop-down menu
		algorithms = new JComboBox<String>(new String[]{"Select Algorithm", "Bubble Sort", "Heap Sort", "Insertion Sort", "Merge Sort"});
		algorithms.setBounds(1320, 30, 280, 40);
		algorithms.setFont(new Font("MV Boli", Font.BOLD, 26));
		
		// Buttons
		visualize = new JButton("Visualize");
		visualize.setBounds(1360, 90, 200, 40);
		visualize.setFont(new Font("MV Boli", Font.BOLD, 26));
		
		shuffle = new JButton("Shuffle");
		shuffle.setBounds(1360, 150, 200, 40);
		shuffle.setFont(new Font("MV Boli", Font.BOLD, 26));
		
		// Adding labels to the main panel
		mainPanel.add(algorithms);
		mainPanel.add(visualize);
		mainPanel.add(shuffle);
		mainPanel.add(title);
		mainPanel.add(name);
		mainPanel.add(timeComplexity);
		mainPanel.add(spaceComplexity);
		mainPanel.add(comparisons);
		
		// Adding panels to the frame
		this.add(mainPanel);
		this.add(rectArr);
		this.validate();
		this.setVisible(true);
		
		// Handling User Input
		Visualizer handler = this;
		algorithms.addActionListener(handler);
		visualize.addActionListener(handler);
		shuffle.addActionListener(handler);
	}
	
	// Generating a new shuffled array
	public ArrayList<Integer> generateArr() {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int y = 1100; y >= 265; y -= 18)
			arr.add(y);
		Collections.shuffle(arr);
		System.out.println(arr);
		return arr;
	}
	
	// Event Handling
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == algorithms) {
			noOfComparisons = 0;
			if (algorithms.getSelectedItem() == "Bubble Sort") {
				sortingAlgo = 'b';
				timeComplexity.setText("Time Complexity: O(n^2)");
				spaceComplexity.setText("Space Complexity: O(1)");
				comparisons.setText("No. of Comparisons: " + noOfComparisons);
			} else if (algorithms.getSelectedItem() == "Heap Sort") {
				sortingAlgo = 'h';
				timeComplexity.setText("Time Complexity: O(nlog(n))");
				spaceComplexity.setText("Space Complexity: O(1)");
				comparisons.setText("No. of Comparisons: " + noOfComparisons);
			} else if (algorithms.getSelectedItem() == "Insertion Sort") {
				sortingAlgo = 'i';
				timeComplexity.setText("Time Complexity: O(n^2)");
				spaceComplexity.setText("Space Complexity: O(1)");
				comparisons.setText("No. of Comparisons: " + noOfComparisons);
			} else if (algorithms.getSelectedItem() == "Merge Sort") {
				sortingAlgo = 'm';
				timeComplexity.setText("Time Complexity: O(nlog(n))");
				spaceComplexity.setText("Space Complexity: O(n)");
				comparisons.setText("No. of Comparisons: " + noOfComparisons);
			} else {
				sortingAlgo = 'x';
			}
		} else if (event.getSource() == visualize && !sorted) {
			if (sortingAlgo == 'b') {
				try {
					bs.sort(heights, rectArr, this);
					sorted = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (sortingAlgo == 'h') {
				try {
					hs.sort(heights, rectArr, this);
					sorted = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (sortingAlgo == 'i') {
				try {
					is.sort(heights, rectArr, this);
					sorted = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (sortingAlgo == 'm') {
				try {
					ms.sort(heights, 0, heights.size() - 1, rectArr, this);
					sorted = true;
					noOfComparisons = 0;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else if (event.getSource() == shuffle) {
			heights = generateArr();
			rectArr.removeAll();
			rectArr.setArr(heights);
			rectArr.revalidate();
            rectArr.paintImmediately(0, 230, WIDTH, 900);
            sorted = false;
		} 
		
	}
	
}