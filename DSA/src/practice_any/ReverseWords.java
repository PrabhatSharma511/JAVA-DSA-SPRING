package practice_any;

public class ReverseWords {
	
	public static void reverse(char[] arr, int left, int right) {
		while(left<right) {
			char temp = arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;
			right--;
		}
	}
	
	public static String secondWay(String s) {
		char[] arr = s.toCharArray();
		
		int i = 0; int j=0;
		while(j<arr.length) {
			while(j<arr.length && arr[j]==' ') {
				j++;
			}
			while(j<arr.length && arr[j]!=' ') {
				arr[i++]=arr[j++];
			}
			while(j<arr.length && arr[j]==' ') {
				j++;
			}
			if(j<arr.length) {
				arr[i++]=' ';
			}
		}
		int n = i;
		reverse(arr, 0, n-1);
		
		int start = 0;
		for(int end=0;end<=n;end++) {
			if(end == n || arr[end]==' ') {
				reverse(arr, start, end-1);
				start=end+1;
			}
		}
		
		return new String(arr,0,n);
	}
	
	public static void main(String[] args) {
		String s = "  the sky is blue    "; //Output: "blue is sky the"
		System.out.println(reverseWords(s));
		System.out.println(secondWay(s));
	}
	
	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		int i = s.length()-1;
		while(i>=0) {
			while(i>=0 && s.charAt(i)==' ') {
				i--;
			}
			int j = i;
			while(i>=0 && s.charAt(i)!=' ') {
				i--;
			}
			sb.append(s.substring(i+1,j+1));
			sb.append(" ");
		}
		return sb.toString().trim();
	}

}
