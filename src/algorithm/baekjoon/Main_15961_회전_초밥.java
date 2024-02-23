package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_15961_회전_초밥{
	
	static int N, d, k ,c;
	static int answer = 0;

	public static void permutation(int idx) {
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 1. k개 연속 섭취 -> 할인
		 * 2. 1을 할 경우 c번 초밥 하나 무료 제공
		 * 
		 * 가능한 다양한 종류 초밥 먹으려함
		 * 
		 */
		
		tokens = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tokens.nextToken());
		d = Integer.parseInt(tokens.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(tokens.nextToken()); // k개 연속
		c = Integer.parseInt(tokens.nextToken()); // c번 쿠폰
		
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int[] numSushi = new int[d+1];
		int numTypes = 0;
		
		for (int i = 0; i < k; i++) {
			if(numSushi[nums[i]] == 0) {
				numTypes++;
			}
			numSushi[nums[i]]++;
		}
		
		answer = numTypes + (numSushi[c] == 0 ? 1 : 0);
		
		for (int i = 0; i < N-1; i++) {
			if(--numSushi[nums[i]] == 0) numTypes--;
			int j = (i+k) % N;
			if(numSushi[nums[j]]++ == 0) numTypes++;
			answer = Math.max(answer, numTypes + (numSushi[c] == 0 ? 1 : 0));
		}
		
		System.out.println(answer);
	}

}
