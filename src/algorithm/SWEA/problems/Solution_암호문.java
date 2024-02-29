package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_암호문 {

	static class Node {	
		String number;
		Node next;
		
		public Node(String number) {
			this.number = number;
		}	
	}
	
	public static Node findNode(Node node, int x) {
		for (int i = 0; i < x; i++) {			
			node = node.next;
		}
		return node;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = 10;

		StringBuilder sb = new StringBuilder();

		Node head = new Node(null);
		Node tail = head;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			tail = head;
						
			tokens = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				Node node = new Node(tokens.nextToken());
				tail.next = node;
				tail = node;
			}
			
			int M = Integer.parseInt(br.readLine());
			
			tokens = new StringTokenizer(br.readLine());
			
			// I x, y, s : �տ������� x��° ��ȣ�� �ٷ� ������ y���� ��ȣ���� ����
			// D x, y : �տ������� x��° ��ȣ�� �ٷ� �������� y���� ��ȣ���� ����
			// A y, s : ��ȣ�� ��ġ �� �ڿ� y���� ��ȣ���� �����δ�
			
			int x, y;
			Node nodeX, nodeY;
			Node tempHead = new Node(null);
			Node tempTail;
			for (int i = 0; i < M; i++) {
				String op = tokens.nextToken();
				
				switch(op) {
					case "I":
						x = Integer.parseInt(tokens.nextToken());
						y = Integer.parseInt(tokens.nextToken());

						tempTail = tempHead;
						for (int j = 0; j < y; j++) {
							Node node = new Node(tokens.nextToken());
							tempTail.next = node;
							tempTail = node;			
						}
						
						nodeX = findNode(head, x);
						
						tempTail.next = nodeX.next;
						nodeX.next = tempHead.next;
						
						break;
					case "D":
						x = Integer.parseInt(tokens.nextToken());
						y = Integer.parseInt(tokens.nextToken());
						
						nodeX = findNode(head, x);
						nodeY = findNode(head, x+y+1);
						
						nodeX.next = nodeY;
						
						break;
					case "A":
						y = Integer.parseInt(tokens.nextToken());

						tempTail = tempHead;
						for (int j = 0; j < y; j++) {
							Node node = new Node(tokens.nextToken());
							tempTail.next = node;
							tempTail = node;			
						}
						
						tail.next = tempHead.next;
						tail = tempTail;
						
						break;
				}
			}
			
			sb.append("#").append(t);
			
			Node node = head.next;
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(node.number);
				node = node.next;
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
