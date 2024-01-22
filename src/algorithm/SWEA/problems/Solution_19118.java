package algorithm.SWEA.problems;


import java.util.*;
import java.io.*;

public class Solution_19118
{
    static int N;
    static int[] heights;
    static int[] dp;
    public static int dfs(int maxHeight, int idx){
        if(idx == N){
            return 0;
        }
        // 지금 집 철거 O
        int num = dfs(maxHeight, idx+1);
        // 지금 집 철거 X
        if(heights[idx] > maxHeight){
            if(dp[idx] == 0) dp[idx] = 1 + dfs(heights[idx], idx+1);
            return Math.max(dp[idx], num);
        }else{
            return num;
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            dp = new int[N]; // i번째 집을 철거하지 않았을 때 얻을 수 있는 최대 집 개수

            heights = new int[N];
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                heights[i] = Integer.parseInt(tokens.nextToken());
            }

            System.out.println("#"+test_case+" "+(N-dfs(0,0)));
        }
    }
}