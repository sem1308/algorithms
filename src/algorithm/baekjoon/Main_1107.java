package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1107{

	static boolean[] brokenBtns;
	static int N,M;
	static int len;
	
	static int answer;
	
	static int[] coefs;
	
	public static void permute(int number, int cnt) {
		if(cnt > 0) answer = Math.min(answer, cnt + Math.abs(N - number));
		
		if(cnt == len+1) return;
		
		for (int i = 0; i < 10; i++) {
			if(brokenBtns[i]) continue;
			permute(number+coefs[cnt] * i, cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strN = br.readLine();
		N = Integer.parseInt(strN);
		
		len = strN.length();
		
		M = Integer.parseInt(br.readLine());

		brokenBtns = new boolean[10];
		if(M != 0) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				brokenBtns[Integer.parseInt(tokenizer.nextToken())] = true;
			}
		}
		
		/*
		 * +, - 버튼
		 * 고장나지 않은 버튼
		 * 
		 * 1) 고장나지 않은 버튼으로 최대한 가까운 채널로 이동
		 * 2) 차이가 나는 만큼 + 또는 - 버튼으로 이동
		 * 
		 */
		
		coefs = new int[len+1];
		for (int i = 0; i <= len; i++) {
			coefs[i] = (int)Math.pow(10, i);
		}
		
		answer = Math.abs(N - 100);
		permute(0,0);
		
		System.out.println(answer);
	}

}
