package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	static class Coord{
		int x,y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean[] visited = new boolean[12];
	static int[] minDist = new int[12];
	static int N;
	
	public static int getMinVertex() {
		int idx=0;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < N+2; i++) {
			if(visited[i]) continue;
			if(minDist[i] < min) {
				idx = i;
				min = minDist[i];
			}
		}
		
		return idx;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		/*
		 * 회사 출발 -> N명 고객 방문 -> 집 돌아오는 가장 짧은 경로
		 */

		int[][] dist = new int[12][12];
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			tokens = new StringTokenizer(br.readLine());
			
			Coord[] coords = new Coord[N+2];
			
			for (int i = 0; i < N+2; i++) {
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				coords[i] = new Coord(x, y);
				
				minDist[i] = Integer.MAX_VALUE;
				visited[i] = false;
				for (int j = 0; j < i; j++) {
					dist[i][j] = dist[i][j] = Math.abs(coords[i].x - coords[j].x) + Math.abs(coords[i].y - coords[j].y);
				}
			}

//			for (int k = 0; k < N+2; k++) {
//				for (int j = 0; j < N+2; j++) {
//					System.out.print(dist[k][j]+" ");
//				}
//				System.out.println();
//			}
			
			// 다익스트라 
			// 0번째 index에서 1번째 index로 가는 최적의 거리 계산
			minDist[0] = 0;
			
			for (int i = 0; i < N+2; i++) {
				int idx = getMinVertex();
				visited[idx] = true;
				
				for (int j = 0; j < N+2; j++) {
					if(idx==j) continue; 
					minDist[j] = Math.min(minDist[j], minDist[idx]+dist[idx][j]);
				}
			}
			
			sb.append("#").append(t).append(" ").append(minDist[1]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
