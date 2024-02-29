package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산_유효성_검사 {
	
	public static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = 10;

		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			char[] nodes = new char[N+1];
			int[][] childs = new int[N+1][2];
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(tokens.nextToken());
				char element = tokens.nextToken().charAt(0);

				nodes[idx] = element;
				
				int cnt = 0;
				while(tokens.hasMoreTokens()) {
					childs[idx][cnt++] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			/*
			 * 안되는 경우
			 * 1. 값이 숫자인데 자식노드가 있는 경우
			 * 2. 연산자인데 자식노드가 0개 또는 1개밖에 없는 경우
			 */
			
			Queue<Integer> q = new ArrayDeque<>();
			q.add(1);
			
			String answer = "1";
			while(!q.isEmpty()) {
				int idx = q.poll();
				if(isNumber(nodes[idx])) {
					if(childs[idx][0] != 0) {
						answer = "0";
						break;
					}
				}else {
					if(childs[idx][1] == 0 ) {
						answer = "0";
						break;
					}
					q.add(childs[idx][0]);
					q.add(childs[idx][1]);
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
}
