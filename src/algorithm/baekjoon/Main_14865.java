package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14865 {
	
	static int N; // 꼭짓점 개수, 최대 1_000_000

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 캔버스 중앙 점 : (0,0)
		 * 
		 * 시작점, 끝점이 같은 곡선 그림
		 * 
		 * x축 아래 영역 제거
		 * 
		 * 봉우리
		 * - 시작점과 끝점이 x축 상에 있는 곡선 부분과 x축으로 둘러싸인 영역
		 * 
		 * 다른 봉우리에 의해 포함되지 않은 봉우리 개수,
		 * 다른 봉우리를 포함하지 않는 봉우리 개수 구하기
		 * 
		 * 각 좌표는 [-10^9,10^9]
		 * 
		 * 1. 다른 봉우리에 의해 포함되지 않은 봉우리 구하기
		 * 2. 그 봉우리가 포함하는 봉우리 구하기
		 * 
		 * 봉우리 x축 시작 좌표, 끝 좌표 구하기
		 * 시작 좌표로 정렬
		 */
		
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
		
		int firstX = Integer.MIN_VALUE;
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		int stX = Integer.MIN_VALUE;
		int px = Integer.parseInt(tokens.nextToken());
		int py = Integer.parseInt(tokens.nextToken());
		int sx = px;
		int sy = py;
		for (int i = 1; i <= N; i++) {
			int x = 0;
			int y = 0;
			if(i == N) {
				x = sx;
				y = sy;
			}else {
				tokens = new StringTokenizer(br.readLine());
				x = Integer.parseInt(tokens.nextToken());
				y = Integer.parseInt(tokens.nextToken());
			}
			
			if(py < 0 && y > 0) {
				// 아래 -> 위
				stX = px;
			}else if(py > 0 && y < 0){
				// 위 -> 아래 (봉우리 생성)
				if(stX == Integer.MIN_VALUE) firstX = px;
				else {
					if(stX < px) {
						pq.add(new int[] {stX,px});
					}else {
						pq.add(new int[] {px,stX});
					}
				}
			}
			px = x;
			py = y;
		}
		
		if(firstX != Integer.MIN_VALUE) {
			if(stX < firstX) {
				pq.add(new int[] {stX,firstX});
			}else {
				pq.add(new int[] {firstX,stX});
			}
		}
		
		int sum1, sum2;
		sum1 = sum2 = 0;
		
		while(!pq.isEmpty()) {
			// 다른 봉우리에 의해 포함되지 않은 봉우리
			int[] check = pq.poll();
			sum1++;
			
			if(pq.isEmpty() || pq.peek()[1] > check[1]) {
				// q가 비었거나 다음 봉우리 x좌표가 현재 끝 x좌표보다 크다면
				// 봉우리를 포함하지 않음
				sum2++;
			}else {
				// 다른 봉우리에 의해 포함되지 않을때 까지
				while(!pq.isEmpty() && pq.peek()[1] < check[1]) {
					// 다른 봉우리에 의해 포함됨
					int[] prev = pq.poll();
					// // 다른 봉우리를 포함되지 않은 봉우리까지 pop
					while(!pq.isEmpty() && pq.peek()[1] < prev[1]) {					
						prev = pq.poll();
					}
					sum2++;
				}
			}
		}
		
		System.out.println(sum1 + " " + sum2);
	}

}
