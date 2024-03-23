package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1157_단어공부{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] cnts = new int[27];
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			int cIdx = 0;
			if(c >= 'a' && c <= 'z') {
				cIdx = c-'a';
			}else {
				cIdx = c-'A';
			}
			cnts[cIdx]++;
		}
		
		int maxAlpha = 0;
		int maxCnt = 0;
		boolean isMany = false;
		for (int i = 0; i < 27; i++) {
			if(maxCnt < cnts[i]) {
				isMany = false;
				maxCnt = cnts[i];
				maxAlpha = i;
			}else if(maxCnt == cnts[i]) {
				isMany = true;
			}
		}
		
		if(isMany) {
			System.out.println("?");
		}else {
			System.out.println((char)('A'+maxAlpha));
		}
	}

}
