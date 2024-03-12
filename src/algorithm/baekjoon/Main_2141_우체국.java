package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2141_우체국{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 수직선에 N개 마을 위치 <= 100,000
		 * 
		 * X[i] 마을에 A[i]명 살음
		 * 
		 * 각 사람들까지 거리 합 최소가 되는 위치에 우체국 설치
		 * 
		 * 위치 구하기
		 * 
		 * 우체국 위치가 P라 하면
		 * 
		 * 거리 합 = abs(P - X[i])*A[i]
		 * 
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		int[] X = new int[N];
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(tokens.nextToken());
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		
		
	
		
	}

}
