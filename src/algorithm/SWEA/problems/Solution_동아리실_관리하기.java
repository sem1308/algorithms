package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class Solution_동아리실_관리하기
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		/*
		 * N일 간의 활동
		 * 
		 * 1. 그 날에 그 조합을 선택했을 때 가능한 경우의 수를 저장하는 N, 16 배열 생성
		 * 	- dp = new int[N][16];
		 * 2. 맨 뒤 날부터 dp 돌리기
		 * 
		 * dp[i][j]
		 * if( j 번째 조합에 책임자가 있고 그 다음날 조합(k)에 j번째 조합에 있는 사람이 있으면 )
		 * 	dp[i][j] = (dp[i][j]+dp[i+1][k]) % MOD;
		 * 
		 * 
		 * 
		 * 
		 */
		
		/*
		 * 1. (A),(B),(C),(D)
		 * 2. (A,B), (A,C), (A,D), (B,C), (B,D), (C,D)
		 * 3. (A,B,C), (A,B,D), (A,C,D), (B,C,D)
		 * 4. (A,B,C,D)
		 */
		
		boolean[][] combinations = new boolean[15][4];
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						combinations[cnt][0] = i == 1 ? true : false;
						combinations[cnt][1] = j == 1 ? true : false;
						combinations[cnt][2] = k == 1 ? true : false;
						combinations[cnt][3] = l == 1 ? true : false;
						cnt++;
					}
				}
			}
		}
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = br.readLine();
			
			int N = str.length();
			
			// N <= 10000 => N^2 까지 가능
			// N * 16 * 16 가능
			
			int[][] dp = new int[N+1][16];
			
			Arrays.fill(dp[N], 1);
			
			for (int i = N-1; i >= 0; i--) {
				int manager = str.charAt(i) - 'A';
				for (int j = 1; j < 16; j++) {
					// 현재 날짜의 조합
					boolean[] comb = combinations[j];
					
					boolean isValid = false;
					for (int k = 0; k < 4; k++) {
						if(comb[manager]) {
							isValid = true;
							break;
						}
					}
					
					if(!isValid) continue;
					
					for (int k = 1; k < 16; k++) {
						// 다음 날짜의 조합
						boolean[] comb2 = combinations[j];
						for (int c = 0; c < 4; c++) {
							
						}
					}
				}
			}
			
			int answer = 0;
			for (int i = 1; i < 16; i++) {
				answer += dp[0][i];
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}