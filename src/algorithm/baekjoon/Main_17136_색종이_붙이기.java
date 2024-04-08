package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_17136_색종이_붙이기{
	
	static int[][] paper = new int[10][10];
	
	static int[] numPaper = {0,5,5,5,5,5};
	static boolean[] checked = new boolean[7777];
	
	static int numOnes;
	static int ans = Integer.MAX_VALUE;

	public static int attach(int sx, int sy, int ex, int ey) {
		int numAttached = 0;
		for (int r = sx; r < ex; r++) {
			for (int c = sy; c < ey; c++) {
				if(paper[r][c] == 0) {
					// 붙히다가 이미 붙혀진 색종이가 있다면
					return numAttached;
				}
				paper[r][c] = 0;
				numAttached++;
			}
		}
		
		return numAttached;
	}
	
	public static void detach(int sx, int sy, int ex, int ey, int numAttached){
		for (int r = sx; r < ex; r++) {
			for (int c = sy; c < ey; c++) {
				if(numAttached == 0) return;
				paper[r][c] = 1;
				numAttached--;
			}
		}
	}
	
	public static void fill(int cnt, int totalNumFilled) {
		if(cnt >= ans) {
			return;
		}
		
		if(totalNumFilled == numOnes) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		for (int size = 5; size >= 1; size--) {
			if(numPaper[size] == 0) continue;

			int ex = 10-size;
			int ey = 10-size;
			
			int powSize = size*size;
			
			for (int i = 0; i <= ex; i++) {
				for (int j = 0; j <= ey; j++) {
					int numAttached = attach(i,j,i+size,j+size);
					if(numAttached == powSize) {
						numPaper[size]--;
						fill(cnt+1,totalNumFilled+powSize);
						numPaper[size]++;
					}
					// 다시 떼어내기
					detach(i, j, i+size, j+size, numAttached);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 색종이 총 25장
		 * 
		 * 종이 총 100칸
		 * 
		 * 각 칸을 꼭짓점으로 했을때 -> 4가지 경우
		 * 
		 * 25 * 100 * 4 = 10000 (OK)
		 */
		
		for (int i = 0; i < 10; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(tokens.nextToken());
				numOnes += paper[i][j];
			}
		}
		
		fill(0,0);
		
		System.out.println(ans == Integer.MAX_VALUE ? "-1" : ans);
	}
}
