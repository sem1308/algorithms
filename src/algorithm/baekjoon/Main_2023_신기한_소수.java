package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한_소수{
	
	static int N;
	
	static StringBuilder sb;
	
	static int[] odds = {1,3,5,7,9};

	public static void comb(int cnt, int num) {
		if(cnt == N) {
			sb.append(num).append("\n");
			return;
		}
		
		num *= 10;

		int digit;
		for (int i = 0; i < 5; i++) {
			if(cnt == 0 && i == 0) digit = 2;
			else digit = odds[i];
			
			int n = num+digit;
			boolean isValid = true;
			for (int j = 2; j <= Math.sqrt(n); j++) {
				if(n % j == 0) {
					isValid = false;
					break;
				}
			}
			if(isValid) comb(cnt+1, n);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		comb(0, 0);

		System.out.print(sb.toString());
	}
}
