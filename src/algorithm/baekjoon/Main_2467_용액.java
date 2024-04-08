package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467_용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens;

        /*
            1. 만약 ed를 줄였을 때 값이 작아지면 ed를 줄임
            2. 그렇지 않으면 st를 늘림
         */

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokens.nextToken());
        }

        int st = 0;
        int ed = N-1;

        int minVal = Integer.MAX_VALUE;
        int stNum = nums[st];
        int edNum = nums[ed];
        while(st < ed){
            int val = nums[st] + nums[ed];
            int valAbs = Math.abs(val);
            if(minVal > valAbs){
                minVal = valAbs;
                stNum = nums[st];
                edNum = nums[ed];
            }
            if(val >= 0){
                ed--;
            }else{
            	st++;
            }
        }

        System.out.println(stNum+" "+edNum);
    }
}