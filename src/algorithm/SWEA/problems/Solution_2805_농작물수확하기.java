package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution_2805_농작물수확하기2
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int half = N/2;
			
			String[] map = new String[N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine();
			}
			
			int answer = 0;
			
			// 홀수 layer 
			for (int i = 0; i < half+1; i++) {
				int x = half+i;
				int y = i;
				for (int j = 0; j < half+1; j++) {
					answer += map[x--].charAt(y++);
				}
			}
			
			// 짝수 layer
			for (int i = 0; i < half; i++) {
				int x = half+i;
				int y = i+1;
				for (int j = 0; j < half; j++) {
					answer += map[x--].charAt(y++);
				}
			}

			// 1 -> 1
			// 3 -> 1 + 4
			// 5 -> 1 + 4 + 8
			// 2n+1 -> 1 + 4(1+2+3+...+n)
			//		-> 1 + 2n(n+1)
			answer -= '0'*(1+2*half*(half+1));
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}