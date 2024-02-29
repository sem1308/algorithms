package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의_배틀필드 {
	
	static int H,W;
	
	public static boolean isValid(int nx, int ny) {
		return nx >= 0 && nx < H && ny >= 0 && ny < W;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());

		StringTokenizer tokens;
		
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			
			char[][] map = new char[H][W];
					
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};

			int dir = 0;
			int x,y;
			x = y = 0;

			char[] dirConv = {'^','v','<','>'};
					
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					char c = str.charAt(j);
					if(c == '^' || c == 'v' || c == '<' || c == '>') {
						for (int k = 0; k < 4; k++) {
							if(c == dirConv[k]) {
								dir = k;
								x = i;
								y = j;
								break;
							}
						}
						c = '.';
					}
					map[i][j] = c;
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String ops = br.readLine();
			int nx, ny;
			for (char c : ops.toCharArray()) {
				boolean isMove = false;
				switch(c) {
					case 'U':
						dir = 0;
						isMove = true;
						break;
					case 'D':
						dir = 1;
						isMove = true;
						break;
					case 'L':
						dir = 2;
						isMove = true;
						break;
					case 'R':
						dir = 3;
						isMove = true;
						break;
					case 'S':
						nx = x + dx[dir];
						ny = y + dy[dir];
						while(isValid(nx,ny) && map[nx][ny] != '#') {
							if(map[nx][ny] == '*') {
								map[nx][ny] = '.';
								break;
							}
							nx += dx[dir];
							ny += dy[dir];
						}
						break;
				}
				
				nx = x + dx[dir];
				ny = y + dy[dir];
				if(isMove && isValid(nx,ny) && map[nx][ny] == '.') {
					x = nx;
					y = ny;
				}
			}
			
			map[x][y] = dirConv[dir];
			
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			
		}
		System.out.print(sb.toString());
	}
}
