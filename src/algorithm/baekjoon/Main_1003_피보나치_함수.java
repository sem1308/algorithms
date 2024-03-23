package algorithm.baekjoon;

import java.io.*;

public class Main_1003_피보나치_함수{
	
	static class Count{
		int cnt0;
		int cnt1;

		public Count(int cnt0, int cnt1) {
			this.cnt0 = cnt0;
			this.cnt1 = cnt1;
		}
		
		public Count(Count a, Count b) {
			this.cnt0 = a.cnt0 + b.cnt0;
			this.cnt1 = a.cnt1 + b.cnt1;
		}
		
		public String toString() {
			return cnt0 + " " + cnt1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Count[] fibo = new Count[41];
		fibo[0] = new Count(1,0);
		fibo[1] = new Count(0,1);
		
		for (int i = 2; i <= 40; i++) {
			fibo[i] = new Count(fibo[i-1],fibo[i-2]);
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(fibo[num]);
		}
	}
}