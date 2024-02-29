package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_9229_한빈이와_Spot_Mart {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			
			/*
			 * N개 과자, 각 ai그램 무게
			 * 
			 * 최대한 양이 많은 과자 봉지 고르고 싶음
			 * 두 봉지의 무게가 M그램 초과하면 들고 다닐 수 없음
			 * 
			 * 들고 다닐 수 있는 과자들의 최대 무게 합 출력
			 * 
			 */
			
			int[] weights = new int[N];

			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(tokens.nextToken());
			}

			int answer = -1;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					int sum = weights[i] + weights[j];
					if(sum <= M) answer = Math.max(answer, sum);
				}
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
