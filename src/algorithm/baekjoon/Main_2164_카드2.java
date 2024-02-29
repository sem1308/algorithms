package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164_카드2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		int num = 0;
		while(!q.isEmpty()) {
			num = q.poll();
			if(!q.isEmpty()) {
				num = q.poll();
				q.offer(num);
			}
		}
		
		System.out.println(num);
		
	}
}
