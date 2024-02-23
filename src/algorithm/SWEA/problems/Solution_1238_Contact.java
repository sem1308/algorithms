package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_1238_Contact
{
	static class Vertex{
		int idx;
		int len;

		public Vertex(int idx, int len) {
			this.idx = idx;
			this.len = len;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		StringBuilder sb = new StringBuilder();

		StringTokenizer tokens;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			tokens = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int V = Integer.parseInt(tokens.nextToken());
			
			List<Integer>[] edges = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				edges[i] = new ArrayList<>();
			}
			
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				
				edges[from].add(to);
			}
			
			boolean[] visited = new boolean[101];
			Queue<Vertex> q = new ArrayDeque<>();
			
			visited[V] = true;
			q.add(new Vertex(V, 0));
			
			int answer = V;
			int maxLen = 0;
			
			while(!q.isEmpty()) {
				Vertex v = q.poll();
				
				if(v.len > maxLen) {
					maxLen = v.len;
					answer = v.idx;
				}else if(v.len == maxLen && answer < v.idx){
					answer = v.idx;
				}
				
				for (int i : edges[v.idx]) {
					if(visited[i]) continue;
					visited[i] = true;
					q.add(new Vertex(i, v.len+1));
				}
				
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append('\n');
		}
		
		System.out.print(sb.toString());
	}
}