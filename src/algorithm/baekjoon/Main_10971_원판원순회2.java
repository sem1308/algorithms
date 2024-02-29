package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_10971_원판원순회2{

	static int N;
	static int[][] W;
	
	static boolean[] visited;
	static int answer;
	
	public static void dfs(int idx, int cnt, int cost, int stIdx) {		
		if(cost >= answer) return;
		
		if(cnt == N) {
			if(W[idx][stIdx] != 0) {
				answer = Math.min(answer, cost + W[idx][stIdx]);
			}
			return;
		}
		
		visited[idx] = true;
		
		for (int i = 0; i < N; i++) {
			if(visited[i] || W[idx][i] == 0) continue;
			dfs(i,cnt+1, cost+W[idx][i], stIdx);
		}
		
		visited[idx] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		answer = Integer.MAX_VALUE;
		visited = new boolean[N];
		dfs(0,1,0,0);
		
		System.out.println(answer);
	}
}
