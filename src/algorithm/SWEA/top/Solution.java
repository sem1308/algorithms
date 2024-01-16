package algorithm.SWEA.top;

import java.util.Scanner;

class Solution
{
    public static void dfs(int num, boolean[][] graph, boolean[] visited, int N){
        visited[num] = true;
        for (int i = 1; i <= N; i++) {
            if(graph[num][i] && !visited[i]){
                dfs(i, graph, visited, N);
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();

            boolean[][] graph = new boolean[N+1][N+1];
            boolean[] visited = new boolean[N+1];
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = true;
                graph[b][a] = true;
            }

            for (int i = 1; i <= N; i++) {
                if(!visited[i]){
                    answer++;
                    dfs(i, graph, visited, N);
                }
            }

            System.out.println("#"+test_case+" "+answer);

        }
    }
}
