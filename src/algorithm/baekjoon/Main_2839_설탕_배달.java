package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2839_설탕_배달 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		if(N >= 3) dp[3] = 1;
		if(N >= 5) dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i], Math.min(dp[i-3], dp[i-5])+1);
		}
		
		if(dp[N] == Integer.MAX_VALUE-1) System.out.println("-1");
		else System.out.println(dp[N]);
	}
}
