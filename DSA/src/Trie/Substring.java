package Trie;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Substring {
	
	public static void main(String[] args) {
		String str = "ababa";
		List<String> lis = listOfSubstrings(str);
//		System.out.println(lis);

		System.out.println((new HashSet<>(lis)).size());
	}

	private static List<String> listOfSubstrings(String str) {
		List<String> list = new ArrayList<>();
		for(int i =0;i<str.length();i++) {
			for(int j=i;j<=str.length();j++) {
				list.add(str.substring(i, j));
			}
		}
		return list;
	}

}
