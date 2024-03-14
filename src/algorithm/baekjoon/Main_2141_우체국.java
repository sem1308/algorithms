package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2141_우체국{
	
	static class Town implements Comparable<Town>{
		long X, A;

		public Town(long x, long a) {
			X = x;
			A = a;
		}

		@Override
		public int compareTo(Town o) {
			return (int) (this.X-o.X);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 수직선에 N개 마을 위치 <= 100,000
		 * 
		 * X[i] 마을에 A[i]명 살음
		 * 
		 * 각 사람들까지 거리 합 최소가 되는 위치에 우체국 설치 위치 구하기
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		Town[] towns = new Town[N];
		
		long total = 0;
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(tokens.nextToken());
			int A = Integer.parseInt(tokens.nextToken());
			
			towns[i] = new Town(X,A);
			total += A;
		}
		
		Arrays.sort(towns);

		long acc = 0;
		for (int i = 0; i < N; i++) {
			acc += towns[i].A;
			long diff = acc + acc - total; // acc - (total - acc);

			if(diff >= 0) {
				System.out.println(towns[i].X);
				return;
			}
		}
	}

}
