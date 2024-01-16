package algorithm.SWEA.mid;

import java.util.Scanner;

class Solution4
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for (int tt = 1; tt <= T; tt++) {
            int t = sc.nextInt();

            int[] scores = new int[101];
            for (int i = 0; i < 1000; i++) {
                scores[sc.nextInt()]++;
            }
            int max_num = -1;
            int max_cnt = 0;
            for (int i = 0; i <= 100; i++) {
                if(max_cnt <= scores[i]){
                    max_num = i;
                    max_cnt = scores[i];
                }
            }
            System.out.println("#"+t+" " + max_num);
        }
    }
}
