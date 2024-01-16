package algorithm.SWEA.mid;
import java.util.Scanner;

class Solution3
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    // 90도
                    // (N-1,0) ... (0,0)
                    // (N-1,1) ... (0,1)
                    // ...
                    // (N-1,N-1) ... (0,N-1)
                    System.out.print(map[N-1-j][i]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    // 180도
                    // (N-1,N-1) ... (N-1,0)
                    // (N-2,N-1) ... (N-2,0)
                    // ...
                    // (0,N-1) ... (0,0)
                    System.out.print(map[N-1-i][N-1-j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    // 270도
                    // (0,N-1) ... (N-1,N-1)
                    // (0,N-2) ... (N-1,N-2)
                    // ...
                    // (0,0) ... (N-1,0)
                    System.out.print(map[j][N-1-i]);
                }
                System.out.println();
            }
        }
    }
}
