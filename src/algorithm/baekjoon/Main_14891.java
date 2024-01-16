package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_14891 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		int answer = 0;
		
		System.out.println(answer);
		
	}

}
