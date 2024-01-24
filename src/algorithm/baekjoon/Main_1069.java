package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] P = new int[N];

        int minP = 50;
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(tokenizer.nextToken());
			Math.min(minP, P[i]);
		}
        
        int M = Integer.parseInt(br.readLine());
        
        // dp[m][n] : m원으로 만들 수 있는 최대 n자리 숫자
        // dp[m][n] = max(p[i] * 10^n + dp[m-p[i]][n-1])
        
        String[][] dp = new String[M+1][M+1];
        
        for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= M; j++) {
				
			}
		}
        
    }
}