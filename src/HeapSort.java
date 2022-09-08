import java.util.ArrayList;
import java.util.Collections;

public class HeapSort {
	public static double increment = 0.05;
	public void sort(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
		int n = arr.size();
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i, rectArr, vis);
		for (int i = n - 1; i > 0; i--) {
			Collections.swap(arr, 0, i);
			Thread.sleep(50);
			rectArr.setArr(arr);					
            rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
            vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
            increment = -increment;
			heapify(arr, i, 0, rectArr, vis);
			System.out.println(arr);
		}
		vis.comparisons.setText("No. of Comparisons: " + Visualizer.noOfComparisons);
		Visualizer.noOfComparisons = 0;
	}
	public void heapify(ArrayList<Integer> arr, int n, int i, DrawRect rectArr, Visualizer vis) throws InterruptedException {
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		// update the max if left node is greater
		if (left < n && arr.get(left) < arr.get(max))
			max = left;
		// update the max if right node is greater
		if (right < n && arr.get(right) < arr.get(max))
			max = right;
		
		// if the max element is not the root, I need to heapify
		if (max != i) {
			Collections.swap(arr, i, max);
			Thread.sleep(50);
			rectArr.setArr(arr);					
            rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
            vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
            increment = -increment;
			heapify(arr, n, max, rectArr, vis);
		}
		Visualizer.noOfComparisons += 3;
	}
}
