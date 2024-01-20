package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][][][] pivots = new int[2][2][][];

        pivots[0][0] = new int[][]{{1,1},{-1,0},{0,2},{2,0},{1,-1},{-1,1}};
        pivots[0][1] = new int[][]{{1,-1},{0,1},{2,0},{0,-2},{-1,-1},{1,1}};
        pivots[1][0] = new int[][]{{-1,1},{0,-1},{-2,0},{0,2},{1,1},{-1,-1}};
        pivots[1][1] = new int[][]{{-1,-1},{1,0},{0,-2},{-2,0},{-1,1},{1,-1}};

        int answer = 0;

        // 일자 가로
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M-4; j++) {
                answer = Math.max(answer,map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3]);
            }
        }

        // 일자 세로
        for (int i = 0; i < M; i++) {
            for (int j = 0; j <= N-4; j++) {
                answer = Math.max(answer,map[j][i]+map[j+1][i]+map[j+2][i]+map[j+3][i]);
            }
        }

        // 사각형 파생
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-1; j++) {
                // 사각형
                int sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
                int maxSum = sum;
                // 파생
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        int[][] pivot = pivots[k][l];

                        int pivotX = i+k;
                        int pivotY = j+l;

                        int removeX = pivotX+pivot[0][0];
                        int removeY = pivotY+pivot[0][1];
                        int removeNum = map[removeX][removeY];

                        int addNum = 0;
                        for (int m = 1; m < 6; m++) {
                            int addX = pivotX+pivot[m][0];
                            int addY = pivotY+pivot[m][1];

                            if(addX < 0 || addX >= N || addY < 0 || addY >= M) continue;

                            addNum = Math.max(addNum, map[addX][addY]);
                        }

                        int pivotSum = sum - removeNum + addNum;

                        maxSum = Math.max(maxSum, pivotSum);
                    }
                }
                answer = Math.max(answer, maxSum);
            }
        }

        System.out.println(answer);

    }
}