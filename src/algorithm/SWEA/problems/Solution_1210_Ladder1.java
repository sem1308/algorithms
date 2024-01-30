package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_1210_Ladder1
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int t = Integer.parseInt(br.readLine());
			
			int[][] map = new int[102][102];
			
			for (int i = 1; i <= 100; i++) {
				StringTokenizer tokens = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());					
				}
			}

			int x = 1;
			int y = 100;
			for (int i = 1; i <= 100; i++) {
				if(map[100][i]==2) {
					x = i;
					break;
				}
			}
			
			while(y != 1) {
				if(map[y][x+1] == 1) {
					do {
						x++;
					}while(map[y][x+1] == 1);
				}else if(map[y][x-1] == 1) {
					do {
						x--;
					}while(map[y][x-1] == 1);
				}
				y--;
			}
			
			sb.append("#").append(test_case).append(" ").append(x-1).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}