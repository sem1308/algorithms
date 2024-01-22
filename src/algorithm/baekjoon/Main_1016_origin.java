package algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1016_origin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        long min = Long.parseLong(tokenizer.nextToken());
        long max = Long.parseLong(tokenizer.nextToken());

        int answer = 0;
        int MAX_NUM = (int)Math.sqrt(max);

        // 2~10^6까지 소수 저장
        boolean[] primes = new boolean[MAX_NUM+1];
        for (int i = 0; i <= MAX_NUM; i++) {
            primes[i] = true; // primes[i]는 min + i가 소수인지 판단
        }

        for (int i = 2; i <= MAX_NUM; i++) {
            if(primes[i]){
                for (int j = i+i; j < MAX_NUM; j+=i) {
                    primes[j] = false;
                }
            }
        }

        int size = (int)(max-min+1);
        boolean[] nns = new boolean[size];
        for (int i = 2; i <= MAX_NUM; i++) {
            if(primes[i]){
                long powi = (long)i*i;

                long Q = min / powi;
                long R = min % powi;

                long j = R == 0 ? Q * powi : (Q+1) * powi;

                for (; j <= max; j+=powi) {
                    nns[(int)(j-min)] = true;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if(!nns[i]) answer++;
        }

        System.out.println(answer);

    }
}