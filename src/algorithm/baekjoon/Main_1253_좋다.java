package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1253_좋다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens;

        /*
            1. 숫자 2개 조합으로 만들 수 있는 모든 수 set에 저장
            2. a + b = a or b인 상황 처리
            3. N개 숫자중 set에 포함되는 숫자 개수 출력
         */

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        HashMap<Integer, Integer> numsCount = new HashMap<>();

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(tokens.nextToken());
            nums[i] = num;
            int count = numsCount.getOrDefault(num,0);
            numsCount.put(num,count+1);
        }

        Arrays.sort(nums);

        int answer = 0;
        
        for (int i = 0; i < N; i++) {
        	// i번째 수를 만들 수 있는지 이분 탐색으로 확인
        	int left = 0;
        	int right = N;
        	
        	while(left < right) {
        		int mid = (left + right) / 2;
        		
        		int sum = nums[left] + nums[right];
        		
        		if(sum == nums[i]) {
        			answer++;       			
        			break;
        		}else if(sum > nums[i]) {
        			right = mid;
        		}else{
        			left = mid+1;        			
        		}
        	}
        }        
        
        System.out.println(answer);
    }
}