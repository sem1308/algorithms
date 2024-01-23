package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        int s, N, K, R1, R2, C1, C2;
        
        s = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        R1 = Integer.parseInt(tokenizer.nextToken());
        R2 = Integer.parseInt(tokenizer.nextToken());
        C1 = Integer.parseInt(tokenizer.nextToken());
        C2 = Integer.parseInt(tokenizer.nextToken());
        
        /**
         * 1. R1,C1 ~ R2,C2까지 loop
         * 2. 현재 좌표가 x,y라면
         * 	  2.1) N^(s-1) ~ 1까지 나눠가며 해당 영역의 좌표를 구함
         *    2.2) x,y를 각각 N^(s-1)로 나눈 몫이 r,c일 때,
         *    2.3) (N-K)/2 <= r,c < (N+K)/2 이면 검은색(1)으로 break
         *    2.4) 그렇지 않으면 x -= r*N^(s-1), y -= c*N^(s-1)를 해주고 s--를 해준 후 다시 2.2로
         */
        
        int[] mods = new int[s];
        int smo = s-1;
        for (int i = smo; i >= 0; i--) {
        	mods[smo-i] = (int)Math.pow(N, i);
		}
        
        int from = (N-K)/2;
        int to = (N+K)/2;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = R1; i <= R2; i++) {
			for (int j = C1; j <= C2; j++) {
				int x = i; int y = j;
				boolean isBlack = false;
				for (int l = 0; l < mods.length; l++) {
					int r = x / mods[l];
					int c = y / mods[l];
					
					if(from <= r && r < to && from <= c && c < to) {
						isBlack = true;
						break;
					}
					
					x -= r * mods[l];
					y -= c * mods[l];
				}
				sb.append(isBlack ? "1" : "0");
			}
			sb.append("\n");
		}
        
        System.out.println(sb);
    }
}