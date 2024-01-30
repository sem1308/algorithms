package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {

	static int N, M;
	
	static int[] numbers;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(selected[i]) continue;
			numbers[cnt] = i;
			selected[i] = true;
			permutation(cnt+1);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		numbers = new int[M];
		selected = new boolean[N+1];
		
		permutation(0);
		
		System.out.println(sb.toString());
	}
}
