package sort;
import java.util.Arrays;

public class Sort {

	/**
	 * 冒泡排序
	 * 
	 * @param array
	 * @return
	 */
	public static void bubbleSort(int[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (a[i] > a[j]) {
					a[i] = a[i] + a[j];
					a[j] = a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
		}
	}

	/**
	 * 普通插入排序
	 * 
	 * @param a
	 * @return
	 */
	public static void insertSort(int[] a) {
		int len = a.length;
		for (int i = 1; i < len; i++) {
			int temp = a[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (a[j] > temp) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			a[j + 1] = temp;
		}
	}

	/**
	 * 二分插入排序
	 * 
	 * @param args
	 */
	public static void midInsertSort(int[] a) {
		int len = a.length;
		for (int i = 1; i < len; i++) {
			int low = 0;
			int high = i - 1;
			int mid = (low + high) / 2;
			int temp = a[i];
			for (; low < high; mid = (low + high) / 2) {
				if (temp < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			for (int j = i - 1; j > low; j--) {
				a[j + 1] = a[j];
			}
			a[low] = temp;
		}
	}

	/**
	 * 希尔排序
	 * 
	 * @param
	 * @return
	 */
	public static void shellSort(int[] a) {
		int len = a.length;
		for (int h = len / 2; h > 0; h = h / 2) {
			for (int i = 0; i < h; i++) {
				for (int j = i + h; j < len; j = j + h) {
					int temp = a[j];
					int k;
					for (k = j - h; k >= 0; k = k - h) {
						if (a[k] > temp) {
							a[k + h] = a[k];
						} else {
							break;
						}
					}
					a[k + h] = temp;
				}
			}
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param a
	 * @return
	 */
	public static void chooseSort(int[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			int min = a[i];
			int n = i;
			for (int j = i + 1; j < len; j++) {
				if (min > a[j]) {
					min = a[j];
					n = j;
				}
			}
			a[n] = a[i];
			a[i] = min;
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] a, int left, int right) {
		if (a.length <= 1) {
			return;
		}
		if (left >= right) {
			return;
		}
		int mid = getMiddle(a, left, right);
		quickSort(a, left, mid - 1);
		quickSort(a, mid + 1, right);
	}

	/**
	 * 快速排序找到 枢轴的位置
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	public static int getMiddle(int[] a, int low, int high) {
		int temp = a[low];// 基准元素
		while (low < high) {
			// 找到比基准元素小的元素位置
			while (low < high && a[high] >= temp) {
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] <= temp) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = temp;
		return low;
	}

	/**
	 * 归并排序
	 * @param a
	 * @param b
	 * @param left
	 * @param right
	 */
	public static void  mergeSort(int[] a,int[] b,int left,int right){
		if(a.length==1||left>=right){
			return;
		}
		int mid = (left+right)/2;
		mergeSort(a,b,left,mid);
		mergeSort(a,b,mid+1,right);
		mergeArray(a,b,left,mid,right);
	}
	
	public static void  mergeArray(int[] a,int[] b,int left,int mid,int right){
		int c[] = new int[a.length];
		int i = left;
		int j = mid +1;
		int k = 0;
		while(i<=mid&&j<=right){
			if(a[i]<=a[j]){
				c[k++] = a[i++];
			}else{
				c[k++] = a[j++];
			}
		}
		while(i<=mid){
			c[k++] = a[i++];
		}
		while(j<=right){
			c[k++] = a[j++];
		}
		for(int x=0;x<k;x++){//复制数组回来
			a[left+x]=c[x];
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 9, 3, 4, 5, 6, 2, 3, 8, 7, 1 };
		int[] b = a;
		mergeSort(a,b,0, a.length - 1);
		System.out.println(Arrays.toString(b));

	}
}
