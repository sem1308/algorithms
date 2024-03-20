package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927_최소힙{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int op = Integer.parseInt(br.readLine());
			if(op == 0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.offer(op);
			}
		}
		System.out.println(sb);
	}

}
