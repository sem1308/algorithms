package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1504_특정한_최단_경로{
	
	static class Edge implements Comparable<Edge>{
		int to;
		int dist;

		public Edge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist-o.dist;
		}
	}
	
	public static void dijkstra(int[] minDist, List<Edge>[] edges, int start) {
		Arrays.fill(minDist, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (Edge edge : edges[start]) {
			minDist[edge.to] = edge.dist;
			pq.add(edge);
		}
		
		minDist[start] = 0;
		while(!pq.isEmpty()){
			Edge edge = pq.poll();
			
			for (Edge e : edges[edge.to]) {
				if(minDist[e.to] > edge.dist + e.dist) {
					minDist[e.to] = edge.dist + e.dist;
					pq.add(new Edge(e.to,minDist[e.to]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 1번 -> N번
		 * 임의 주어진 두 정점 반드시 통과
		 * u,v
		 * 
		 * 1 -> u -> v -> N;
		 * 1 -> v -> u -> N;
		 * 
		 */
		
		tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int E = Integer.parseInt(tokens.nextToken());
		
		List<Edge>[] edges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			edges[a].add(new Edge(b,c));
			edges[b].add(new Edge(a,c));
		}
		tokens = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(tokens.nextToken());
		int v = Integer.parseInt(tokens.nextToken());
		
		int[] minDist1 = new int[N+1];
		int[] minDistU = new int[N+1];
		int[] minDistV = new int[N+1];
		
		dijkstra(minDist1, edges, 1);
		dijkstra(minDistU, edges, u);
		dijkstra(minDistV, edges, v);
		
		int dist1 = -1;
		if(minDist1[u] != Integer.MAX_VALUE && 
			minDistU[v] != Integer.MAX_VALUE && 
			minDistV[N] != Integer.MAX_VALUE ) {
			dist1 = minDist1[u] + minDistU[v] + minDistV[N];
		}
		
		int dist2 = -1;
		if(minDist1[v] != Integer.MAX_VALUE && 
			minDistV[u] != Integer.MAX_VALUE && 
			minDistU[N] != Integer.MAX_VALUE ) {
			dist2 = minDist1[v] + minDistV[u] + minDistU[N];
		}
		
		System.out.println(Math.min(dist1, dist2));
	}
}
