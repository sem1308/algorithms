package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17135_캐슬_디펜스 {

	static int N,M,D; 
	static int[] arcCols = new int[3]; // 궁수 위치

	static int numEnemies; // 초기 적 수 
	static int[][] map; // 맵 정보
	static int[][] copyMap; // 맵 정보 - 복사용

	static Set<Integer> enemyNums = new HashSet<>(); // 죽일 적 번호
	static Queue<Info> q = new ArrayDeque<>(); // 적 탐색용 Queue
	
	static int[][] enemyCoords; // 적 좌표
	
	static int[] dx = {0,-1,0}; // 왼쪽 위 오른쪽
	static int[] dy = {-1,0,1};
	
	static int answer; // 정답
	
	static class Info{
		int x,y;
		int cnt;
		
		public Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && y < M;
	}
	
	public static void play() {
		// 게임 시작
		int kill = 0; // 죽인 적 수
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}
		
		// 최대 N-1턴
		for(int round = 0; round < N; round++) {
			int arcRow = N-1-round; // 궁수의 첫 공격 행
			for (int i = 0; i < 3; i++) {
				// 궁수별 죽일 적 찾기
				boolean[][] visited = new boolean[N][M];
				
				// 궁수 탐지 정보 넣어줌 (x,y,cnt) 
				q.add(new Info(arcRow,arcCols[i],1));
				visited[arcRow][arcCols[i]] = true;
				
				while(!q.isEmpty()) {
					Info info = q.poll();
					
					// 만약 아직 죽지않은 적이 있다면
					if(copyMap[info.x][info.y] != 0) {
						// 적의 번호를 set에 넣어줌 - 중복 제거
						enemyNums.add(copyMap[info.x][info.y]);
						break;
					}
					
					// 사거리가 되지 않으면 continue
					if(info.cnt == D) continue;

					// 왼쪽, 위, 오른쪽 순으로 q에 넣어줌
					for (int j = 0; j < 3; j++) {
						int nx = info.x + dx[j];
						int ny = info.y + dy[j];
						
						if(!isRange(nx,ny) || visited[nx][ny]) continue;
						
						visited[nx][ny] = true;
						q.add(new Info(nx,ny,info.cnt+1));
					}
				}
				q.clear();
			}
			for(int num : enemyNums) {
				int x = enemyCoords[num][0];
				int y = enemyCoords[num][1];
				// 적이 죽었음을 0으로 표시
				copyMap[x][y] = 0;
			}
			// 죽인 적 수 증가
			kill += enemyNums.size();
			enemyNums.clear();
		}
		
		answer = Math.max(answer, kill);
	}
	
	public static void comb(int cnt, int idx) {
		// 궁수 조합 찾기
		if(cnt == 3) {
			play();
			return;
		}
		
		for (int i = idx; i < M; i++) {
			arcCols[cnt] = i;
			comb(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());

		/*
		 * 궁수 3명 배치
		 * 거리 D 이하 적중 가장 가까운 적
		 * 여러명일 경우 가장 왼쪽 공격
		 * 
		 * 라운드가 지날 시
		 * 적이 내려오는 것 보다
		 * 궁수가 올라가는 것으로 구현
		 * 
		 */
		
		map = new int[N][M];
		copyMap = new int[N][M]; 
		enemyCoords = new int[N*M+1][2];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j]==1) {
					map[i][j] = ++numEnemies;
					enemyCoords[map[i][j]][0] = i;
					enemyCoords[map[i][j]][1] = j;
				}
			}
		}
		
		answer = 0;
		
		comb(0,0);
		
		System.out.println(answer);
		
	}
}
