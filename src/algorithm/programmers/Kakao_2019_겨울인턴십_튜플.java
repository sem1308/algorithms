package algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kakao_2019_겨울인턴십_튜플 {

    public static void main(String[] args) {
    }
    class Solution {
        public int[] solution(String s) {
            s = s.substring(1,s.length()-1);
            String[] strings = s.split(",");

            for(int i=0; i<strings.length; i++){
                strings[i] = strings[i].replaceAll("[{}]", "");
            }

            // 문자열 길이로 정렬
            Arrays.sort(strings, Comparator.comparing(String::length));

            boolean[] check = new boolean[100001];
            int[] answer = new int[strings.length];

            for(int i=0; i<strings.length; i++){
                String string = strings[i];
                System.out.println(string);
                string = string.substring(1,s.length()-1);
                for(String str : string.split(",")){
                    int num = Integer.parseInt(str);
                    if(!check[num]){
                        check[num] = true;
                        answer[i] = num;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}