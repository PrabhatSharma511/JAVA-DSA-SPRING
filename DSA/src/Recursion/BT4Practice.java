package Recursion;

public class BT4Practice {

	public static void main(String[] args) {
		int n =8;
		solve(n);
	}
	

	private static void solve(int n) {
		
		for(int a=1;a<n;a++) {
			for(int b=1;b<n;b++) {
				boolean[][] visited = new boolean[n][n];
				int result = findMinMoves(0,0,n,a,b,0,visited);
				System.out.print((result == Integer.MAX_VALUE ? -1 : result) + (b < n - 1 ? " " : ""));
			}
			System.out.println();
		}
		
	}

	private static int findMinMoves(int x, int y, int n, int a, int b, int moves,boolean[][] visited) {
		
		if(x==n-1 && y==n-1) {
			return moves;
		}
		
		visited[x][y] = true;
		
		int newMoves = Integer.MAX_VALUE;
		
		int[][] directions = {
				{a,b},{a,-b},{-a,b},{-a,-b},
				{b,a},{-b,a},{b,-a},{-b,-a}
		};
		
		for(int[] dir: directions) {
			
			int newX = x+dir[0];
			int newY = y+dir[1];
			if(newX<n && newY<n && newX>=0 && newY>=0 && !visited[newX][newY]) {
				int currentMoves = findMinMoves(newX, newY, n, a, b, moves+1,visited);
				newMoves = Math.min(newMoves, currentMoves);
			}
			
		}
		
		visited[x][y] = false;
		return newMoves;
		
		
	}
	
}






//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//class Result {
//
//    /*
//     * Complete the 'knightlOnAChessboard' function below.
//     *
//     * The function is expected to return a 2D_INTEGER_ARRAY.
//     * The function accepts INTEGER n as parameter.
//     */
//
//    public static List<List<Integer>> knightlOnAChessboard(int n) {
//        List<List<Integer>> bigList= new ArrayList<>();
//        
//        for(int a =1;a<n;a++){  
//            List<Integer> list= new ArrayList<>();
//            for(int b=1;b<n;b++){
//                
//                boolean[][] visited = new boolean[n][n];
//                Integer result = findMinMoves(0,0,n,a,b,0,visited);
//                list.add(result==987654321?-1:result);
//            }
//            bigList.add(list);
//        }
//        
//        return bigList;
//
//    }
//    public static Integer findMinMoves(int x,int y,int n,int a,int b,Integer moves,boolean[][] visited){
//        
//        if(x==n-1 && y==n-1){
//            return moves;
//        }
//        
//       int[][] directions = {
//                {a,b},{a,-b},{-a,b},{-a,-b},
//                {b,a},{-b,a},{b,-a},{-b,-a}
//        };
//        
//        visited[x][y] = true;
//        Integer newMoves = 987654321;
//        
//        for(int[] dir : directions){
//            int newX = x+dir[0];
//            int newY = y+dir[1];
//            if(newX>=0 && newY>=0 && newX<n && newY<n && !visited[newX][newY] ){
//                int currentMoves = findMinMoves(newX,newY,n,a,b,moves+1,visited);
//                newMoves = Math.min(currentMoves,newMoves);
//            }
//        }
//        
//            visited[x][y] = false;
//            return newMoves;
//        
//        
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> result = Result.knightlOnAChessboard(n);
//
//        result.stream()
//            .map(
//                r -> r.stream()
//                    .map(Object::toString)
//                    .collect(joining(" "))
//            )
//            .map(r -> r + "\n")
//            .collect(toList())
//            .forEach(e -> {
//                try {
//                    bufferedWriter.write(e);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            });
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
//
