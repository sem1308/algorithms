package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1010_다리놓기{
	
	static int N,M;
	static int dp[][];
	
	public static int dfs(int m, int n) {
		if(n == m) return 1;
		if(n == 1) return m;
		if(dp[m-1][n] == 0) dp[m-1][n] = dfs(m-1,n);
		if(dp[m-1][n-1] == 0) dp[m-1][n-1] = dfs(m-1,n-1);
		
		return dp[m-1][n] + dp[m-1][n-1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 서쪽 N개
		 * 동쪽 M개
		 */
		
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());
		
		dp = new int[31][31];
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			
			// mCn = (m-1)C(n) + (m-1)C(n-1)
		
			sb.append(dfs(M,N)).append("\n");
		}
		
		System.out.println(sb);
	}

}
