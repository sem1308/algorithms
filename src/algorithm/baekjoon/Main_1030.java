package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        int s, N, K, R1, R2, C1, C2;
        
        s = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        R1 = Integer.parseInt(tokenizer.nextToken());
        R2 = Integer.parseInt(tokenizer.nextToken());
        C1 = Integer.parseInt(tokenizer.nextToken());
        C2 = Integer.parseInt(tokenizer.nextToken());
        
        // 가로 N^(s-1) 개
        // R1 / N -> i 번째 
        
        /**
         * s = 3, N = 3, K = 1
         * 
         * 1. R1,C1 => x1,y1
         *    - 나머지 저장
         *    - xr1, yr1
         * 2. R2,C2 => x2,y2
         * 	  - 나머지 저장
         *    - xr2, yr2
         * 3. x,y에서 그렸을 때 생기는 모양 생성
         * 	  - N*N
         * 4. (x1,y1) ~ (x2,y2) 그림
         * 5. 나머지에 따라 잘라서 print
         * 
         * (3^(n-1)+3^(n)*k,3^(n-1)+3^(n)*l) => 검은색
         * 
         */
        

    }
}