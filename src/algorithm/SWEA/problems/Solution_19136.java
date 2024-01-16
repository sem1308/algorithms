package algorithm.SWEA.problems;

import java.util.*;

public class Solution_19136
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 1;

            int N = sc.nextInt();
            int M = sc.nextInt();
            int P = sc.nextInt();

            if(N % 2 == 1 && M % 2 == 1){
                answer = 1;
            }else if(N % 2 == 1 || M % 2 == 1){
                int num;
                int odd;
                if(N % 2 == 1){
                    num = M / 2+1;
                    odd = N / 2;
                }else{
                    num = N / 2+1;
                    odd = M / 2;
                }
                for (int i = 0; i < odd; i++) {
                    answer = (answer * num) % P;
                }
            }else{

            }

            System.out.println("#"+test_case+" "+answer);

        }
    }
}