package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1943_동전_분배{
	
	static class Coin implements Comparable<Coin>{
		int num;
		int cnt;
		
		public Coin(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Coin o) {
			// TODO Auto-generated method stub
			return this.num - o.num;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());
			
			Coin[] coins = new Coin[N];
			
			int sum = 0;
			for (int j = 0; j < N; j++) {
				StringTokenizer tokens = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(tokens.nextToken());
				int cnt = Integer.parseInt(tokens.nextToken());	

				coins[j] = new Coin(num, cnt);
				
				sum += num * cnt;
			}
			
			if(sum % 2 == 1) {
				System.out.println(0);
				continue;
			}
			
			int halfSum = sum / 2;

			/* 
			 * 7 7 7
			 * 5 5 5
			 * 3 3
			 * 
			 * 두 사람이 S원을 가져야 한다면
			 * 
			 * i 동전의 개수가 C[i]일 때
			 * 
			 * 각각 0~C[i]만큼 가져갈 수 있음
			 * 
			 * i 동전에서 K만큼 가져갔다면
			 * 
			 * 21
			 * 
			 * 0
			 * 
			 * 0 7
			 * 
			 * 0 7 14
			 * 
			 * 0 7 14 21
			 * 
			 * 0 5 7 12 14 19 21 ---
			 * 
			 * 0 5 7 10 12 14 16 19 
			 * 
			 * 남은 동전의 합이 목표에 도달하지 못하면 불가능한 경우!
			 * 
			 */

			boolean[] checked = new boolean[halfSum+1];
			
			checked[0] = true;
			
			int lastNum = 0;
			
			int[] dp = new int[halfSum+1];
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp, 0);
				int num = coins[j].num;
				for (int k = 0; k < coins[j].cnt; k++) {
					
					
					
				}
			}
			
			if(checked[halfSum]) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}

	}
}
