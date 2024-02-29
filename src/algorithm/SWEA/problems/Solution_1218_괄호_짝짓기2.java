package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1218_괄호_짝짓기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = 10;

		StringBuilder sb = new StringBuilder();

		int[] counts = new int[4];
		
		for (int t = 1; t <= T; t++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			boolean isValid = true;

			int countIdx = 0;
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				boolean isOpen = false;
				switch(c) {
					case '(':
						isOpen = true;
						countIdx = 0;
						break;
					case ')': 
						countIdx = 0;
						break;
					case '[':
						isOpen = true;
						countIdx = 1;
						break;
					case ']':
						countIdx = 1;
						break;
					case '{':
						isOpen = true;
						countIdx = 2;
						break;
					case '}':
						countIdx = 2;
						break;
					case '<':
						isOpen = true;
						countIdx = 3;
						break;
					case '>':
						countIdx = 3;
						break;
				}
				
				if(isOpen) {
					// 지금 온게 여는 거라면
					counts[countIdx]++;
				} else {
					// 지금 온게 닫는 거라면
					if(counts[countIdx] != 0) {
						counts[countIdx]--;
					}else {
						break;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				if(counts[i] != 0) {
					isValid = false;
				}
				counts[i] = 0;
			}
			
			sb.append("#").append(t).append(" ").append(isValid ? "1" : "0").append("\n");
		}
		System.out.print(sb.toString());
	}
}
