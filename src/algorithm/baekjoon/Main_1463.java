package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1463{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 1. X가 3으로 나누어 떨어지면 3으로 나눔
		 * 2. X가 2로 나누어 덜어지면 2로 나눔
		 * 3. 1을 뺌
		 * 
		 * N -> 1 만들 때 연산 최소 횟수
		 * 
		 * bfs
		 * 
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{N,0});
		
		boolean[] visited = new boolean[N];
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int num = info[0];
			int cnt = info[1];
			
			if(num == 1) {
				System.out.println(cnt);
				break;
			}
			
			if(num % 3 == 0) {
				int n = num / 3;
				if(!visited[n]) {
					visited[n] = true;
					q.add(new int[] {n, cnt+1});
				}
			}

			if(num % 2 == 0) {
				int n = num / 2;
				if(!visited[n]) {
					visited[n] = true;
					q.add(new int[] {n, cnt+1});
				}
			}

			if(!visited[num-1]) {
				q.add(new int[] {num-1, cnt+1});
			}
		}
		
	}

}
