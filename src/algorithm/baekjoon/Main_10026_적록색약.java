package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10026_적록색약{
	
	public static class Coord{
		int x,y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 적록색약 X
		int result1 = 0;
		
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				result1++;
				bfs(i, j, false, N, map, visited);
			}
		}
		
		// 적록색약 O (R = G)
		int result2 = 0;
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				result2++;
				bfs(i, j, true, N, map, visited);
			}
		}
		
		System.out.println(result1+" "+result2);
	}
	
	public static boolean isBound(int x, int y, int N) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
	
	public static void bfs(int x, int y, boolean isColorBlind, int N, char[][] map, boolean[][] visited) {			
		
		Queue<Coord> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.add(new Coord(x,y));
		
		char color = map[x][y];
		
		while(!q.isEmpty()) {
			Coord coord = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = coord.x + dx[i];
				int ny = coord.y + dy[i];
				
				if(isBound(nx,ny,N) || visited[nx][ny]) continue;
				
				if(!isColorBlind || color == 'B') {
					if(map[nx][ny] != color) continue;
				}else if(map[nx][ny] == 'B') continue;
				
				visited[nx][ny] = true;
				q.add(new Coord(nx,ny));				
			}
		}
	}
}
