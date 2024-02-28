package algorithm.SWEA.problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_2115_벌꿀채취
{
    static int N, M, C;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static int[][] maxVal; // 2번째 사람이 i,j에서 채취했을 때의 최대 값

    public static void comb(int idx, int cnt, int cost, int val, int x, int y){
        if(cost > C) return;

        maxVal[x][y] = Math.max(maxVal[x][y], val);

        if(cnt == M) return;

        // 포함 O
        comb(idx+1,cnt+1,cost, val, x, y);
        // 포함 X
        comb(idx+1,cnt+1,cost+map[x][y+idx], val+map[x][y+idx]*map[x][y+idx], x, y);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        /*
            일꾼 2명

            N : 벌통 크기       // 3 ≤ N ≤ 10
            M : 꿀 채취 벌통 수  // 1 ≤ M ≤ 5
            가로 연속된 M개의 벌통 선택후 채취 가능

            하나의 벌통에서 채취한 꿀은 하나의 용기에 담아야함

            C : 채취가능한 꿀 최대 양 // 10 ≤ C ≤ 30
         */

        StringTokenizer tokens;

        for (int t = 1; t <= T; t++) {
            tokens = new StringTokenizer(br.readLine());

            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            C = Integer.parseInt(tokens.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                tokens = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }

            maxVal = new int[N][N-M+1];

            // 가능한 최대 채취 양 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    comb(0,0,0,0,i,j);
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    // 같은 라인
                    int val = 0;
                    for (int k = j+M; k < N-M+1; k++) {
                        val = Math.max(val, maxVal[i][k]);
                    }
                    
                    // 다른 라인
                    for (int k = i+1; k < N; k++) {
                        for (int l = 0; l < N-M+1; l++) {
                            val = Math.max(val, maxVal[k][l]);
                        }
                    }

                    answer = Math.max(answer, maxVal[i][j]+val);
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}