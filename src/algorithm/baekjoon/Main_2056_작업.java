package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2056_작업{
	
	static int N;
	static int answer = 0;
	
	public static List<Integer> getWorks(int[] degree){
		List<Integer> works = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				works.add(i);
				degree[i] = -1;
			}
		}
		return works;
	}
			
	
	public static void work(int[] times, int[] maxTimes, int[] degree, List<Integer>[] childs) {
		List<Integer> works = getWorks(degree);
		if(works.isEmpty()) return;
		
		for(int from : works) {
			times[from] += maxTimes[from];
			answer = Math.max(times[from], answer);
			for(int to : childs[from]) {
				degree[to]--;
				maxTimes[to] = Math.max(maxTimes[to],times[from]);
			}
		}

		work(times, maxTimes, degree, childs);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 작업마다 걸리는 시간 주어짐
		 */
		
		N = Integer.parseInt(br.readLine());
		
		int[] degree = new int[N+1];
		int[] times = new int[N+1];
		int[] maxTimes = new int[N+1];
		List<Integer>[] childs = new List[N+1];

		for (int i = 1; i <= N; i++) {
			childs[i] = new ArrayList<>();
			
			tokens = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(tokens.nextToken());
			
			int M = Integer.parseInt(tokens.nextToken());
			degree[i] += M;
			for (int j = 0; j < M; j++) {
				int from = Integer.parseInt(tokens.nextToken());
				childs[from].add(i);
			}
		}
		
		work(times, maxTimes, degree, childs);

		System.out.println(answer);
	}

}
