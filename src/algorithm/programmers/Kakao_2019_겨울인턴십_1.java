package algorithm.programmers;

import java.util.*;

public class Kakao_2019_겨울인턴십_1 {

    public static void main(String[] args) {
    }
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            Stack<Integer> basket = new Stack<>();

            int n = board.length;
            Stack<Integer>[] newBoard = new Stack[n];

            for (int i = 0; i < n; i++) {
                newBoard[i] = new Stack<>();
                for (int j = 0; j < n; j++) {
                    newBoard[i].add(board[j][i]);
                }
            }

            for(int move : moves){
                if(!newBoard[move].isEmpty()){
                    Integer item = newBoard[move].pop();
                    Integer basketItem = basket.peek();
                    if(basketItem.equals(item)){
                        basket.pop();
                        answer += 2;
                    }else{
                        basket.add(item);
                    }
                }
            }

            return answer;
        }
    }
}