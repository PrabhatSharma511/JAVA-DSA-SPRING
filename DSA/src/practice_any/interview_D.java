package practice_any;

public class interview_D {
	
	public static int[] pushZero(int[] arr) {
		int n = arr.length;
		int[] arr2 = new int[n];
		
		int j=0;
		for(int i=0;i<n;i++) {
			if(arr[i]!=0) {
				arr2[j]=arr[i];
				j++;
			}
		}
		return arr2;
	}

	public static void main(String[] args) {
		int[] arr = {1,0,3,5,2,0,4,0,0,0,8};
		int[] res = pushZero(arr);
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
		
		
	}
}
