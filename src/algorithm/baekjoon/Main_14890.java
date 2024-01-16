package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_14890 {
	
	public static int solve(int[][] map, int L, int i, boolean isRow) {
		boolean isInstalling = false;
		int cnt = 1;
		int prevHeight = isRow ? map[i][0] : map[0][i];

		for (int j = 1; j < map.length; j++) {
			int curHeight = isRow ? map[i][j] : map[j][i]; 
			if(curHeight == prevHeight) {
				// 이전 칸이 현재 칸과 같은 경우
				cnt++;
			}else if(curHeight == prevHeight+1) {
				// 현재 칸이 이전 칸보다 1 큰 경우 또는 경사로 설치중인 경우
				if((isInstalling && cnt < 2*L) || cnt < L) return 0;
				
				cnt = 1;
				prevHeight = curHeight;
				isInstalling = false;
			}else if(curHeight == prevHeight-1) {
				if(isInstalling && cnt < L) return 0;
				
				// 현재 칸이 이전 칸보다 1 작은 경우
				isInstalling = true;
				cnt = 1;
				prevHeight = curHeight;
			}else {
				return 0;
			}
		}
		if(isInstalling && cnt < L) return 0;
		
		return 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int L = Integer.parseInt(tokenizer.nextToken());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += solve(map,L,i,true);
			answer += solve(map,L,i,false);
		}
		
		System.out.println(answer);
		
	}

}
