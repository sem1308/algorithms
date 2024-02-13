package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.util.StringTokenizer;

class Solution_4012_요리사
{
	static int[][] favors = new int[17][17];
	static int N;
	static int halfN;
	
	static int answer;
	static boolean[] selected = new boolean[17];
	
	public static void comb(int idx, int cnt) {
		if(cnt == halfN) {
			int Afavor = 0;
			int Bfavor = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(selected[i] && selected[j]) Afavor += (favors[i][j]+favors[j][i]);
					if(!selected[i] && !selected[j]) Bfavor += (favors[i][j]+favors[j][i]);
				}
			}
			
			answer = Math.min(answer, Math.abs(Afavor - Bfavor));
			
			return;
		}
		
		for (int i = idx; i < N; i++) {
			selected[i] = true;
			comb(i+1,cnt+1);
			selected[i] = false;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		/*
		 * 두 명의 손님에게 음식 제공
		 * 최대한 비슷한 맛의 음식
		 * 
		 * 식재료 N/2개씩 나누어 요리
		 * 
		 * A,B 음식 맛 차이가 최소가 되도록 재료 배분
		 * 
		 * 재료 i,j가 만나면 시너지 발생
		 * 
		 * 음식의 맛 = 시너지 합
		 */
		
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer tokens;
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			halfN = N/2;
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					favors[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			answer = Integer.MAX_VALUE;
			
			comb(0,0);
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}