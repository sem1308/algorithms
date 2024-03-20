package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2475{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;

		tokens = new StringTokenizer(br.readLine());
		
		int num = 0;
		for (int i = 0; i < 5; i++) {
			int n = Integer.parseInt(tokens.nextToken());
			num += n*n;
		}
		
		System.out.println(num % 10);
	}
}
