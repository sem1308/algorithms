package algorithm.baekjoon;

import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_1035 {
	
	static char[][] map = new char[5][5];
	static int[][] coords = new int[5][2];
	static int numPiece = 0;
	static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
	public static int dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		int result = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			
			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] || map[nx][ny] != '*') continue;
			result += dfs(nx, ny, visited);
		}
		
		return result;
	}
	
	public static boolean isPossible() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == '*') {
					boolean[][] visited = new boolean[5][5];
					if(dfs(i,j, visited) == numPiece) return true;
					break;
				}
			}
		}
		
		return false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for (int i = 0; i < 5; i++) {
        	String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					coords[numPiece++] = new int[]{i,j};
				}
			}
		}

        while(!isPossible()) {
        	
        	// A* 알고리즘
        	// 각 조각(*)에서 움직였을 때 거리를 좁힐 수 있는 조각을 선정하여 움직임
        	
        	int spIdx = 0;
        	int spX=0, spY=0;
        	int maxGap = 0;
        	for (int i = 0; i < numPiece; i++) {
        		int x = coords[i][0];
        		int y = coords[i][1];

            	int curDist = 0;
				for (int k = 0; k < numPiece; k++) {
    				if(i == k) continue;
    				curDist += Math.abs(x - coords[k][0]) + Math.abs(y - coords[k][1]); 
				}
            	
        		for (int j = 0; j < 4; j++) {
        			int nx = x + dirs[j][0];
        			int ny = y + dirs[j][1];
        			
        			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || map[nx][ny] == '*') continue;

            		int dist = 0;
					for (int k = 0; k < numPiece; k++) {
	    				if(i == k) continue;
	    				dist += Math.abs(nx - coords[k][0]) + Math.abs(ny - coords[k][1]); 
					}
					
					int gap = curDist - dist;
					
					if(maxGap <= gap) {
						spIdx = i;
						maxGap = gap;
						spX = nx;
						spY = ny;
					}
				}
			}
        	
        	map[spX][spY] = '*';
        	map[coords[spIdx][0]][coords[spIdx][1]] = '.';
        	coords[spIdx][0] = spX;
        	coords[spIdx][1] = spY;

        	answer++;
        }
        
        System.out.println(answer);

    }
}