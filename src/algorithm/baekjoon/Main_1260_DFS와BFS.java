package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	
	static int N,M,V;
	static List<Integer>[] adjList;
	static StringBuilder sb;
	
	public static void dfs(int v, boolean[] visited) {
		visited[v] = true;
		sb.append(v).append(" ");
		for (int n : adjList[v]) {
			if(visited[n]) continue;
			dfs(n, visited);
		}
	}
	
	public static void bfs(int v, boolean[] visited) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			sb.append(v).append(" ");
			for (int n : adjList[v]) {
				if(visited[n]) continue;
				visited[n] = true;
				q.add(n);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());

		adjList = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
		
		sb = new StringBuilder();
		
		dfs(V,new boolean[N+1]);
		
		sb.append("\n");
		
		bfs(V,new boolean[N+1]);
		
		System.out.println(sb.toString());
	}
}
