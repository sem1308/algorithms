package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치_켜고_끄기 {

	static char[] state;
	
	public static void switchBulb(int n) {
		state[n] = state[n] == '0' ? '1' : '0';
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		state = new char[N+1];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			state[i] = tokens.nextToken().charAt(0);
		}

		int S = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < S; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int g = Integer.parseInt(tokens.nextToken());
			int num = Integer.parseInt(tokens.nextToken());

			switchBulb(num);
			if(g == 1) {
				for(int n=num+num; n<=N; n+=num) {
					switchBulb(n);
				}
			}else {
				int left = num-1;
				int right = num+1;
				while(left > 0 && right <= N && state[left] == state[right]) {
					switchBulb(left--);
					switchBulb(right++);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int gap = 0;
		for (int i = 1; i < state.length; i++) {
			sb.append(state[i]);
			if(++gap == 20) {
				gap = 0;
				sb.append("\n");
			}else sb.append(" ");
		}
		System.out.print(sb.toString());
		
	}
}
