package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.util.StringTokenizer;

class Solution_5215_햄버거_다이어트
{
	static int[] scores = new int[21];
	static int[] calories = new int[21];
	
	static int N, L;
	static int answer;
	
	public static void subset(int idx, int score, int calory) {
		if(calory > L) return;
		
		if(idx == N) {
			answer = Math.max(answer, score);
			return;
		}

		subset(idx+1,score+scores[idx], calory+calories[idx]);
		subset(idx+1,score, calory);
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer tokens;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());
			
			answer = 0;

			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(tokens.nextToken());
				calories[i] = Integer.parseInt(tokens.nextToken());
			}
			
			subset(0,0,0);
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}