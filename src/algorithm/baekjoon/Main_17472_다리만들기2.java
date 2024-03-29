package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_17472_다리만들기2{
	
	static int N,M;
	static int[][] map;
	static int numIsland;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[] parent;
	
	static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	static void setIsland() {
		visited = new boolean[N][M];
		numIsland = 0;
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					numIsland++;
					visited[i][j] = true;
					q.add(new int[]{i,j});
					while(!q.isEmpty()) {
						int[] coord = q.poll();
						int x = coord[0];
						int y = coord[1];
						
						map[x][y] = numIsland;
						
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0) {
								visited[nx][ny] = true;
								q.add(new int[]{nx,ny});
							}
						}
					}
				}
			}
		}
	}
	
	static void install(boolean isHor, int[][] dist) {
		int st,ed;
		
		int h = isHor ? N : M;
		int w = isHor ? M : N;
		
		for (int i = 0; i < h; i++) {
			st = ed = 0;
			int stIdx = -1;
			boolean isInstall = false; // 다리 설치 중인지
			for (int j = 0; j < w; j++) {
				int num = isHor ? map[i][j] : map[j][i];
				if(num != 0) {
					// 섬인 경우
					ed = num;
					if(isInstall) {
						// 다리를 설치중이었다면?
						// 설치를 멈춤
						isInstall = false;
						// st번째 섬과 ed번째 섬 최소 길이 저장
						int d = j-stIdx;
						if(d >= 2)
							dist[st][ed] = dist[ed][st] = Math.min(dist[st][ed], d);
					}
				}else{
					// 바다인 경우
					if(!isInstall) {
						// 다리 설치중이 아니라면
						// 설치 시작
						isInstall = true;
						// 시작 섬 번호를 마지막에 설치했던 섬 번호로 저장
						st = ed;
						// 길이를 구하기 위한 시작 index 저장
						stIdx = j;
					}
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int a,b;
		int dist;

		public Edge(int a, int b, int dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}


		@Override
		public int compareTo(Edge o) {
			return dist-o.dist;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 모든 섬 다리 연결
		 * - 다리는 일직선, 길이 2 이상, 교차 가능
		 * 
		 * 1. 맵에 섬 숫자 표시하기
		 * 2. 섬간 최소 거리 저장
		 * 3. 크루스칼을 통해 최소 거리 구함
		 */
		
		tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		// 맵에 섬 숫자 표시하기
		setIsland();
		
		// 섬간 최소 거리 저장
		int[][] dist = new int[numIsland+1][numIsland+1];
		for (int i = 1; i <= numIsland; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
 
		// 가로 다리 놓기
		install(true, dist);
		// 세로 다리 놓기
		install(false, dist);
		
		// 크루스칼을 통해 최소 길이 구함
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		parent = new int[numIsland+1];
		for (int i = 1; i <= numIsland; i++) {
			parent[i] = i;
			for (int j = i+1; j <= numIsland; j++) {
				if(dist[i][j] != Integer.MAX_VALUE) {
					pq.add(new Edge(i,j,dist[i][j]));
				}
			}
		}
		
		int numComplete = 0;
		int totalDist = 0;
		while(!pq.isEmpty() && numComplete < numIsland-1) {
			Edge edge = pq.poll();
			
			int pa = find(edge.a);
			int pb = find(edge.b);
			
			if(pa == pb) continue;
			
			parent[pa] = pb;
			numComplete++;
			
			totalDist += edge.dist;
		}
		
		System.out.println(numComplete == numIsland-1 ? totalDist : -1);
		
	}
}
