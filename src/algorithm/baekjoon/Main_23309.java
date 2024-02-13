package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_23309{
	
	static class Node{
		int no;
		Node next, prev;
		
		public Node(int no) {
			this.no = no;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer;
		
		tokenizer = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		
		Node[] nodes = new Node[1_000_001];
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}
		
		tokenizer = new StringTokenizer(br.readLine());
		Node head = null;
		Node tail = null;
		Node node;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			node = nodes[num];
			if(head == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			nodes[num] = node;
		}
		
		tail.next = head;
		head.prev = tail;
		
		StringBuilder sb = new StringBuilder();
		
		int i, j;
		Node nodeI;
		for (int m = 0; m < M; m++) {
			tokenizer = new StringTokenizer(br.readLine());
			String op = tokenizer.nextToken();
			switch(op) {
				case "BN":
					i = Integer.parseInt(tokenizer.nextToken());
					j = Integer.parseInt(tokenizer.nextToken());
					
					nodeI = nodes[i];
					node = nodes[j];
					
					sb.append(nodeI.next.no).append("\n");
					
					node.next = nodeI.next;
					node.prev = nodeI;
					
					nodeI.next = node;
					node.next.prev = node;
					break;
				case "BP":
					i = Integer.parseInt(tokenizer.nextToken());
					j = Integer.parseInt(tokenizer.nextToken());
					
					nodeI = nodes[i];
					node = nodes[j];

					sb.append(nodeI.prev.no).append("\n");
					
					node.next = nodeI;
					node.prev = nodeI.prev;
					
					nodeI.prev = node;
					node.prev.next = node;
					
					break;
				case "CN":
					i = Integer.parseInt(tokenizer.nextToken());
					nodeI = nodes[i];
					
					node = nodeI.next;
					
					sb.append(node.no).append("\n");
					
					node.prev.next = node.next;
					node.next.prev = node.prev;
					
					break;
				case "CP":
					i = Integer.parseInt(tokenizer.nextToken());
					nodeI = nodes[i];
					
					node = nodeI.prev;
					
					sb.append(node.no).append("\n");
					
					node.prev.next = node.next;
					node.next.prev = node.prev;
					
					break;
			}
		}
		
		System.out.println(sb);
	}

}
