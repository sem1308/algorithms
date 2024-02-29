package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기_3 {

	static class Node{
		int num;
		Node[] nexts; // down, right, up, left;
		public Node(int num) {
			nexts = new Node[4];
			this.num = num;
		}
	}
	
	static int downDir = 0; 
	static int rightDir = 1;
	static int upDir = 2;
	static int leftDir = 3;
	
	static int x;
	static int y;
	
	static int halfX;
	static int halfY;
	
	public static Node getNode(Node head, int dir, int x) {
		for (int i = 0; i < x; i++) {
			head = head.nexts[dir];
		}
			
		return head; 
	}
	
	public static void swapXY() {
		int t = x;
		x = y;
		y = t;

		t = halfX;
		halfX = halfY;
		halfY = t;
	}
	
	public static void turnDir(int amount) {
		rightDir = (rightDir+amount) % 4;
		downDir = (downDir+amount) % 4;
		leftDir = (leftDir+amount) % 4;
		upDir = (upDir+amount) % 4;
	}
	
	public static void concat(Node[] heads, Node[] tails, int[] ht, int leftDir, int rightDir, int downDir, int to) {
		int h1 = ht[0];
		int t1 = ht[1];
		int h2 = ht[2];
		int t2 = ht[3];
		
		for (int i = 0; i < to; i++) {
			heads[h1].nexts[leftDir] = tails[t1];
			tails[t1].nexts[rightDir] = heads[h1];

			heads[h2].nexts[leftDir] = tails[t2];
			tails[t2].nexts[rightDir] = heads[h2];
			
			for (int j = 0; j < 4; j++) {
				heads[j] = heads[j].nexts[downDir];
				tails[j] = tails[j].nexts[downDir];				
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int R = Integer.parseInt(tokens.nextToken());
		
		Node[] rheads = new Node[N]; // 행의 head 들
		Node[] rtails = new Node[N]; // 행의 tail 들
		Node[] cheads = new Node[M]; // 열의 head 들
		Node[] ctails = new Node[M]; // 열의 tail 들
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Node node = new Node(Integer.parseInt(tokens.nextToken()));
				if(rheads[i] == null) {
					rheads[i] = node;
					rtails[i] = node;
				} else {
					rtails[i].nexts[rightDir] = node;
					node.nexts[leftDir] = rtails[i];
					rtails[i] = node;
				}
				if(cheads[j] == null) {
					cheads[j] = node;
					ctails[j] = node;
				} else {
					ctails[j].nexts[downDir] = node;
					node.nexts[upDir] = ctails[j];
					ctails[j] = node;
				}
			}
		}
		
		x = N;
		halfX = x/2;
		y = M;
		halfY = y/2;

		tokens = new StringTokenizer(br.readLine());
		Node head, temp;
		head = rheads[0];
		
		Node[] heads = new Node[4];
		Node[] tails = new Node[4];
		
		boolean isLRInv = false;
		boolean isUDInv = false;
		for (int r = 0; r < R; r++) {
			String op = tokens.nextToken();
			
			switch(op) {
				case "1":
					// 상하 반전
					head = getNode(head,downDir,x-1);
					upDir = downDir;
					downDir = (downDir+2) % 4;
					isUDInv = !isUDInv;
					break;
				case "2":
					// 좌우 반전					
					head = getNode(head,rightDir,y-1);
					leftDir = rightDir;
					rightDir = (rightDir+2) % 4;
					isLRInv = !isLRInv;
					break;
				case "3":
					// 오른쪽 90도
					head = getNode(head,downDir,x-1);

					turnDir(isLRInv ^ isUDInv ? 3 : 1);
					
					swapXY();
					
					break;
				case "4":
					// 왼쪽 90도
					head = getNode(head,rightDir,y-1);

					turnDir(isLRInv ^ isUDInv ? 1 : 3);
					
					swapXY();
					
					break;
				case "5":
					heads[0] = head;
					heads[1] = getNode(heads[0],rightDir,halfY);
					heads[2] = getNode(heads[1],downDir,halfX);
					heads[3] = getNode(heads[0],downDir,halfX);
					
					for (int i = 0; i < 4; i++) {
						tails[i] = getNode(heads[i],rightDir,halfY-1);
					}
					
					// 1 왼쪽에 4 연결, 2 왼쪽에 3 연결					
					concat(heads, tails, new int[] {0,3,1,2}, 
							leftDir, rightDir, downDir, halfX);

					heads[0] = head;
					heads[1] = getNode(heads[0],rightDir,halfY);
					heads[2] = getNode(heads[1],downDir,halfX);
					heads[3] = getNode(heads[0],downDir,halfX);
					
					for (int i = 0; i < 4; i++) {
						tails[i] = getNode(heads[i],downDir,halfX-1);
					}

					head = heads[3];

					concat(heads, tails,new int[] {2,3,1,0}, 
							upDir, downDir, rightDir, halfY);					

					break;
				case "6":
					heads[0] = head;
					heads[1] = getNode(heads[0],rightDir,halfY);
					heads[2] = getNode(heads[1],downDir,halfX);
					heads[3] = getNode(heads[0],downDir,halfX);
					
					for (int i = 0; i < 4; i++) {
						tails[i] = getNode(heads[i],rightDir,halfY-1);
					}

					concat(heads, tails, new int[] {2,1,3,0}, 
							leftDir, rightDir, downDir, halfX);					
					
					heads[0] = head;
					heads[3] = getNode(heads[0],downDir,halfX);
					heads[2] = getNode(heads[3],rightDir,halfY);
					heads[1] = getNode(heads[2],upDir,halfX);

					for (int i = 0; i < 4; i++) {
						tails[i] = getNode(heads[i],downDir,halfX-1);
					}

					head = heads[1];

					// 2 아래에 1 연결, 3 아래에 4 연결
					concat(heads, tails, new int[] {0,1,3,2}, 
							upDir, downDir, rightDir, halfY);	

					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		temp = head;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				sb.append(head.num).append(" ");
				head = head.nexts[rightDir];				
			}
			sb.append("\n");
			head = temp.nexts[downDir];
			temp = head;			
		} 
		
		System.out.println(sb);
	}
}
