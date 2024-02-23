package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution_1251_하나로
{
	static class Vertex{
		int idx;
		double dist;
		
		public Vertex(int idx, double dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}
	
	public static Vertex getVertex(boolean[] visited, PriorityQueue<Vertex> minDist) {
		while(!minDist.isEmpty()) {
			Vertex v = minDist.poll();
			if(!visited[v.idx]) {
				return v;
			}
		}
		return null;
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		StringTokenizer tokens;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			
			long[][] coords = new long[N][2];
			
			double[][] dists = new double[N][N];
			
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				coords[i][0] = Integer.parseInt(tokens.nextToken());
				
				for (int j = 0; j < i; j++) {
					dists[i][j] = dists[j][i] = Math.pow(coords[i][0] - coords[j][0], 2);
				}
			}

			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				coords[i][1] = Integer.parseInt(tokens.nextToken());
				for (int j = 0; j < i; j++) {
					dists[i][j] = dists[j][i] += Math.pow(coords[i][1] - coords[j][1], 2);
				}
			}
			
			double E = Double.parseDouble(br.readLine());
			
			boolean[] visited = new boolean[N];
			
			PriorityQueue<Vertex> minDist = new PriorityQueue<>((a,b)->(int)(a.dist-b.dist));
			minDist.offer(new Vertex(0,0));
			
			double answer = 0;
			for (int i = 0; i < N; i++) {
				Vertex v = getVertex(visited, minDist);
				visited[v.idx] = true;
				
				answer += v.dist;
				
				for (int j = 0; j < N; j++) {
					if(visited[j]) continue;
					minDist.offer(new Vertex(j,dists[v.idx][j]));
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(Math.round(E * answer)).append('\n');
		}
		
		System.out.print(sb.toString());
	}
}