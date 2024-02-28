package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1600_말이_되고픈_원숭이{

	static int K;
	static int[][][] dp;
	static int[][] map;
	
	static int W,H;
	
	static int[] jumpDx = {1,1,2,2,-2,-2,-1,-1};
	static int[] jumpDy = {2,-2,1,-1,1,-1,2,-2};
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static boolean isRange(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
	
	public static void dfs(int x, int y, int k) {
		dp[x][y][k] = Integer.MAX_VALUE-1;
		
		if(x == H-1 && y == W-1) {
			dp[x][y][k] = 0;
			return;
		}
		
		if(k > 0) {
			for (int i = 0; i < 8; i++) {
				int nx = x + jumpDx[i];
				int ny = y + jumpDy[i];
				
				if(isRange(nx, ny) && map[nx][ny] == 0) {
					if(dp[nx][ny][k-1] == -1) dfs(nx,ny,k-1);
					dp[x][y][k] = Math.min(dp[x][y][k], 1 + dp[nx][ny][k-1]);
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isRange(nx, ny) && map[nx][ny] == 0) {
				if(dp[nx][ny][k] == -1) dfs(nx,ny,k);
				dp[x][y][k] = Math.min(dp[x][y][k], 1 + dp[nx][ny][k]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * dp[x][y][k] : x,y에서 점프를 K번 할 수 있을 때 갈 수 있는 최소 동작수
		 */
		
		K = Integer.parseInt(br.readLine());
		
		tokens = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		
		dp = new int[H][W][K+1];
		map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				Arrays.fill(dp[i][j], -1);
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dfs(0,0,K);
		
		System.out.println(dp[0][0][K] == Integer.MAX_VALUE-1 ? -1 : dp[0][0][K]);
	}

}
