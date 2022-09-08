import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
	public void sort(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
		double increment = 0.05;
		for (int i = 0; i < arr.size() - 1; i++) {
			Visualizer.noOfComparisons++;
			if (arr.get(i) < arr.get(i + 1)) {
				Collections.swap(arr, i, i + 1);
				Thread.sleep(30);
				rectArr.setArr(arr);					
	            rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
	            vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
	            increment = -increment;
				for (int j = i; j > 0; j--) {
					Visualizer.noOfComparisons++;
					if (arr.get(j) > arr.get(j - 1)) {
						Collections.swap(arr, j, j - 1);
						Thread.sleep(30);
						rectArr.setArr(arr);					
			            rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
			            vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
			            increment = -increment;
			            System.out.println(arr);
					} else break;
				}
			}
		}
		vis.comparisons.setText("No. of Comparisons: " + Visualizer.noOfComparisons);
		Visualizer.noOfComparisons = 0;
	}
}
