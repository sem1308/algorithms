package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        /*
              1
            3 0 2
              4
              5

            동쪽)       서쪽)       남쪽)      북쪽)
              1          1          5         0
            5 2 0      0 2 5      3 1 2     3 4 2
              4          4          0         5
              2          3          4         1

            0 -> 2     0 -> 3     0 -> 4    0 -> 1
            2 -> 5     3 -> 5     4 -> 5    1 -> 5
            5 -> 3     5 -> 2     5 -> 1    5 -> 4
            3 -> 0     2 -> 0     1 -> 0    4 -> 0
         */


        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        int[][] indexChain = {{0,2,5,3},{0,3,5,2},{0,1,5,4},{0,4,5,1}};

        int[] dice = {0,0,0,0,0,0};
        // 처음 위 index = 0
        // 바닥 index = 5 - 위 index
        int topIdx = 0;
        int bottomIdx = 5;

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(tokenizer.nextToken())-1;

            // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
            int nextX = x + dirs[command][0];
            int nextY = y + dirs[command][1];

            if(nextX < 0 || nextX == N || nextY < 0 || nextY == M ) continue;

            x = nextX;
            y = nextY;

            // dice 변경
            int[] chain = indexChain[command];

            int temp = dice[chain[0]];
            dice[chain[0]] = dice[chain[3]];
            dice[chain[3]] = dice[chain[2]];
            dice[chain[2]] = dice[chain[1]];
            dice[chain[1]] = temp;

            if(map[x][y] == 0){
                map[x][y] = dice[bottomIdx];
            }else{
                dice[bottomIdx] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[topIdx]);
        }
    }
}