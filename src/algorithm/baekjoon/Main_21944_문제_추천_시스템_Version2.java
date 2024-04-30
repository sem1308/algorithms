package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_21944_문제_추천_시스템_Version2{
	
	static class Problem{
		int p, g, l;
		boolean isSolved;

		public Problem(int p, int g, int l) {
			this.p = p;
			this.g = g;
			this.l = l;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 문제 번호 P, 난이도 L, 알고리즘 분류 G
		 * 
		 * recommend G x
		 * + x == 1
		 * 	- G 분류 중 가장 어려운 문제 번호 출력
		 * 	- 여러개 -> 문제 번호 큰 것
		 * + x == -1
		 * 	- G 분류 중 가장 쉬운 문제 번호 출력
		 * 	- 여러개 -> 문제 번호 작은 것
		 * 
		 * recommend2 x
		 * + x == 1
		 * 	- 가장 어려운 문제 번호 출력
		 * 	- 여러개 -> 문제 번호 큰 것
		 * + x == -1
		 * 	- 가장 쉬운 문제 번호 출력
		 * 	- 여러개 -> 문제 번호 작은 것
		 * 
		 * recommend3 x L
		 * + x == 1
		 * 	- 난이도 L보다 크거나 같은 가장 쉬운 문제 번호 출력
		 * 	- 여러개 -> 문제 번호 작은 것
		 *  - 없음 -> -1
		 * + x == -1
		 * 	- 난이도 L보다 작은 가장 어려운 문제 번호 출력
		 * 	- 여러개 -> 문제 번호 큰 것
		 *  - 없음 -> -1
		 *  
		 * add P L G
		 * - 난이도 L, 분류 G인 번호 P 추가
		 * 
		 * solved P
		 * - P 제거
		 * 
		 * === 로직 ===
		 * 1. 알고리즘 분류와 난이도 별 pq 2개 생성
		 *    - 문제 번호 큰 순, 작은 순 정렬
		 * 2. 문제를 배열로 저장 - 문제 pool 만듦
		 * # recommend
		 * 	  - 알고리즘 별 
		 * # recommend2
		 * # recommend3
		 * # add
		 *    - 만약 문제 배열에 문제 번호에 해당하는 문제 객체가 생성되었다면 문제 생성
		 *    - 그렇지 않으면 그 문제의 난이도와 분류를 변경
		 *       - 
		 * # solved
		 *    - 문제가 풀렸는지 안풀렸는지 체크하는 변수를 false로 변경
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(tokens.nextToken());
			int l = Integer.parseInt(tokens.nextToken());
			int g = Integer.parseInt(tokens.nextToken()); 
		}
		
		
		
	}
}
