package Sorting;

//merge sort is stable quick sort is not nut can be made by some changes in code

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = {2,9,4,3};
		divide(arr,0,arr.length-1);
		
		for(int i= 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	private static void divide(int[] arr, int si, int ei) {
		
		if(si>=ei) {
			return;
		}
		
//		O(logn (log of base 2))
		int mid = (si+ei)/2;
		
		divide(arr, si, mid);
		divide(arr, mid+1, ei);
		
		conquer(arr,si,mid,ei);
		
	}

	private static void conquer(int[] arr, int si, int mid, int ei) {
		
		int idx1 = si;
		int idx2 = mid+1;
		int x =0;
		
		int[] merged = new int[ei-si+1];
		
		//O(n)
		while(idx1<=mid && idx2<=ei) {
			if(arr[idx1]<=arr[idx2]) {
				merged[x] = arr[idx1];
				idx1++;
				x++;
			}else {
				merged[x] = arr[idx2];
				x++;
				idx2++;
			}
		}
		
		while(idx1<=mid) {
			merged[x] = arr[idx1];
			x++;
			idx1++;
		}
		
		while(idx2<=ei) {
			merged[x] = arr[idx2];
			idx2++;
			x++;
		}
		
		for(int i=0,j=si;i<merged.length;i++,j++) {
			arr[j] = merged[i];
		}
		
	}
	
}
