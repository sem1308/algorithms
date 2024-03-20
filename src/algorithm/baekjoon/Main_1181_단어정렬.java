package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1181_단어정렬{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		Set<String> set = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			set.add(word);
		}
		
		List<String> list = new ArrayList<String>(set);
		
		Collections.sort(list,(a,b)->{
			if(a.length() == b.length()) {
				return a.compareTo(b);
			}
			return a.length() - b.length();
		});
		
		for (String word : list) {
			System.out.println(word);
		}
		
	}

}
