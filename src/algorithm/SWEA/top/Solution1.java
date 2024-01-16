package algorithm.SWEA.top;

import java.util.*;

public class Solution1
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[][] dir = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = -1;
            int N = sc.nextInt();

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int A = sc.nextInt();
            int B = sc.nextInt();

            int C = sc.nextInt();
            int D = sc.nextInt();

            Queue<int[]> q = new LinkedList<>();
            boolean[][][] visited = new boolean[N][N][3];

            visited[A][B][0] = true;
            q.add(new int[]{A, B, 0});

            while(!q.isEmpty()){
                int[] info = q.poll();
                int x = info[0];
                int y = info[1];
                int cnt = info[2];

                if(x == C && y == D){
                    answer = cnt;
                    break;
                }

                int c = (cnt+1) % 3;
                int nx, ny;
                for (int i = 0; i < 5; i++) {
                    nx = x + dir[i][0];
                    ny = y + dir[i][1];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 1 || (c != 0 && i != 0 && map[nx][ny] == 2) || visited[nx][ny][c]) continue;

                    visited[nx][ny][c] = true;
                    q.add(new int[]{nx,ny,cnt+1});
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
