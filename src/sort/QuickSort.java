package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[]{9,8,2,2,1,6,5};
		sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	
	public static int getMiddle(int[] array,int low,int high){
		int temp = array[low];
		while(low<high){
			while(low<high&&array[high]>=temp){
				high--;
			}
			array[low]=array[high];
			while(low<high&&array[low]<=temp){
				low++;
			}
			array[high]=array[low];
		}
		array[low] = temp;
		return low;
	}
	
	public static void sort(int[] array,int low,int high){
		if (low >= high) {
			return;
		}
		int middle = getMiddle(array, low, high);
		sort(array, low, middle-1);
		sort(array, middle+1, high);
	}
	
	
}
