package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1197_최소스패닝트리{
	
	static class Edge implements Comparable<Edge>{
		int a,b;
		int w;
		public Edge(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int[] parents;
	
	public static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(tokens.nextToken());
		int E = Integer.parseInt(tokens.nextToken());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			pq.add(new Edge(a,b,w));
		}
		
		parents = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		int numComplete = 0;
		int totalW = 0;
		while(!pq.isEmpty() && numComplete+1 < V) {
			Edge edge = pq.poll();
			
			int pa = find(edge.a);
			int pb = find(edge.b);
			
			if(pa == pb) continue;
			
			parents[pa] = pb;
			numComplete++;
			totalW += edge.w;
		}
		
		System.out.println(totalW);
	}
}
