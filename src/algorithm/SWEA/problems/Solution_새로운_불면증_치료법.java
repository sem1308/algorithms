package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_새로운_불면증_치료법 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int check = 0;
			int num = (1 << 10)-1;

			int curN = N;
			
			int mod = 10;
			while(true) {
				int n = curN;
				while(n != 0) {
					int digit = n % mod;
				
					check |= 1 << digit;
					
					n /= mod;
				}
				
				if((check & num) == num) break;
				
				curN += N;
			}
			
			sb.append("#").append(t).append(" ").append(curN).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
