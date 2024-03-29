package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_9465_스티커{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * dp[i][j] : i번째 행에서 j열 스티커를 선택했을 때 최대 점수
		 * 
		 * dp[i][j] = scores[i][j] + max(dp[1-i][j+1],max(dp[i][j+2],dp[1-i][j+2]));
		 */
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] scores = new int[2][n];
			
			for (int i = 0; i < 2; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					scores[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			int[][] dp = new int[2][n];
			
			dp[0][n-1] = scores[0][n-1];
			dp[1][n-1] = scores[1][n-1];
			
			for (int j = n-2; j >= 0; j--) {
				dp[0][j] = dp[1][j+1];
				dp[1][j] = dp[0][j+1];
				
				if(j != n-2) {
					int dpMax = Math.max(dp[0][j+2],dp[1][j+2]);
					dp[0][j] = Math.max(dp[0][j], dpMax);
					dp[1][j] = Math.max(dp[1][j], dpMax);
				}

				dp[0][j] += scores[0][j];
				dp[1][j] += scores[1][j];
			}
			
			int max = 0;
			for (int i = 0; i < Math.min(n, 2); i++) {
				max = Math.max(max,Math.max(dp[0][i], dp[1][i]));
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}
}
