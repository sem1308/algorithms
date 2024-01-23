package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Info{
	int[][] coords;
	int cnt;
	
	public Info(int[][] coords, int cnt) {
		this.coords = coords;
		this.cnt = cnt;
	}
}

public class Main_1035 {
	static int numPiece = 0;
	static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
	public static int[][] clone(int[][] arr) {
		int[][] copyArr = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			copyArr[i] = arr[i].clone();
		}
		return copyArr;
	}
	
	public static int dfs(int idx, boolean[] visited, int[][] coords) {
		visited[idx] = true;
		
		int result = 1;
		int x = coords[idx][0];
		int y = coords[idx][1];
		for (int i = 0; i < 4; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			
			for (int j = 0; j < numPiece; j++) {
				if(visited[j] || nx != coords[j][0] || ny != coords[j][1]) continue;
				result += dfs(j, visited, coords);
			}
		}
		
		return result;
	}
	
	public static boolean isPossible(int[][] coords) {
		boolean[] visited = new boolean[numPiece];
		if(dfs(0, visited, coords) == numPiece) return true;
		return false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int[][] coords = new int[5][2];
        int answer = 0;
        for (int i = 0; i < 5; i++) {
        	String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				if(str.charAt(j) == '*') {
					coords[numPiece++] = new int[]{i,j};
				}
			}
		}
        
        Queue<Info> q = new ArrayDeque<>();
   
        q.add(new Info(coords,0));
        
        while(!q.isEmpty()) {

        	Info info = q.poll();
        	
        	coords = info.coords;
        	int cnt = info.cnt;
			
        	if(isPossible(coords)) {
        		answer = cnt;
        		break;
        	}
        	
        	// A* 알고리즘
        	// 각 조각(*)에서 움직였을 때 최소 거리를 좁힐 수 있는 조각을 선정하여 움직임

        	int maxGap = 1;
        	List<int[]> temp = new ArrayList<>();
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
        			
        			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;

        			boolean isPiece = false;
        			for (int k = 0; k < numPiece; k++) {
        				if(nx == coords[k][0] && ny == coords[k][1]) {
        					isPiece = true;
        					break;
        				}
        			}
        			
        			if(isPiece) continue;
        			
            		int dist = 0;
					for (int k = 0; k < numPiece; k++) {
	    				if(i == k) continue;
	    				dist += Math.abs(nx - coords[k][0]) + Math.abs(ny - coords[k][1]); 
					}
					
					int gap = curDist - dist;
					
					if(maxGap <= gap) {
						if(maxGap < gap) temp.clear();
						maxGap = gap;
						temp.add(new int[]{i,nx,ny});
					}
				}
			}
        	
        	for (int i = 0; i < temp.size(); i++) {
        		int[][] copyCoords = clone(coords);
        		int[] ixy = temp.get(i);

        		copyCoords[ixy[0]][0] = ixy[1];
        		copyCoords[ixy[0]][1] = ixy[2];
        		
                q.add(new Info(copyCoords,cnt+1));
			}
        }
        
        System.out.println(answer);

    }
}