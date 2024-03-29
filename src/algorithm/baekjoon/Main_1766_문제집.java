package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1766_문제집{
	
	static int N, M;
	static int[] degrees;
	static List<Integer> problems;
	static List<Integer>[] nextProblems;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		nextProblems = new ArrayList[N+1];
		degrees = new int[N+1];
		
		problems = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			nextProblems[i] = new ArrayList<>();
			problems.add(i);
		}
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			degrees[B]++;
			nextProblems[A].add(B);
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> doProbs = new ArrayDeque<>();
		while(true) {
			for(int i = 1; i<=N; i++) {
				if(degrees[i] == 0) {
					degrees[i] = -1;
					sb.append(i).append(" ");
					doProbs.add(i);					
				}
			}
			
			if(doProbs.isEmpty()) break;
			
			while(!doProbs.isEmpty()) {
				int problem = doProbs.poll();
				for (int p : nextProblems[problem]) {
					degrees[p]--;
				}
			}
		}
		
		System.out.println(sb);
	}
}
