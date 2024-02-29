package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2564_색종이 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens;

		int answer = 0;
		
		boolean[][] map = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(map[j][k]) continue;
					map[j][k] = true;
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
