package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_1208_Flatten
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;

		StringBuilder sb = new StringBuilder();
		
		int[] boxHeights = new int[100];
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				boxHeights[i] = Integer.parseInt(tokens.nextToken());
			}
			
			Arrays.sort(boxHeights);

			int minIdx=-1;
			int maxIdx=100;
			for (int i = 0; i < cnt; i++) {
				if(minIdx == -1) {
					do {
						minIdx++;
					}while(boxHeights[minIdx] == boxHeights[minIdx+1]);
				}
				
				if(maxIdx == 100) {
					do {
						maxIdx--;
					}while(boxHeights[maxIdx] == boxHeights[maxIdx-1]);
				}
				
				boxHeights[minIdx--]++;
				boxHeights[maxIdx++]--;
			}
			
			sb.append("#").append(test_case).append(" ").append(boxHeights[99]-boxHeights[0]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}