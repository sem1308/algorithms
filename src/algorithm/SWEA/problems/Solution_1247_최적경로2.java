package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로2 {
	
	static class Coord{
		int x,y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean[] visited = new boolean[12];
	static int[][] dists = new int[12][12];
	static int N;
	static int answer;
	
	public static void dfs(int cnt, int dist, int curIdx) {
		if(cnt == N) {
			answer = Math.min(answer, dist+dists[curIdx][N+1]);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(curIdx == i || visited[i]) continue;
			visited[i] = true;
			dfs(cnt+1,dist+dists[curIdx][i],i);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		/*
		 * 회사 출발 -> N명 고객 방문 -> 집 돌아오는 가장 짧은 경로
		 */

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			tokens = new StringTokenizer(br.readLine());
			
			Coord[] coords = new Coord[N+2];

			int cx = Integer.parseInt(tokens.nextToken());
			int cy = Integer.parseInt(tokens.nextToken());
			int hx = Integer.parseInt(tokens.nextToken());
			int hy = Integer.parseInt(tokens.nextToken());
			
			coords[0] = new Coord(cx,cy);
			coords[N+1] = new Coord(hx,hy);
			
			answer = Integer.MAX_VALUE;
			
			for (int i = 1; i < N+2; i++) {
				if(i!=N+1) {
					int x = Integer.parseInt(tokens.nextToken());
					int y = Integer.parseInt(tokens.nextToken());
					coords[i] = new Coord(x, y);
				}
				
				for (int j = 0; j < i; j++) {
					dists[i][j] = dists[j][i] = Math.abs(coords[i].x - coords[j].x) + Math.abs(coords[i].y - coords[j].y);
				}
			}

			dfs(0,0,0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
