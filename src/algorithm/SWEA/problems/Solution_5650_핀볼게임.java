package algorithm.SWEA.problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Coord {
	int x, y, k;
	boolean isWallOrBlock;
	Coord(int x, int y, int k, boolean isWallOrBlock){
		this.x = x;
		this.y = y;
		this.k = k;
		this.isWallOrBlock = isWallOrBlock;
	}
	
	public String toString() {
		return x + ", " + y + " : " + k;
	}
}

public class Solution_5650_핀볼게임
{	    
    static int[][][] hole;
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    static int N;
	static int[][] map;
	static int[][][] dp;
	static boolean[][][] isWB;

    static int answer;
    
    public static boolean isBound(int x, int y) {
    	return x < 0 || x >= N || y < 0 || y >= N;
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        /*
         * == 블록 ==
         * - 블록은 각 번호마다 어느 방향에서 왔을 때 어느 방향으로 반환하는지 저장하는 배열 생성
         * int[][] blockDir;
         * 
         * blockDir[i][k] : i번째 블록에 k 방향으로 도달했을 때 변환된 방향 값
		 *
         *  		 	 0 1 2 3
         * int[] dx, dy :하 우 상 좌 순서
         * 
         * {1,0,-1,0}
         * {0,1,0,-1}
         * 
         * 블럭 1 : 진행 방향 : 하 -> 우(1), 우 -> 좌(3) , 상 -> 하(0), 좌 -> 상(2)
         * 블럭 2 : 진행 방향 : 하 -> 상(2), 우 -> 좌(3) , 상 -> 우(1), 좌 -> 하(0)
         * 블럭 3 : 진행 방향 : 하 -> 상(2), 우 -> 하(0) , 상 -> 좌(3), 좌 -> 우(1)
         * 블럭 4 : 진행 방향 : 하 -> 좌(3), 우 -> 상(2) , 상 -> 하(0), 좌 -> 우(1)
         * 블럭 5 : 진행 방향 : 하 -> 상(2), 우 -> 좌(3) , 상 -> 하(0), 좌 -> 우(1)
         * 
         */
        
        int[][] blockDir = {
        		{},
        		{1,3,0,2},
        		{2,3,1,0},
        		{2,0,3,1},
        		{3,2,0,1},
        		{2,3,0,1},
        };
        
        StringTokenizer tokens;
        StringBuilder sb = new StringBuilder();

		int[] holeCnts = new int[5];
        for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dp = new int[N][N][4];
			isWB = new boolean[N][N][4];
			hole = new int[5][2][2];
			answer = 0;
					
			// 맵 저장
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
					Arrays.fill(dp[i][j], -1);
					if(map[i][j] >= 6 && map[i][j] <= 10) {
						int holeIdx = map[i][j] - 6;
						hole[holeIdx][holeCnts[holeIdx]][0] = i; 
						hole[holeIdx][holeCnts[holeIdx]++][1] = j;
					}
				}
			}
			
			/*
			 * 1. 빈 공간이고 dp가 설정되지 않았으면 시작
			 * 2. 가는길을 전부 stack에 넣음
			 * 3. 만약 블랙홀이거나 이미 왔던 길이라면 break
			 * 	  - 왔던 길이란 결국 방향이 반대로 바뀌는 경우
			 * 4. 맨 위부터 빼와서 dp에 기록
			 *    - 블랙홀인 경우 0에서 시작, 블럭을 만나면 +1
			 *    - 벽이나 블록인 경우 1에서 시작, 블럭을 만나면 +2
			 */
			
			Stack<Coord> stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < 4; d++) {
						if(map[i][j] == 0 && dp[i][j][d] == -1) {
							int x = i;
							int y = j;
							int k = d;
							
							System.out.println(x + ", " + y + " : " + k +" 에서 시작");
							
							int init = 0;
							int alpha = 1;
							// 경로 stack에 넣기
							boolean isWallOrBlock = false;
							while(true) {
								stack.add(new Coord(x,y,k,isWallOrBlock));
								
								if(dp[x][y][k] != -1) {
									if(isWB[x][y][k]) {
										init = 1;
										alpha = 2;
									}
									break;
								}
								
								x += dx[k];
								y += dy[k];
								int nk = k;
								// 벽에 부딪혔을 때
								if(isBound(x,y)) {
									// 블럭 5에 부딪힌 것과 같음
									nk = blockDir[5][k];
									isWallOrBlock = true;
								}else {
									int num = map[x][y];
									if(num == -1) {
										break;
									}else if(num==0){
										isWallOrBlock = false;
									}else if(num >= 1 && num < 6) {
										// 블럭에 부딪혔을 때
										nk = blockDir[num][k];
										isWallOrBlock = true;
									}else if(num >= 6){
										// 웜홀에 닿았을 때
										for (int[] xy : hole[num-6]) {
											if(xy[0] != x || xy[1] != y) {
												x = xy[0];
												y = xy[1];
												break;
											}
										}
										isWallOrBlock = false;
									}
								}
								
								if(nk == (k+2) % 4) {
									init = 1;
									alpha = 2;
									break;
								}

								k = nk;
							}
							
							Coord coord = stack.pop();
							if(dp[coord.x][coord.y][coord.k] == -1) 
								dp[coord.x][coord.y][coord.k] = init;
							
							if(init == 1) {
								isWB[coord.x][coord.y][coord.k] = true;
							}
							
							// stack에서 빼오며 dp에 저장
							int px = coord.x;
							int py = coord.y;
							int pk = coord.k;
							while(!stack.isEmpty()) {
								System.out.print(coord);
								System.out.println(" -> " + dp[px][py][pk]);
								coord = stack.pop();
								dp[coord.x][coord.y][coord.k] = coord.isWallOrBlock ? dp[px][py][pk] + alpha : dp[px][py][pk];
								isWB[coord.x][coord.y][coord.k] = isWB[px][py][pk];
								px = coord.x;
								py = coord.y;
								pk = coord.k;
							}
							System.out.print(coord);
							System.out.println(" -> " + dp[px][py][pk]);
							
							answer = Math.max(answer, dp[i][j][d]);
						}
					}
				}
			}
			
			for (int i = 0; i < 5; i++) holeCnts[i] = 0;
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
        System.out.println(sb);
    }
}