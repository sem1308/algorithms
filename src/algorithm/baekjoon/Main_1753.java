package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1753{
	
	static class Edge{
		int to;
		int dist;

		public Edge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	
	static int V,E,K;
	
	static List<Edge>[] edges;
	static int[] minDist;
	
	static boolean[] visited;
	
	public static int getVert() {
		int idx = 1;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= V; i++) {
			if(!visited[i] && minDist[i] < min) {
				min = minDist[i];
				idx = i;
			}
		}
		
		return idx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(tokens.nextToken()); // 정점 개수
		E = Integer.parseInt(tokens.nextToken()); // 간선 개수
		
		edges = new ArrayList[V+1]; // 정점에 연결된 간선 정보 ( 연결된 정점, 거리 )
		
		for (int i = 1; i <= V; i++) {
			edges[i] = new ArrayList<>();
		}
		
		K = Integer.parseInt(br.readLine()); // 시작 정점
		
		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			
			edges[u].add(new Edge(v,w)); // 간선 정보 저장
		}
		
		visited = new boolean[V+1]; // 선택된 정점 체크 배열
		minDist = new int[V+1]; // 정점 K에서 다른 정점까지 최소 거리 저장 배열
		Arrays.fill(minDist, Integer.MAX_VALUE);

		visited[K] = true;
		for(Edge e : edges[K]) {
			minDist[e.to] = Math.min(minDist[e.to], e.dist); // 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음 처리
		}
		minDist[K] = 0;
		
		int numSelected = 1; // 선택된 정점 개수
		while(numSelected < V) { // 모든 정점 개수를 선택할 때 까지
			int v = getVert(); // 아직 선택되지 않는 정점중 최소 거리 정점 가져오기 
			visited[v] = true; // 정점 선택
			
			// 선택된 정점 개수 증가
			numSelected++;

			// 해당 정점에 연결된 간선 정보를 통해 최소 거리 업데이트
			for(Edge e : edges[v]) {
				minDist[e.to] = Math.min(minDist[e.to], minDist[v] + e.dist);
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(minDist[i] == Integer.MAX_VALUE ? "INF" : minDist[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
