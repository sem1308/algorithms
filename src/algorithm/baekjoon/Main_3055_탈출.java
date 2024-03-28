package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_3055_탈출{

	public static class Coord{
		int x,y;
		boolean isPlayer;
		int cnt;
		
		public Coord(int x, int y, int cnt, boolean isPlayer) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.isPlayer = isPlayer;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * R행 C열
		 * 
		 * . : 비어있음
		 * * : 물 차있음
		 * X : 돌
		 * D : 비버 굴
		 * S : 고슴도치 위치
		 */
		
		tokens = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(tokens.nextToken());
		int C = Integer.parseInt(tokens.nextToken());

		char[][] map = new char[R][C];
		
		int sx, sy;
		sx = sy = 0;

		Queue<Coord> q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				if(c == 'S') {
					sx = i;
					sy = j;
				}else if(c == '*') {
					q.add(new Coord(i, j, 0, false));
				}else if(c == 'X') {
					c = '*';
				}
				map[i][j] = c;
			}
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		q.add(new Coord(sx, sy, 0, true));
		
		while(!q.isEmpty()) {
			Coord coord = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = coord.x + dx[i];
				int ny = coord.y + dy[i];
				
				if(nx < 0 || nx == R || ny < 0 || ny == C || map[nx][ny] == '*' || map[nx][ny] == 'S') continue;
				
				if(!coord.isPlayer) {
					if(map[nx][ny] == 'D') continue;
					map[nx][ny] = '*';
				}else{
					if(map[nx][ny] == 'D') {
						System.out.println(coord.cnt+1);
						return;
					}
					map[nx][ny] = 'S';
				}
				
				q.add(new Coord(nx,ny,coord.cnt+1,coord.isPlayer));
			}
		}
		
		System.out.println("KAKTUS");
	}
}
