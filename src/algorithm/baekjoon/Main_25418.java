package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_25418{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{A,0});
		
		boolean[] visited = new boolean[K+1];
		while(!q.isEmpty()) {
			int[] info = q.poll();
			
			int num = info[0];
			int cnt = info[1];
			
			if(num == K) {
				System.out.println(cnt);
				return;
			}
			
			int num1 = num + 1;
			if(num1 <= K && !visited[num1]) {
				visited[num1] = true;
				q.add(new int[] {num1,cnt+1} );
			}

			int num2 = num * 2;
			if(num2 <= K && !visited[num2]) {
				visited[num2] = true;
				q.add(new int[] {num2,cnt+1} );
			}
		}
	}

}
