package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1991_트리순회{

	static class Node{
		String name;
		Node leftChild;
		Node rightChild;
		public Node(String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String,Node> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			String name = tokens.nextToken();
			
			
		}
		
		
		
	}
}