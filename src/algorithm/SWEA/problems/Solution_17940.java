package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17940
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            long N = Long.parseLong(tokenizer.nextToken());
            long A = Long.parseLong(tokenizer.nextToken());
            long B = Long.parseLong(tokenizer.nextToken());

            long answer = -1;

            // N = B * x + Y + A * y;

            long Q = N / A;
            if(A * Q <= N && N <= B * Q){
                long BMA = B - A;
                Q = N / B;

                long R = N % B;

                long Y;
                long numA;
                long numB;

                if(R <= A){
                    if(R == 0){
                        numA = 0;
                        Y = 0;
                        numB = Q;
                    }else{
                        long AMR = A - R;
                        long RQ = AMR / BMA;
                        long RR = AMR % BMA;

                        numA = RQ+1;
                        if(RR == 0){
                            Y = 0;
                            numB = Q-numA+1;
                        }else{
                            Y = A+(BMA-RR);
                            numB = Q-numA;
                        }
                    }
                }else {
                    numA = 0;
                    Y = R;
                    numB = Q;
                }

                answer = B * (numB * N - (numB * (numB + 1) / 2) * B);
                N -= B * numB;

                answer += Y * (N-Y);
                N -= Y;

                answer += A * (numA * N - (numA * (numA + 1) / 2) * A);
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}