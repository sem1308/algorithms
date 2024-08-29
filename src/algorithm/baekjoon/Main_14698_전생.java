package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14698_전생 {

	static int N;
	static long totalEnergy;

	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 슬라임 에너지 : 2 이상 자연수
		 * 합성 : A,B => A * B
		 *
		 * N : 슬라임 수
		 *
		 * 1 <= N <= 60
		 *
		 * A*B 최소
		 *
		 * 총 N-1번 합성
		 *
		 * A,B,C,D,E ...
		 *
		 * A,B 합치면
		 */

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			tokens = new StringTokenizer(br.readLine());

			PriorityQueue<Long> pq = new PriorityQueue<>();

			for (int i = 0; i < N; i++) {
				pq.add(Long.parseLong(tokens.nextToken()));
			}

			totalEnergy = 1;

			while(pq.size() > 1){
				long a = pq.poll();
				long b = pq.poll();
				long amb = a*b;
				totalEnergy = (totalEnergy * (amb % MOD) % MOD);
				pq.add(amb);
			}

			sb.append(totalEnergy).append("\n");
		}

		System.out.println(sb);
	}
}
