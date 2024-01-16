package algorithm.programmers;

import java.util.Arrays;

public class Kakao_2024_겨울인턴십_주사위 {

    class Solution {
        int[][] dice;
        int[] answer;
        int n;
        int halfN;
        int caseSize;
        boolean[] selected;
        int[][] pairs;
        int pairIdx;
        int maxWin;

        public void setPairs(int cnt, int[] pair){
            if(cnt == halfN){
                pairs[pairIdx++] = pair;
                return;
            }

            for (int i = 0; i < 6; i++) {
                int[] coptPair = pair.clone();
                coptPair[cnt] = i;
                setPairs(cnt+1,coptPair);
            }
        }

        public void dfs(int num, int cnt){
            if(cnt == halfN){
                // A 점수
                int[] A = new int[caseSize];
                // B 점수
                int[] B = new int[caseSize];
                for (int i = 0; i < caseSize; i++) {
                    int[] pair = pairs[i];
                    int a = 0; int b = 0;
                    for (int k = 0; k < n; k++) {
                        if(selected[k]) A[i] += dice[k][pair[a++]];
                        else B[i] += dice[k][pair[b++]];
                    }
                }

                Arrays.sort(A);
                Arrays.sort(B);

                // A 이긴 횟수 누적합
                int[] winA = new int[caseSize];
                // A 이긴 횟수 저장
                int a = 0; int b = 0;
                while(a < caseSize && b < caseSize){
                    if(A[a] > B[b]){
                        winA[a]++;
                        b++;
                    }else {
                        a++;
                    }
                }

                // 누적합 계산
                int sumA = 0;
                for (int i = 0; i < caseSize; i++) {
                    sumA += winA[i] * (caseSize - i);
                }

                if(maxWin < sumA){
                    maxWin = sumA;
                    int j = 0;
                    for (int i = 0; i < n; i++) {
                        if(selected[i]) answer[j++] = (i+1);
                    }
                }

                return;
            }

            for (int i = num+1; i < n; i++) {
                selected[i] = true;
                dfs(i, cnt+1);
                selected[i] = false;
            }
        }

        public int[] solution(int[][] _dice) {
            dice = _dice;
            n = dice.length;
            selected = new boolean[n];
            halfN = n/2;
            answer = new int[halfN];
            caseSize = (int)Math.pow(6, halfN);

            pairIdx = 0;
            pairs = new int[caseSize][halfN];
            setPairs(0, new int[halfN]);

            maxWin = 0;
            dfs(-1,0);

            return answer;
        }
    }

    public static void main(String[] args) {
    }
}