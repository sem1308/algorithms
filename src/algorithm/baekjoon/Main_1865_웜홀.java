package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1865_웜홀{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * N개 지점 사이 M개 도로, W개 웜홀
		 * 
		 * 웜홀은 도착하면 시간이 뒤로 감
		 * 
		 * 출발했을 때 보다 시간이 되돌아가 있는 경우 탐색
		 * 
		 */
		
		int MAX = 5_000_000;
		int[][] dp = new int[501][501];
		
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < TC; tc++) {
			
			tokens = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			int W = Integer.parseInt(tokens.nextToken()); 
			
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dp[i], MAX);
			}
			
			for (int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(tokens.nextToken());
				int E = Integer.parseInt(tokens.nextToken());
				int T = Integer.parseInt(tokens.nextToken()); 
				
				dp[S][E] = dp[E][S] = Math.min(dp[S][E], T);
			}
			
			for (int i = 0; i < W; i++) {
				tokens = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(tokens.nextToken());
				int E = Integer.parseInt(tokens.nextToken());
				int T = Integer.parseInt(tokens.nextToken()); 

				dp[S][E] = Math.min(dp[S][E], -T);
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(j == i) continue;
					for (int k = 1; k <= N; k++) {
						if(k == j) continue;
						dp[i][k] = Math.min(dp[i][k], dp[i][j]+dp[j][k]);
					}
				}
			}
			
			boolean isValid = false;
			for (int i = 1; i <= N; i++) {
				if(dp[i][i] < 0) {
					isValid = true;
					break;
				}
			}
			sb.append(isValid ? "YES\n" : "NO\n");
		}
		
		System.out.println(sb);
	}
}
