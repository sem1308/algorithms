package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Kakao_2024_겨울인턴십_선물 {
    class Solution {
        public int solution(String[] friends, String[] gifts) {
            HashMap<String, Integer> friendToIdx = new HashMap<>();
            int[] takesNext = new int[friends.length];

            int idx = 0;
            for (String friend : friends) {
                friendToIdx.put(friend, idx++);
            }

            int[][] giftMap = new int[friends.length][friends.length];

            for (String gift : gifts) {
                String[] g = gift.split(" ");
                int from = friendToIdx.get(g[0]);
                int to = friendToIdx.get(g[1]);
                giftMap[from][to]++;
            }

            // 선물 지수 구하기
            // 선물 지수 = 준 선물 수 - 받은 선물 수
            int[] giftFactor = new int[friends.length];
            for (String friend : friends) {
                int friendIdx = friendToIdx.get(friend);
                int numGives = 0;
                int numTakes = 0;
                for (int i = 0; i < friends.length; i++) {
                    numGives += giftMap[friendIdx][i];
                    numTakes += giftMap[i][friendIdx];
                }
                giftFactor[friendIdx] = numGives - numTakes;
            }

            for (int i = 0; i < friends.length; i++) {
                int A = friendToIdx.get(friends[i]);
                for (int j = i+1; j < friends.length; j++) {
                    int B = friendToIdx.get(friends[j]);
                    if(giftMap[A][B] > giftMap[B][A]){
                        takesNext[A]++;
                    }else if(giftMap[A][B] < giftMap[B][A]){
                        takesNext[B]++;
                    }else{
                        if(giftFactor[A] > giftFactor[B]){
                            takesNext[A]++;
                        }else if(giftFactor[A] < giftFactor[B]){
                            takesNext[B]++;
                        }
                    }
                }
            }
            return Arrays.stream(takesNext).max().getAsInt();
        }
    }
    public static void main(String[] args) {
    }
}