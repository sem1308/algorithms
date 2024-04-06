package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_10775_공항{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * G개 게이트, 1~G 번호
		 * P개 비행기, 1~g 게이트에 도킹 가능
		 * 
		 * fill[i] = c : i-c+1 ~ i까지는 꽉 차있음 -> i-c부터 검사해라
		 */
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		int[] fill = new int[G+1];
		
		int i = 0;
		for (; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			
			int insertIdx = g;
			while(fill[insertIdx] != 0) {
				fill[insertIdx]++;
				insertIdx -= (fill[insertIdx]-1);
			}
			
			if(insertIdx == 0) break;
			fill[insertIdx] = 1;
		}
		
		System.out.println(i);
	}
}
