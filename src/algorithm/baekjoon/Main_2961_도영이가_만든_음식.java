package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가_만든_음식 {
	
	static int N;
	
	static int[] sArr, bArr;
	
	static int minFavor = Integer.MAX_VALUE;

	public static void subset(int cnt, int mulS, int sumB) {
		if(cnt == N) {
			if(sumB != 0)
				minFavor = Math.min(minFavor, Math.abs(mulS-sumB));
			return;
		}
		
		subset(cnt+1, mulS * sArr[cnt], sumB + bArr[cnt]);
		subset(cnt+1, mulS, sumB);		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		sArr = new int[N];
		bArr = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			sArr[i] = Integer.parseInt(tokens.nextToken());
			bArr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		subset(0,1,0);
		
		System.out.println(minFavor);
	}
}
