import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
	
	// Sorting in non-increasing order 
	public void sort(ArrayList<Integer> arr, DrawRect rectArr) throws InterruptedException {
		boolean swapped;
		for (int i = 0; i < arr.size() - 1; i++) {
			swapped = false;
			for (int j = 0; j < arr.size() - 1 - i; j++) {
				if (arr.get(j) < arr.get(j + 1)) {
					Collections.swap(arr, j, j + 1);
					swapped = true;
					Thread.sleep(15);
					rectArr.removeAll();
		            rectArr.setArr(arr);
		            rectArr.revalidate();
		            rectArr.paintImmediately(0, 230, 1620, 900);
					System.out.println(arr);
				}
			}
			if (!swapped) break;
		}
		Visualizer.sorted = true;
	}

} 
