package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_17070_파이프_옮기기{
	static int N;
	// x,y에서 dir방향으로 갔을 때 N,N으로 도달하는 
	static int[][][] dp; // 파이프의 끝 x,y,방향 (0 : 오른쪽, 1 : 대각, 2 : 아래)
	static int[][] map;
	
	static int[] dx = {0,1,1}; // 오른쪽, 대각, 아래
	static int[] dy = {1,1,0};
	
	/*
	 * 오른쪽 : 오른쪽, 대각선
	 * 대각선 : 오른쪽, 대각선, 아래
	 * 아래  : 대각선, 아래 
	 */
	static int[][] toDir = {
				{0,1},
				{0,1,2},
				{1,2},
			}; 
		
	public static int dfs(int x, int y, int dir) {
		dp[x][y][dir] = 0;
		
		if(map[x][y] != 1 && (dir != 1 || (map[x-1][y] != 1 && map[x][y-1] != 1))) {
			if(x == N && y == N) {
				dp[x][y][dir] = 1;
			}else {
				for (int td : toDir[dir]) {
					int nx = x + dx[td];
					int ny = y + dy[td];
					
					dp[x][y][dir] += dp[nx][ny][td] == -1 ? dfs(nx,ny,td) : dp[nx][ny][td];
				}
			}
		}
		
		return dp[x][y][dir];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens;
		
		dp = new int[N+2][N+2][3];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = -1;
			}
		}
		
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		System.out.println(dfs(1,2,0));
	}

}
