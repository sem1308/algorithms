package algorithm.baekjoon;
import java.util.*;
import java.io.*;

public class Main_15683_감시{
	
	static int[][] map;
	static int N, M;
	static int[][] moveDirs = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][][] camDirs;
	static int answer;
	static int numZeros;
	static int numSee;
	
	public static void dfs(int x, int y) {
		if(y == M) {
			x++;
			y = 0;
		}
		if(x == N) {
			answer = Math.min(answer, numZeros - numSee);
			return;
		}
		
		int num = map[x][y];
		if(num > 0 && num <= 5) {
			int[][] camDir = camDirs[num-1];
			for (int[] dirs : camDir) {
				List<int[]> visited = new ArrayList<>();
				// 설정
				for(int dir : dirs) {
					int nx = x + moveDirs[dir][0];
					int ny = y + moveDirs[dir][1];
					while(nx >= 0 && nx != N && ny >= 0 && ny != M && map[nx][ny] != 6) {
						if(map[nx][ny] == 0) {
							visited.add(new int[]{nx,ny});
							map[nx][ny] = -1;
						}
						nx += moveDirs[dir][0];
						ny += moveDirs[dir][1];
					}
				}
				
				numSee += visited.size();
				
				dfs(x,y+1);

				// 초기화
				for(int[] coord : visited) {
					map[coord[0]][coord[1]] = 0;
				}
				numSee -= visited.size();
			}
		}else{
			dfs(x,y+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		
		map = new int[N][M];
		
		numZeros = 0;
		numSee = 0;
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
				if(map[i][j] == 0) numZeros++;
			}
		}
		
		camDirs = new int[5][][]; // 카메라 번호 / 반복 횟수 / 방향 index (x,y)
		camDirs[0] = new int[][]{{0},{1},{2},{3}};
		camDirs[1] = new int[][]{{0,2},{1,3}};
		camDirs[2] = new int[][]{{0,1},{1,2},{2,3},{3,0}};
		camDirs[3] = new int[][]{{0,1,2},{1,2,3},{2,3,0},{3,0,1}};
		camDirs[4] = new int[][]{{0,1,2,3}};
		
		answer = numZeros;
		dfs(0,0);
		
		System.out.println(answer);
		
	}

}
