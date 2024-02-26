package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens;

        /*
         * 0,0에서 시작
         * 오른쪽, 아래
         * N-1,N-1도달시 종료
         * 현재 밟고있는 칸 수만큼 이동 가능
         * 
         */
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        
        int[] dx = {0,1};
        int[] dy = {1,0};
        
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        while(!q.isEmpty()) {
        	int[] coord = q.poll();
        	int x = coord[0];
        	int y = coord[1];
        	
        	int num = map[x][y];
        	
        	for (int i = 0; i < 2; i++) {
				int nx = x + dx[i] * num;
				int ny = y + dy[i] * num;
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				if(map[nx][ny] == -1) {
					System.out.println("HaruHaru");
	        		return;
				}
				
				visited[nx][ny] = true;
				q.add(new int[]{nx,ny});
			}
        }

        System.out.println("Hing");

    }
}