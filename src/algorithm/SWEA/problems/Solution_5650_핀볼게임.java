package algorithm.SWEA.problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임
{	
    static int[][] blockDir = {
    		{},
    		{1,3,0,1},
    		{2,3,1,0},
    		{2,0,3,1},
    		{3,2,0,1},
    		{2,3,0,1},
    };
    
    static int[][][] hole;
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    static int N;
	static int[][] map;
	static int[][][] dp;

	static int sx, sy;
    static int answer;
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        /*
         * 1. 맨 왼쪽 위에서 순차적으로 확인
         * 2. 각 경로에서 어떤 방향으로 갔을 때 얻는 점수를 저장하는 dp 배열 생성
         * 	  - dp[x][y][k] : x,y에서 k방향으로 갈 때 얻는 점수
         * 3. 만약 dp[x][y][k]가 -1이라면 x,y에서 k방향으로 보냄
         * 4. 그렇지 않으면 dp[x][y][k] = dp[nx][ny][k]; 
         * 
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
         * 블럭 1 : 진행 방향 : 하 -> 우(1), 우 -> 좌(3) , 상 -> 하(0), 좌 -> 우(1)
         * 블럭 2 : 진행 방향 : 하 -> 상(2), 우 -> 좌(3) , 상 -> 우(1), 좌 -> 하(0)
         * 블럭 3 : 진행 방향 : 하 -> 상(2), 우 -> 하(0) , 상 -> 좌(3), 좌 -> 우(1)
         * 블럭 4 : 진행 방향 : 하 -> 좌(3), 우 -> 상(2) , 상 -> 하(0), 좌 -> 우(1)
         * 블럭 5 : 진행 방향 : 하 -> 상(2), 우 -> 좌(3) , 상 -> 하(0), 좌 -> 우(1)
         * 
         */
        
        StringTokenizer tokens;
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dp = new int[N][N][4];
			hole = new int[5][2][2];
			int[] holeCnts = new int[5];
			
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
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 4; k++) {
						if(dp[i][j][k] == -1) {
							int x = i;
							int y = j;
							int nx = x + dx[k];
							int ny = y + dy[k];
							int counts = 0;
							
							while(nx != i && ny != j && dp[nx][ny][k] == -1) {
								
								if(nx == sx && ny == sy) {
									dp[x][y][k] = counts;
									System.out.println("end!!!");
									break;
								}
								
								// 벽에 부딪혔을 때
								if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
									// 블럭 5에 부딪힌 것과 같음
									nx = x;
									ny = y;
									k = blockDir[5][k];
									counts++;
								}else {
									int num = map[nx][ny];
									
									if(num == -1) {
										// 블랙홀일 때
										dp[nx][ny][k] = counts;
										System.out.println("end black!!!");
									}else if(num >= 1 && num < 6) {
										// 블럭에 부딪혔을 때
										k = blockDir[num][k];
										counts++;
									}else if(num >= 6){
										// 웜홀에 닿았을 때
										for (int[] xy : hole[num-6]) {
											if(xy[0] != nx || xy[1] != ny) {
												nx = xy[0];
												ny = xy[1];
												break;
											}
										}
									}
									
								}
								
								if(dp[nx][ny][k] == -1) dfs(nx,ny,k,counts);
								
								dp[x][y][k] = dp[nx][ny][k];
								
							}
d							
						}
						answer = Math.max(answer, dp[i][j][k]);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
        System.out.println(sb);
    }
}