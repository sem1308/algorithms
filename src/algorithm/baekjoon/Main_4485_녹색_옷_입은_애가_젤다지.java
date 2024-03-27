package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_4485_녹색_옷_입은_애가_젤다지{
	
	static int N;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int cost;
		
		public Edge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0)break;

			int[][] cost = new int[N][N];
			int[][] minCost = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(minCost[i], Integer.MAX_VALUE);
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cost[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			minCost[0][0] = cost[0][0];
			minCost[0][1] = cost[0][0]+cost[0][1];
			minCost[1][0] = cost[0][0]+cost[1][0];
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0, 1, minCost[0][1]));
			pq.add(new Edge(1, 0, minCost[1][0]));
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				
				for (int k = 0; k < 4; k++) {
					int nx = edge.x + dx[k];
					int ny = edge.y + dy[k];
					
					if(nx < 0 || nx == N || ny < 0 || ny == N) continue;
					
					int nextCost = edge.cost + cost[nx][ny];
					
					if(nextCost < minCost[nx][ny]) {
						minCost[nx][ny] = nextCost;
						pq.add(new Edge(nx,ny,nextCost));
					}
				}
			}
			sb.append("Problem ").append(idx++).append(": ").append(minCost[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
