package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_2001_파리_퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}

			int sum = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}
			}
			
			int answer = sum;
			
			int limit = N-M;
			for (int i = 0; i <= limit; i++) {
				int curSum = sum;
				for (int j = 0; j < limit; j++) {
					for (int k = i; k < i+M; k++) {
						curSum += (map[k][j+M] - map[k][j]);
					}
					answer = Math.max(answer, curSum);
				}				
				if(i == limit) break;
				for (int j = 0; j < M; j++) {
					sum += (map[i+M][j] - map[i][j]);
				}
				answer = Math.max(answer, sum);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
