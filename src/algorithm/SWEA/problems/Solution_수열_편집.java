package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_수열_편집 {
	
	static class Node {	
		String number;
		Node next;
		
		public Node(String number) {
			this.number = number;
		}	
	}
	
	public static Node findNode(Node node, int x) {
		for (int i = 0; i < x; i++) {			
			if(node == null) break;
			node = node.next;
		}
		return node;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		Node head = new Node(null);
		Node tail = head;
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			int L = Integer.parseInt(tokens.nextToken());

			tokens = new StringTokenizer(br.readLine());

			tail = head;
			for (int i = 0; i < N; i++) {
				Node node = new Node(tokens.nextToken());
				tail.next = node;
				tail = node;
			}
			
			// I x, n : x�� �տ� n �߰�
			// D x : x�� ����
			// C x, n : x���� ��ȣ�� n���� ����
			
			int x;
			String n;
			Node nodeX, node;
			for (int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());

				String op = tokens.nextToken();
				x = Integer.parseInt(tokens.nextToken());
				
				switch(op) {
					case "I":
						n = tokens.nextToken();
						
						nodeX = findNode(head, x);
						node = new Node(n);
						
						node.next = nodeX.next;
						nodeX.next = node;
						
						break;
					case "D":
						node = findNode(head, x);
						if(node.next != null)
							node.next = node.next.next;
						
						break;
					case "C":
						n = tokens.nextToken();

						nodeX = findNode(head.next, x);
						nodeX.number = n;
						
						break;
				}
			}
			
			node = findNode(head.next, L);
			
			sb.append("#").append(t).append(" ").append(node == null ? "-1" : node.number).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
