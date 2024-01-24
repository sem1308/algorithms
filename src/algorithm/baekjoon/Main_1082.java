package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        // dp[m] : m원으로 만들 수 있는 최대 숫자
        // dp[m] = max(k+dp[i-P[k]]);
        // k+dp[i-P[k]]는 string
        // 길이 비교 후 string 비교

        String[] dp  = new String[M+1];
        Arrays.fill(dp,"");

        List<String> nums = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            for (int k = 0; k < N; k++) {
                int imp = i-P[k];
                if(imp >= 0) nums.add(k+dp[imp]);
            }

            nums.sort((a, b) -> {
                int lenA = a.length();
                int lenB = b.length();
                if (lenA == lenB) return b.compareTo(a);
                return lenB - lenA;
            });

            if(i == M){
                String num = nums.get(0);
                dp[i] = num.charAt(0)=='0' ? (nums.size()==1 ? "0" : nums.get(1)) : num;
            }else if(!nums.isEmpty()){
                dp[i] = nums.get(0);
                nums.clear();
            }
        }
        System.out.println(dp[M]);
    }
}