package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1111 {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 앞 수 * x + y
        /*
         *  
         *  1번째 수 = a
         *  2번째 수 = a*x+y = b
         *  3번째 수 = b*x+y = c
         *  
         *  2번째 수 - 1번재 수 = a(x-1) + y
         *  b-a = a(x-1) + y
         *  3번째 수 - 2번재 수 = b(x-1) + y
         *  c-b = b(x-1) + y
         *  
         *  c-2b+a = (x-1)(b-a)
         *  
         *  x = (c-2b+a) / (b-a) + 1
         *  y = (b-a) - a(x-1)
         *  
         *  if) b-a = 0
         *  	y = -a(x-1)
         *  	c-b = b(x-1) - a(x-1)
         *  		= (b-a)(x-1)
         *  		= 0
         *  	x = 1, y = 0
         */
        
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokenizer.nextToken());
		}
        
        String answer = "B";
        
        int a,b,c,x,y;
        if(N >= 3) {
        	a = nums[0];
        	b = nums[1];
        	c = nums[2];
        	
        	int num1 = c-2*b+a;
        	int num2 = b-a;
        	
        	boolean isZero = num2 == 0;
        	if(isZero || num1 % num2 == 0) {
            	x = isZero ? 1 : num1 / num2 + 1;
        		y = isZero ? 0 : (b-a) - a*(x-1);

            	boolean isValid = true;
            	for (int i = isZero ? 1 : 2; i < N-1; i++) {
                	if(nums[i+1] != nums[i]*x+y) {
                		isValid = false;
                		break;
                	}
    			}
            	if(isValid) answer = ""+(nums[N-1]*x+y);
        	}
        } else if(N==2){
        	answer = nums[0] == nums[1] ? ""+nums[0] : "A";
        } else {
        	answer = "A";
        }
        
        System.out.println(answer);
    }
}