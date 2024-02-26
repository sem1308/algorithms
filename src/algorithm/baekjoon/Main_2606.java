package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606 {
    static int N, cnt = 0;
    static int[][] computer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        computer = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        
        int birus = Integer.parseInt(br.readLine());
        for (int i = 0; i < birus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            computer[from][to] = computer[to][from] = 1;
        }

        dfs(1);
        System.out.println(cnt-1);
    }
    
    private static void dfs(int depth) {
        cnt++;
        visited[depth] = true;
        
        for (int i = 1; i <= N; i++) {
            if (computer[i][depth] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}