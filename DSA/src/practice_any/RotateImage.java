package practice_any;

public class RotateImage {

	public static void rotateMatrix(int[][] matrix) {
		int n= matrix.length;
		
		//transpose of matrix
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp = matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		
		
		for(int i=0;i<n;i++) {
			int left =0;
			int right=n-1;
			while(left<right) {
				int temp=matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right]=temp;
				left++;
				right--;
			}
		}
		
		
	}
	

	private static void printMatrix(int[][] matrix) {
		int n=matrix.length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] matrix = {{1,2},{3,4}};
		
		rotateMatrix(matrix);
		printMatrix(matrix);
		
	}

	
}
