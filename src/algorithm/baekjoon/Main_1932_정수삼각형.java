package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1932_정수삼각형{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][n+1];
		
		for (int i = 0; i < n; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				dp[i][j] += Integer.parseInt(tokens.nextToken()); 
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
				dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(dp[n-1][i], answer);
		}
		System.out.println(answer);
	}

}