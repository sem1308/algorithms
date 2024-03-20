package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1008{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		double A = Double.parseDouble(tokens.nextToken());
		double B = Double.parseDouble(tokens.nextToken());
		
		System.out.println(A / B);
	}

}
