package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1208_부분수열의합2{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * -7 -3 -2 5 8
		 * 
		 * i번째 숫자를 포함했을 때 가능한지 체크 ? X
		 * 
		 * -12 ~ 13
		 * 
		 * 
		 * 
		 * 
		 */
		
		tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int S = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(br.readLine());

		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		
		
		
		
		
		
		
		
	}
}
