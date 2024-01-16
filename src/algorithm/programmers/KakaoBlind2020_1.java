package algorithm.programmers;

import java.util.*;

public class KakaoBlind2020_1 {

    public static void main(String[] args) {
    }
    class Solution {
        public int getDigit(int num){
            if(num==1) return 0;
            return (int)Math.log10(num)+1;
        }
        public int solution(String s) {
            int answer = s.length();

            for(int i=1; i<=s.length()/2; i++){
                String priStr=s.substring(0,i);
                int num = 1, result = 0;
                int j;
                for(j=i; (j+i)<=s.length(); j+=i){
                    String str = s.substring(j,j+i);
                    if(priStr.equals(str)) num++;
                    else{
                        result += (i+getDigit(num));
                        priStr = str;
                        num = 1;
                    }
                }
                result += (i+getDigit(num));
                result += s.length()-j;
                answer = Math.min(answer, result);
            }
            return answer;
        }
    }
}