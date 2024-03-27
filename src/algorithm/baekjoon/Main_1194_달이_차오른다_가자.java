package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1194_달이_차오른다_가자{	
	
	static int N,M;
	
	static class Player{
		int x,y;
		int cnt;
		int keyBit;
		
		public Player(int x, int y, int keyBit, int cnt) {
			this.x = x;
			this.y = y;
			this.keyBit = keyBit;
			this.cnt = cnt;
		}
	}
	
	public static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	public static boolean isKey(char c) {
		return c >= 'a' && c <= 'f';
	}
	
	public static boolean isWall(char c) {
		return c >= 'A' && c <= 'F';
	}
	
	public static boolean hasKey(int keyBit, char c){
		int checkBit = (1 << (c-'A'));
		return (keyBit & checkBit) == checkBit;
	}
	
	public static int addKey(int keyBit, char c) {
		int addBit = (1 << (c-'a'));
		return keyBit | addBit;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * . : 빈칸
		 * # : 벽
		 * a~f : 열쇠
		 * A~F : 열쇠로 열 수 있는 문
		 * 0 : 현재 위치
		 * 1 : 출구
		 * 
		 * 이동 횟수 최솟값
		 */
		
		tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][][] visited = new boolean[N][M][128]; //x,y에서 어떤 열쇠를 가지고 있는지 bit masking
		
		Queue<Player> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					map[i][j] = '.';
					visited[i][j][0] = true;
					q.add(new Player(i, j, 0, 0));
				}
			}
		}
		
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		int answer = -1;
		while(!q.isEmpty()) {
			Player p = q.poll();
			
			if(map[p.x][p.y] == '1') {
				answer = p.cnt;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int keyBit = p.keyBit;
				int ncnt = p.cnt+1;
				
				if(!isRange(nx,ny)) continue;
				
				char c = map[nx][ny];
				
				if(c == '#' || (isWall(c) && !hasKey(keyBit,c)) || visited[nx][ny][keyBit]) continue;

				visited[nx][ny][keyBit] = true;
				
				if(isKey(c)) {
					keyBit = addKey(p.keyBit,c);
				}
				
				q.add(new Player(nx, ny, keyBit, ncnt));
			}
		}
		
		System.out.println(answer);
		
	}
}
