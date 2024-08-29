package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

class TNode{
	int num;
	List<Integer> children;

	public TNode(int num) {
		this.num = num;
	}
}

public class Main_19535_ㄷㄷㄷㅈ {
	static int N;
	static int numE=0;
	static int numW=0;

	public static void dfs(int n, int p) {

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * D 트리: ㄷ이 ㅈ의 3배보다 많음
		 * G 트리: ㄷ이 ㅈ의 3배보다 적음
		 * DUDUDUNGA-트리: ‘ㄷ’이 ‘ㅈ’의 정확히 3배만큼 있는 트리
		 *
		 * N : 트리 정점 수
		 *
		 * ㄷ -> child가 1개
		 * ㅈ -> child가 2개
		 *
		 * 1) root는 1번
		 * 2) child의 child 개수만큼 ㄷ자 생성
		 * 3) child의 child수C2만큼 ㅈ자 생성
		 */

		N = Integer.parseInt(br.readLine());

		TNode[] nodes = new TNode[N+1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new TNode(i);
		}

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			nodes[a].children.add(b);
			nodes[b].children.add(a);
		}

		for (int node: nodes[1].children) {
			dfs(node, 1);
		}

		
	}
}
