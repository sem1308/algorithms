package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_3289_서로소_집합 {
	
	public static int[] parent;
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) parent[pb] = pa;
	}
	
	public static int find(int num) {
		int root = num;
		while(parent[root] != -1) {
			root = parent[root];
		}
		if(num != root) parent[num] = root;
		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(tokens.nextToken()); // n개 집합
			int M = Integer.parseInt(tokens.nextToken()); // 연산 개수
			
			parent = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parent[i] = -1;
			}
			
			StringBuilder sbtemp = new StringBuilder();
			
			for (int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(tokens.nextToken());
				int a = Integer.parseInt(tokens.nextToken());
				int b = Integer.parseInt(tokens.nextToken());
				
				switch(op) {
					case 0:
						union(a,b);
						break;
					case 1:
						int pa = find(a);
						int pb = find(b);
						sbtemp.append(pa == pb ? "1" : "0");
						break;
					default:
						break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(sbtemp).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
