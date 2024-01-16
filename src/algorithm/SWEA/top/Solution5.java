package algorithm.SWEA.top;

import java.util.Scanner;

public class Solution5
{
    static int N;
    static int[][] coords;
    static int[][] dists;
    static int answer;

    public static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void dfs(int num, boolean[] visited, int cnt, int cost) {
        if(cnt == N){
            answer = Math.min(answer, cost+dists[num][N+1]);
            return;
        }
        visited[num] = true;
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                dfs(i, visited, cnt+1, cost+dists[num][i]);
            }
        }
        visited[num] = false;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            answer = 99999999;

            coords = new int[N+2][N+2];
            // 회사
            coords[N][0] = sc.nextInt();
            coords[N][1] = sc.nextInt();

            // 집
            coords[N+1][0] = sc.nextInt();
            coords[N+1][1] = sc.nextInt();

            // 고객
            for (int i = 0; i < N; i++) {
                coords[i][0] = sc.nextInt();
                coords[i][1] = sc.nextInt();
            }

            dists = new int[N + 2][N + 2];
            for (int i = 0; i < N+2; i++) {
                for (int j = 0; j < N+2; j++) {
                    if(i==j) continue;
                    dists[i][j] = getDist(coords[i][0], coords[i][1], coords[j][0], coords[j][1]);
                }
            }

            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                dfs(i, visited, 1, dists[N][i]);
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
