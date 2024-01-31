package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1207{
	
	static int L;
	static String[][] pieces;
	static boolean[] selected;
	static boolean[][] visited;
	
	public static void solve(int x, int y, int cnt) {
		if(cnt == 5) {
			
			return;
		}
		
		for (int i = 0; i < 5; i++) {
			if(selected[i]) continue;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		L = Integer.parseInt(br.readLine());

		pieces = new String[5][];
		for (int i = 0; i < 5; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			pieces[i] = new String[r];
			for (int j = 0; j < r; j++) {
				pieces[i][j] = br.readLine();
			}
		}
		
		selected = new boolean[5];
		visited = new boolean[L][L];

		
		
		
	}

}
