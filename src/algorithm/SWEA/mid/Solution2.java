package algorithm.SWEA.mid;

import java.util.Scanner;

class Solution2
{
    public static int solve(int[][] map){
        for (int i = 0; i < 9; i++) {
            boolean[] checkHor = new boolean[10];
            boolean[] checkVer = new boolean[10];

            for (int j = 0; j < 9; j++) {
                //가로
                if(checkHor[map[i][j]]) return 0;
                checkHor[map[i][j]] = true;
                //세로
                if(checkVer[map[j][i]]) return 0;
                checkVer[map[j][i]] = true;
            }
        }

        //격자
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[10];
            int n = 3 * (i / 3);
            int m = 3 * (i % 3);
            for (int j = n; j < n+3; j++) {
                for (int k = m; k < m+3; k++) {
                    if(check[map[j][k]]) return 0;
                    check[map[j][k]] = true;
                }
            }
        }

        return 1;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int[][] map = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + t + " " + solve(map));
        }
    }
}
