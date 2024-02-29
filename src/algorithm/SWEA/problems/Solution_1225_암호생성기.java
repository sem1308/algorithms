package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = 10;

		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new ArrayDeque<>();
		for (int t = 1; t <= T; t++) {
			int test_case = Integer.parseInt(br.readLine());
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(tokens.nextToken()));
			}
			
			boolean flag = false;
			while(!flag) {
				for (int i = 1; i <= 5; i++) {
					int num = q.poll();
					num = Math.max(0, num-i);
					q.offer(num);
					
					if(num == 0) {
						flag = true;
						break;
					}
				}
			}
			
			sb.append("#").append(test_case);
			
			while(!q.isEmpty()) 
				sb.append(" ").append(q.poll());			
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
