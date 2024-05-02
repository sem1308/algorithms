package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1484_다이어트{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 현재 몸무게 제곱 - 과거 몸무게 제곱
		 * 
		 * b^2 - a^2
		 * 
		 * (b+a)(b-a) = G
		 * 
		 * 1. G의 약수 찾기
		 * 2. G의 약수가 b+a, b-a로 표현 가능한지 찾기
		 * 
		 * G = x*y
		 * 
		 * x = b+a
		 * y = b-a
		 * 
		 * 2*b = x+y
		 * 
		 * b = (x+y) / 2
		 * a = (x-y) / 2
		 * 
		 * b와 a가 모두 자연수인 경우 가능
		 * 
		 * 16 - 0
		 * 
		 */
		
		int G = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int y = (int)Math.sqrt(G); y >= 1; y--) {
			if(G % y != 0) continue;
			
			int x = G / y;
			
			int xpy = x+y;
			int xmy = x-y;
			
			if(xpy % 2 == 0 && xmy % 2 == 0 && xmy != 0) {
				sb.append(xpy / 2).append("\n");
			}
		}
		
		System.out.println(sb.length() == 0 ? "-1" : sb);
	}
}
