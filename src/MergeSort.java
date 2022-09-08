import java.util.ArrayList;

public class MergeSort {
	public static double increment = 0.05;
	public void sort(ArrayList<Integer> arr, int start, int end, DrawRect rectArr, Visualizer vis) throws InterruptedException {
		if (start >= end) return;
		int mid = (start + end) / 2;
		sort(arr, start, mid, rectArr, vis);
		sort(arr, mid + 1, end, rectArr, vis);
		merge(arr, start, mid, end, rectArr, vis);
		vis.comparisons.setText("No. of Comparisons: " + Visualizer.noOfComparisons);
	}
	static void merge(ArrayList<Integer> arr, int start, int mid, int end, DrawRect rectArr, Visualizer vis) throws InterruptedException {
		int[] tmp = new int[end - start + 1];
		int l = start;
		int r = mid + 1;
		for (int i = 0; i < tmp.length; i++) {
			Visualizer.noOfComparisons++;
			if(l > mid)
				tmp[i] = arr.get(r++);
			else if(r > end)
				tmp[i] = arr.get(l++);
			else if(arr.get(l) < arr.get(r)) 
				tmp[i] = arr.get(r++);
			else
				tmp[i] = arr.get(l++);
		}
		for(int i = 0; i < tmp.length; i++) {
			arr.set(start + i, tmp[i]);
			Thread.sleep(40);
			rectArr.setArr(arr);					
            rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
            vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
            increment = -increment;
		}
	}
	
}
