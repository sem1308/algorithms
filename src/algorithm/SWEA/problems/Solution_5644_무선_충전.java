package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_5644_무선_충전 {
	
	public static int[] dx = {0,-1,0,1,0};
	public static int[] dy = {0,0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		List<Integer>[][] map = new ArrayList[11][11];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(tokens.nextToken());
			int A = Integer.parseInt(tokens.nextToken());

			int[] dirA = new int[M];
			int[] dirB = new int[M];

			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				dirA[i] = Integer.parseInt(tokens.nextToken());
			}
			
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				dirB[i] = Integer.parseInt(tokens.nextToken());
			}
			
			int[] AP = new int[A]; // 파워 저장
			
			for (int i = 0; i < A; i++) {
				tokens = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(tokens.nextToken());
				int x = Integer.parseInt(tokens.nextToken());
				int c = Integer.parseInt(tokens.nextToken()); // 범위
				int p = Integer.parseInt(tokens.nextToken()); // 파워
				
				AP[i] = p;
				q.add(new int[] {x,y,0});
				boolean[][] visited = new boolean[11][11];
				visited[x][y] = true;
				while(!q.isEmpty()) {
					int[] xy = q.poll();
					x = xy[0];
					y = xy[1];
					int cnt = xy[2];
					
					map[x][y].add(i);

					if(cnt == c) {
						continue;
					}
					
					for (int k = 1; k <= 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						
						if(nx < 1 || nx == 11 || ny < 1 || ny == 11 || visited[nx][ny]) continue;
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny,cnt+1});
					}
				}
				
			}
			
			int answer = 0;
			
			int ax, ay, bx, by;
			ax = ay = 1;
			bx = by = 10;
			
			for (int i = 0; i <= M; i++) {
				List<Integer> apA = map[ax][ay];
				List<Integer> apB = map[bx][by];

				int maxVal = 0;
				if(!apA.isEmpty() && !apB.isEmpty()) {
					for(int a : apA) {
						for(int b : apB) {
							if(a == b) {
								maxVal = Math.max(maxVal, AP[a]);
							}else {
								maxVal = Math.max(maxVal, AP[a]+AP[b]);
							}
						}
					}
				}else if (!apA.isEmpty()){
					for(int a : apA) {
						maxVal = Math.max(maxVal, AP[a]);
					}
				}else if (!apB.isEmpty()){
					for(int b : apB) {
						maxVal = Math.max(maxVal, AP[b]);
					}
				}
				answer += maxVal;

				if(i == M) break;
				
				ax += dx[dirA[i]];
				ay += dy[dirA[i]];

				bx += dx[dirB[i]];
				by += dy[dirB[i]];
			}

			
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					map[i][j].clear();
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
