package algorithm.SWEA.mid;

import java.util.Scanner;

class Solution1
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int t = 1; t <= T; t++) {
            int N, M;

            N = sc.nextInt();
            M = sc.nextInt();

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int axis = map[i][j];
                    int diag = map[i][j];
                    for (int k = 1; k < M; k++) {
                        int jmk = j-k;
                        int jpk = j+k;
                        int imk = i-k;
                        int ipk = i+k;
                        if(jmk >= 0){
                            axis += map[i][jmk];
                            if(imk >= 0) diag += map[imk][jmk];
                            if(ipk < N) diag += map[ipk][jmk];
                        }
                        if(jpk < N){
                            axis += map[i][jpk];
                            if(imk >= 0) diag += map[imk][jpk];
                            if(ipk < N) diag += map[ipk][jpk];
                        }
                        if(imk >= 0){
                            axis += map[imk][j];
                        }
                        if(ipk < N){
                            axis += map[ipk][j];
                        }
                    }
                    max = Math.max(max, Math.max(axis, diag));
                }
            }

            System.out.println("#"+t+" "+max);
        }
    }
}
