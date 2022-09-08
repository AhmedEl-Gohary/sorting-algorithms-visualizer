import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
	
	double increment = 0.05;
	// Sorting in non-increasing order of Y coordinates so that it sorted visually
	public void sort(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
		boolean swapped;
		for (int i = 0; i < arr.size() - 1; i++) {
			swapped = false;
			for (int j = 0; j < arr.size() - 1 - i; j++) {
				Visualizer.noOfComparisons++;
				if (arr.get(j) < arr.get(j + 1)) {
					Collections.swap(arr, j, j + 1);
					swapped = true;
					Thread.sleep(30);
					rectArr.setArr(arr);					
		            rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
		            vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
		            increment = -increment;
				}
			}
			if (!swapped) break;
			System.out.println(arr);
		}
		vis.comparisons.setText("No. of Comparisons: " + Visualizer.noOfComparisons);
		Visualizer.noOfComparisons = 0;
	}

} 
