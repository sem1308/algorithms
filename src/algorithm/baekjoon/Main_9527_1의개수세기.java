package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_9527_1의개수세기{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 1~7
		 * 
		 * 000
		 * 001   
		 * 010
		 * 011
		 * 
		 * 000
		 * 001   1
		 * 010
		 * 011   2+1
		 * 100
		 * 101
		 * 110
		 * 111   4+(3+1)
		 * 
		 * 		 8+(8+4)
		 * 
		 * 		 16+(20+)
		 * 
		 * 10100010
		 */
		
		tokens = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(tokens.nextToken());
		long B = Long.parseLong(tokens.nextToken());
		
		
		
		
	}
}
