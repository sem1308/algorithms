package algorithm.baekjoon;

import java.io.*;

public class Main_2747_피보나치수{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] fibo = new long[N+1];
		
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println(fibo[N]);
		
	}
}
