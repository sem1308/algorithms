package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        long min = Long.parseLong(tokenizer.nextToken());
        long max = Long.parseLong(tokenizer.nextToken());

        int MAX_NUM = (int)Math.sqrt(max);

        int size = (int)(max-min+1);
        int answer = size;
        boolean[] nns = new boolean[size];
        for (int i = 0; i < size; i++) {
            nns[i] = true; // 제곱 ㄴㄴ 수인지
        }

        for (int i = 2; i <= MAX_NUM; i++) {
            long powi = (long)i*i;

            long Q = min / powi;
            long R = min % powi;

            long j = R == 0 ? Q * powi : (Q+1) * powi;

            for (; j <= max; j+=powi) {
                if(nns[(int)(j-min)]){
                    nns[(int)(j-min)] = false;
                    answer--;
                }
            }
        }

        System.out.println(answer);

    }
}