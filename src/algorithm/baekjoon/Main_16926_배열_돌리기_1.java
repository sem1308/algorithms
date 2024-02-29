
package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int num;
	Node next;
	public Node(int num) {
		this.num = num;
	}
}

public class Main_16926_배열_돌리기_1 {
	
	public static Node getNode(Node node, int x) {
		for (int i = 0; i < x; i++) {
			node = node.next;
		}
		return node;
	}
	
	public static void insert(Node[] tails, int k, Node node) {
		tails[k].next = node;
		tails[k] = node;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int R = Integer.parseInt(tokens.nextToken());
		
		int[][] map = new int[N+2][M+2];
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		/*
		 * 1. (min(N,M)-1) / 2 + 1 만큼 LinkedList 생성
		 * 2. list 의 원래 자리가 map의 몇 번째 index인지 저장 
		 *    - k번째 배열 길이 : (N-k)*(M-k) - (N-k-2)*(M-k-2)
		 * 3. 리스트 생성
		 * 4. 각 list 마다 R & size 만큼 회전
		 * 5. map에 값 할당
		 * 6. 출력
		 */

		int min = (Math.min(N, M)-1) / 2 + 1;
		
		int[][] xs = new int[min][]; // xs[i][j] : i번째 Q의 j번째의 x index
		int[][] ys = new int[min][]; 
		
		Node[] heads = new Node[min];
		Node[] tails = new Node[min];
		for (int k = 0; k < min; k++) {
			heads[k] = new Node(-1);
			tails[k] = heads[k];
			
			int x1 = k+1;
			int y1 = k+1;
			int x2 = N-k;
			int y2 = M-k;
			
			int size = 2*(x2+y2-(x1+y1));
			xs[k] = new int[size];
			ys[k] = new int[size];
			
			int idx = 0;
			// 위
			for (int i = y1; i <= y2; i++) {
				insert(tails,k,new Node(map[x1][i]));
				xs[k][idx] = x1;
				ys[k][idx++] = i;
			}

			// 오른쪽
			for (int i = x1+1; i < x2; i++) {
				insert(tails,k,new Node(map[i][y2]));
				xs[k][idx] = i;
				ys[k][idx++] = y2;
			}
			
			// 아래
			for (int i = y2; i >= y1; i--) {
				insert(tails,k,new Node(map[x2][i]));
				xs[k][idx] = x2;
				ys[k][idx++] = i;
			}

			// 왼쪽
			for (int i = x2-1; i > x1; i--) {
				insert(tails,k,new Node(map[i][y1]));
				xs[k][idx] = i;
				ys[k][idx++] = y1;
			}
		}
		
		// R & size 만큼 회전  
		// 3만큼 회전 -> 3번째꺼 까지 뒤에 연결
		// a b c d e -> d e a b c
		
		for (int i = 0; i < min; i++) {
			int idx = R % xs[i].length;
			
			if(idx == 0) continue;
			
			Node node = getNode(heads[i],idx);
			
			tails[i].next = heads[i].next;
			heads[i].next = node.next;
			node.next = null;
			tails[i] = node;
		}
		
		for (int i = 0; i < min; i++) {
			Node temp = heads[i].next;
			for (int j = 0; j < xs[i].length; j++) {
				map[xs[i][j]][ys[i][j]] = temp.num;
				temp = temp.next;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
