package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2239_스도쿠{
	static int N = 9;
	static int[][] map = new int[N][N];
	static boolean[][] filledRows = new boolean[10][10];
	static boolean[][] filledCols = new boolean[10][10];
	static boolean[][] filledBlocks = new boolean[10][10];
	
	static boolean isComplete = false;
	static StringBuilder sb = new StringBuilder();
	
	public static void backtrack(int idx) {
		if(isComplete) return;
		if(idx == 81) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			isComplete = true;
			return;
		}
		
		int r = idx / 9;
		int c = idx - 9*r;
		
		int br = r/3;
		int bc = c/3;
		int bIdx = br*3+bc;
		
		if(map[r][c] != 0) {
			backtrack(idx+1);
		}else {
			for (int i = 1; i <= N; i++) {
				if(filledRows[r][i] ||
					filledCols[c][i] ||
					filledBlocks[bIdx][i]) continue;
				filledRows[r][i] = filledCols[c][i] = filledBlocks[bIdx][i] = true;
				map[r][c] = i;
				backtrack(idx+1);
				map[r][c] = 0;
				filledRows[r][i] = filledCols[c][i] = filledBlocks[bIdx][i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 9개 행
		 * 9개 열
		 * 9개 블럭
		 * 
		 * 0,0, 0,1, 
		 * 
		 * i/3
		 */
		for (int i = 0; i < N; i++) {
			String number = br.readLine();
			int r = (i/3)*3;
			for (int j = 0; j < N; j++) {
				map[i][j] = number.charAt(j)-'0';
				filledRows[i][map[i][j]] = true;
				filledCols[j][map[i][j]] = true;
				int c = j / 3;
				filledBlocks[r+c][map[i][j]] = true;
			}
		}
		
		backtrack(0);
		
		System.out.println(sb);
	}
}
