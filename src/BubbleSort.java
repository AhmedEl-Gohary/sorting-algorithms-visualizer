import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
	
	// Sorting in non-increasing order
	public ArrayList<Integer> sort(ArrayList<Integer> arr, DrawRect draw) throws InterruptedException {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i+1; j < arr.size(); j++) {
				if (arr.get(i) < arr.get(j)) {
					Collections.swap(arr, i, j);
					Thread.sleep(10);
                    draw.removeAll();
                    //draw.updateArray(arr);
                    draw.revalidate();
                    draw.paintImmediately(0,30,870,532);
				}
			}
		}
		System.out.println(arr);
		return arr;
	}
} 
