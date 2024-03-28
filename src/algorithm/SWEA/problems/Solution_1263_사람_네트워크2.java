package algorithm.SWEA.problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람_네트워크2
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
        
        StringTokenizer tokens;
        
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
        	tokens = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(tokens.nextToken());

        	int[][] dp = new int[N][N];
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dp[i][j] = Integer.parseInt(tokens.nextToken());
					if(dp[i][j] == 0) {
						dp[i][j]=N;
					}
				}
			}
        	
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					for (int k = 0; k < N; k++) {
						if(k == j || k == i) continue;
						dp[i][k] = Math.min(dp[i][k], dp[i][j]+dp[j][k]);
					}
				}
			}
        	
        	int min = Integer.MAX_VALUE;
        	for (int i = 0; i < N; i++) {
        		int sum = 0;
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					sum += dp[i][j];
				}
				min = Math.min(min, sum);
			}
        	
        	sb.append("#").append(t).append(" ").append(min).append("\n");
		}
        System.out.println(sb);
    }
}