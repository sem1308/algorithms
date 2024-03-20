package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1931_회의실_배정{
	
	static class Work implements Comparable<Work>{
		int startTime;
		int endTime;
		public Work(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Work o) {
			if(this.endTime==o.endTime) {
				return this.startTime-o.startTime;
			}
			return this.endTime-o.endTime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Work> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(tokens.nextToken());
			int endTime = Integer.parseInt(tokens.nextToken());
			
			pq.add(new Work(startTime, endTime));
		}
		
		int edTime = 0;
		int answer = 0;
		while(!pq.isEmpty()) {
			Work work = pq.poll();
			if(edTime <= work.startTime) {
				edTime = work.endTime;
				answer++;
			}
		}
		System.out.println(answer);
	}
}