package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_base{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		FileReader fr = new FileReader("src/algorithm/baekjoon/dict.txt");
		
		char[] buffer = new char[25];
		
		Set<String> set = new HashSet<>();
		
		int len = 0;
		while((len = fr.read(buffer)) > 0) {
			System.out.println(String.valueOf(buffer, 0, len));
			set.add(String.valueOf(buffer, 0, len));
		}
		
		System.out.println(set.size());
		
	}
}
