package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3197 {
	
	static int R,C;
	static char[][] map;
	
	static int[][] people; // 사람들의 좌표
	
	static int answer;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Info{
		int pIdx;
		int x,y;
		
		public Info(int pIdx, int x, int y) {
			this.pIdx = pIdx;
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return pIdx + " : " + x + "," + y + "\n";
		}
	}
	
	public static boolean isBound(int x, int y) {
		return x < 0 || x >= R || y < 0 || y >= C;
	}

	public static void melt(int x, int y, boolean[][] visited) {
		
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isBound(nx, ny) && !visited[nx][ny]) {
				if(map[nx][ny] != 'X') {
					// 녹이기
					map[x][y] = '.';
				}else {
					// 다음으로
					melt(nx,ny,visited);
				}
			}
		}
	}
	
	public static void simulation() {
		
		Queue<Info> q = new ArrayDeque<>();
		int[][] visited = new int[R][C];
		boolean[][] visited2 = new boolean[R][C];

		while(true) {
//			System.out.println("["+answer+"일차]");
//			
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			// 1. 각 사람이 있는 곳에서 bfs를 통해 map에서 각 사람이 갈 수 있는 경우의 수 체크		
			q.add(new Info(1, people[0][0], people[0][1]));
			q.add(new Info(2, people[1][0], people[1][1]));			
			
			visited[people[0][0]][people[0][1]] = 1;
			visited[people[1][0]][people[1][1]] = 2;
			
			while(!q.isEmpty()) {
				Info coord = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = coord.x + dx[i];
					int ny = coord.y + dy[i];
					
					if(isBound(nx,ny) || map[nx][ny] == 'X' || visited[nx][ny] == coord.pIdx) continue;
					
					// 2. 만날 수 있으면 break;
					if(visited[nx][ny] == (3-coord.pIdx)) return;
					
					visited[nx][ny] = coord.pIdx;
					q.add(new Info(coord.pIdx, nx, ny));
				}
			}
			
			//3. 만날 수 없다면 하루가 지나 빙하를 녹임
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 'X' && !visited2[i][j]) {
						melt(i,j,visited2);
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				Arrays.fill(visited2[i], false);
				Arrays.fill(visited[i], 0);
			}
			
			answer++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * 일반 땅과 접촉한 모든 빙하 공간이 녹음
		 * - 가로, 세로로 접촉
		 * 
		 * 두 사람이 만나기 위한 일 수 구하기
		 * 
		 * 1. 각 사람이 있는 곳에서 bfs를 통해 map에서 각 사람이 갈 수 있는 경우의 수 체크
		 * 2. 만날 수 있으면 break;
		 * 3. 만날 수 없다면 하루가 지나 빙하를 녹임
		 *    - 빙하는 X를 만나면 dfs를 통해 지워지는 좌표들을 .으로 변환
		 * 4. 다시 1번으로
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		/*
		 * . : 일반 땅
		 * X : 빙하
		 * L : 사람이 있는 공간
		 */
		map = new char[R][C];
		
		int pIdx = 0;
		people = new int[2][2];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'L') {
					people[pIdx][0] = i;
					people[pIdx][1] = j;
					pIdx++;
				}
			}
		}
		
		answer = 0;
		simulation();
		
		System.out.println(answer);
	}
}
