package algorithm.baekjoon;

import java.io.*;

public class Main_2631_줄세우기{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 1~N번 아이
		 * 
		 * 2 <= N <= 200
		 * 
		 * 목적지까지 번호순서대로
		 * 
		 * 이동 도중 번호순서가 바뀜
		 * 
		 * 옮기는 아이들 수 최소
		 * 
		 * 
		 * 
		 * 
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		
		
	}
}
