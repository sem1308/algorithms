package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1786_찾기{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t = br.readLine();
		String p = br.readLine();

		// 부분 문자열 테이블 생성
		int i = 1;
		int j = 0;
		
		int[] P = new int[p.length()];
		P[0] = 0;
		while(i < p.length()) {
			if(p.charAt(i) == p.charAt(j)) {
				// 문자열 매칭
				P[i++] = ++j;
			}else {
				// 문자열 매칭 X
				if(j == 0) {
					P[i++] = 0;	
				}else {
					j = P[j-1];
				}
			}
		}

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		// 문자열 패턴 검사
		i = j = 0;
		while(i < t.length()) {
			if(t.charAt(i) == p.charAt(j)) {
				// 문자열 매칭
				i++;
				j++;
				if(j == p.length()) {
					cnt++;
					sb.append(i-j+1).append(" ");
					j = P[j-1];
				}
			}else {
				// 문자열 매칭 X
				if(j == 0) {
					i++;
				}else {
					j = P[j-1];
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
		
	}
}
