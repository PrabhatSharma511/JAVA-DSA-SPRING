package Sorting;

//Quick sort wtc is O(nsquare) when pivot is always largest or smallest) but it does not require extra space
//merge sort all time complexity is O(nlogn) but it requires an extra array of n size 
//Merge sort has a space complexity of O(n). This is because it uses an auxiliary array of size n to merge the sorted halves of the input array. The auxiliary array is used to store the merged result, and the input array is overwritten with the sorted result.

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {2,1,4,8,3,5,12,9};
		int n = arr.length;
		
		quickSort(arr,0,n-1);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		
		if(low<high) {
			int piv = partition(arr,low,high);
			
			quickSort(arr, low, piv-1);
			quickSort(arr, piv+1, high);
		}

	}

	private static int partition(int[] arr, int low, int high) {
		
		int piv = arr[high];
		int i = low-1;
		
		for(int j = low;j<high;j++) {
			if(arr[j]<piv) {
				i++;
				int temp=arr[i];
				arr[i] = arr[j];
				arr[j]=temp;
			}
		}
		
		i++;
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		
		return i;
	}
	
}
