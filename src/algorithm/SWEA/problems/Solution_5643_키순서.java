package algorithm.SWEA.problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5643_키순서
{
	static int N, M, adj[][], cnt;
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
        
        StringTokenizer tokens;
        
        // 내 앞에 몇 명이고 내 뒤에 몇 명인지 정확히 하는 사람
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				adj[i][0] = -1;
			}
			
			for(int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(tokens.nextToken());
				int b = Integer.parseInt(tokens.nextToken());
				
				adj[a][b] = 1;
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] == -1) dfs(i);
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[0][j] += adj[i][j];
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] + adj[0][i] == N-1) ans++;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
        
        System.out.println(sb);
    }
    
    private static void dfs(int cur) {
    	for (int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1) {
				if(adj[i][0] == -1) {
					dfs(i);
				}
				if(adj[i][0] > 0) {
					for (int j = 1; j <= N; j++) {
						if(adj[i][j] == 1) {
							adj[cur][j] = 1;
						}
					}
				}
			}
		}
    	int numGt = 0;
    	for (int i = 1; i <= N; i++) {
    		numGt += adj[cur][i];
    	}
    	adj[cur][0] = numGt;
    }
}