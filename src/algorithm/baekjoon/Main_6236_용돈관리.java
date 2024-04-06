package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6236_용돈관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer;

        /*
           N일동안 사용 금액 계산
           M번만 통장에서 돈 빼서 씀
           K원 인출 하루 보내면 사용, 모자르면 남은 금액 넣고 다시 K원 인출

           남은 금액이 많더라로 다시 넣고 인출 가능
           K 최소화

           N -> 100_000 *
           K -> 10_000

           1_000_000_000
         */

        tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] costs = new int[N];
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }

        int rb = 1_000_000_000;
        int lb = 1;

        while(lb <= rb){
            int k =  (lb+rb) / 2;

            int money = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if(money < costs[i]){
                    money = k;
                    cnt++;
                }
                money -= costs[i];
                if(money < 0) break;
            }

            if(money < 0 || cnt > M){
                // 불가능
                lb = k+1;
            }else{
                // 가능
                rb = k-1;
            }

        }
        System.out.println(rb+1);

    }
}