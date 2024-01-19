package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_15684{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int H = Integer.parseInt(tokenizer.nextToken());

		int answer = 0;
		
		short[][] map = new short[H][N];
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokenizer.nextToken())-1;
			int b = Integer.parseInt(tokenizer.nextToken())-1;
			
			map[a][b] = 1;
			map[a][b+1] = -1;
		}
		
		/* 
		 * [1,-1, 0, 0, 0] [0, 1, 2, 3, 4]
		 * [0, 0, 1,-1, 0] [1, 0, 2, 3, 4]
		 * [0, 1,-1, 0, 0] [1, 0, 3, 2, 4]
		 * [0, 0, 0, 0, 0] [1, 3, 0, 2, 4]
		 * [1,-1, 0, 1,-1] [1, 3, 0, 2, 4]
		 * [0, 0, 0, 0, 0] [3, 1, 0, 4, 2]
		 * 				   [3, 1, 0, 4, 2]
		 * */
		

		short[][] numArr = new short[H+1][N];
	
		for (short i = 0; i < N; i++) {
			numArr[0][i] = i;
		}
		
		for (short i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				numArr[i+1][j] = numArr[i][j+map[i][j]];
			}
		}
		
		boolean isValid = true;
		for (int i = 0; i < N; i++) {
			if(numArr[H][i] != i) {
				isValid = false;
				break;
			}
		}
		
		for (short i = 0; i < H+1; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(numArr[i][j]+" ");
			}
			System.out.println();
		}
		
		if(!isValid) {
			List<short[]> list = new ArrayList<>();
			for (short i = 0; i < H; i++) {
				for (short j = 0; j < N-1; j++) {
					if(map[i][j] == 0 && map[i][j+1] == 0) {
						list.add(new short[]{i,j});
					}
				}
			}
			
			short[][] arr = list.toArray(new short[0][]);
			
			Queue<short[]> q
			
			while(!q.isEmpty()) {
				short[][] coords = q.poll();

				short[] idxToNum = new short[N];
				for (short i = 0; i < N; i++) {
					idxToNum[i] = i;
				}
				
				short[] result = numArr[H].clone();
				
				for (short[] coord : coords) {
					int x = coord[0];
					int y = coord[1];
					
					int a = numArr[x][y];
					int b = numArr[x][y+1];
					
					short temp = result[idxToNum[a]];
					result[idxToNum[a]] = result[idxToNum[b]];
					result[idxToNum[b]] = temp;
					
					temp = idxToNum[a];
					idxToNum[a] = idxToNum[b];
					idxToNum[b] = temp;
				}
				
				isValid = true;
				for (int i = 0; i < N; i++) {
					if(result[i] != i) {
						isValid = false;
						break;
					}
				}
				
				if(isValid) {
					answer = coords.length;
					break;
				} else if (coords.length != 3){
					
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
