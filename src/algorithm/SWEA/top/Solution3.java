package algorithm.SWEA.top;

import java.util.*;

public class Solution3
{
    static class Info implements Comparable<Info>{
        int x;
        int y;
        int cnt;

        public Info(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            if (this.cnt > o.cnt)
                return 1;
            else if (this.cnt < o.cnt)
                return -1;
            return 0;
        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;

            int N = sc.nextInt();
            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j)-'0';
                }
            }

            PriorityQueue<Info> q = new PriorityQueue<>();

            visited[0][0] = true;
            q.add(new Info(0,0,0));

            while (!q.isEmpty()) {
                Info info = q.poll();

                if(info.x == N-1 && info.y == N-1){
                    answer = info.cnt;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = info.x + dir[i][0];
                    int ny = info.y + dir[i][1];

                    if(nx < 0 || nx == N || ny < 0 || ny == N || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new Info(nx,ny,info.cnt + map[nx][ny]));
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
