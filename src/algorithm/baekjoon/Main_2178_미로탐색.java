package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	
	static class Coord{
		int x,y;
		int cnt;

		public Coord(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Coord [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append(", cnt=");
			builder.append(cnt);
			builder.append("]");
			return builder.toString();
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		int[][] map = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}			
		}

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		Queue<Coord> q = new ArrayDeque<>();
		q.add(new Coord(1,1,1));
		
		boolean[][] visited = new boolean[N+2][M+2];
		visited[1][1] = true;
		while(!q.isEmpty()) {
			Coord coord = q.poll();
			
			if(coord.x == N && coord.y == M) {
				System.out.println(coord.cnt);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = coord.x + dx[i];
				int ny = coord.y + dy[i];
				
				if(visited[nx][ny] || map[nx][ny] == 0) continue;
				
				visited[nx][ny] = true;
				q.add(new Coord(nx,ny,coord.cnt+1));
			}
		}
	}
}
