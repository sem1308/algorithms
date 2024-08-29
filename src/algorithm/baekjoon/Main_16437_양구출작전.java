package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Island {
	int num;
	long amount;
	List<Island> children;

	public Island(int num, int amount) {
		this.num = num;
		this.amount = amount;
		this.children = new ArrayList<>();
	}

	public long simulate(Island parent) {
        for (Island child : children) {
            if (child.num != parent.num) {
                this.amount += child.simulate(this);
            }
        }
		return Math.max(amount, 0);
	}
}

public class Main_16437_양구출작전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;

		/*
		 * N개 섬
		 * 1 ~ N번
		 *
		 * 1번 섬 : 구명보트
		 * 다른 섬 : 양, 늑대
		 *
		 * 양 -> 늑대 없는 나라
		 *
		 * 각 섬 -> 1번 섬 경로 유일
		 *
		 * 양 -> 1번 섬
		 * 늑대 : 자리에서 최대 한마리 양 잡아먹음
		 *
		 * 1번 섬에 도달하는 양의 수 구하기
		 * 2 ≤ N ≤ 123,456
		 *
		 * t,a,p
		 * t : W or S
		 * a : 1 <= a <= 10^9
		 * p : p번 섬 다리
		 *
		 * 트리 형태
		 *
		 * 각 node에는 amount 저장
		 * W(늑대)면 -
		 * S(양)이면 +
		 */

		int N = Integer.parseInt(br.readLine());

		Island[] islands = new Island[N+1];

		for (int i = 0; i <= N; i++) {
			islands[i] = new Island(i, 0);
		}

		for (int i = 2; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			String t = tokens.nextToken();
			int a = Integer.parseInt(tokens.nextToken());
			int p = Integer.parseInt(tokens.nextToken());

			islands[i].amount = t.equals("S") ? a : -a;

			islands[i].children.add(islands[p]);
			islands[p].children.add(islands[i]);
		}

		System.out.println(islands[1].simulate(islands[0]));
	}
}
