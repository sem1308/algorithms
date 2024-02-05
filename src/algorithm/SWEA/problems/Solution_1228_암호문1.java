package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	String num;
	Node next;
	Node(String num){
		this.num = num;
	}
}

class Solution_1228_암호문1
{
	public static Node getNode(Node node, int idx) {
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node;
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;

		StringBuilder sb = new StringBuilder();
		
		Node head = new Node(null);
		Node tail;
		Node tempHead = new Node(null);
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			tail = head;

			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Node node = new Node(tokens.nextToken());
				tail.next = node;
				tail = node;
			}
			
			int M = Integer.parseInt(br.readLine());
			
			tokens = new StringTokenizer(br.readLine());
			Node tempTail = tempHead;
			for (int i = 0; i < M; i++) {
				String op = tokens.nextToken();
				
				switch(op) {
					case "I":
						int x = Integer.parseInt(tokens.nextToken());
						int y = Integer.parseInt(tokens.nextToken());
						
						tempTail = tempHead;
						for (int j = 0; j < y; j++) {
							Node node = new Node(tokens.nextToken());
							tempTail.next = node;
							tempTail = node;
						}
						 
						Node xNode = getNode(head, x);
						
						tempTail.next = xNode.next;
						xNode.next = tempHead.next;
						break;
					default:
						break;
				}
			}
			
			sb.append("#").append(test_case);
			Node node = head.next;
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(node.num);
				node = node.next;
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}