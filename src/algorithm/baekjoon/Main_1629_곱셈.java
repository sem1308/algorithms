package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1629_곱셈{
	public static long pow(long A, int B, int C) {
		if(B == 0) return 1;
		
		long res = pow(A,B/2,C);
		long result = (res*res) % C;
		if(B % 2 == 0) {
			return result;
		}else {
			return (result * A) % C ;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(tokens.nextToken());
		int B = Integer.parseInt(tokens.nextToken());
		int C = Integer.parseInt(tokens.nextToken());
		
		System.out.println(pow(A,B,C));
	}
}
