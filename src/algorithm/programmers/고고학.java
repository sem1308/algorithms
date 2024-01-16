package algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 고고학 {


    class Solution {
        int n;
        int answer;
        int[][] counts;
        int[][][][] neighbors;
        public void dfs(int[][] count, int[][] clockHands, boolean[][] visited){

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // i,j를 눌렀을 때
                    if(visited[i][j]) continue;
                    visited[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        boolean flag = false;
                        for (int l = 0; l < counts[i][j]-1; l++) {
                            int x = neighbors[i][j][l][0];
                            int y = neighbors[i][j][l][1];
                            if (count[x][y] == 1 && (clockHands[x][y] + k) % 4 != 0) {
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            for (int l = 0; l < counts[i][j]-1; l++) {
                                int x = neighbors[i][j][l][0];
                                int y = neighbors[i][j][l][1];
                                clockHands[x][y] = (clockHands[x][y] + k) % 4;
                            }
                            dfs(count,clockHands,visited);
                        }
                    }
                    visited[i][j] = false;
                }
            }
        }

        public int solution(int[][] clockHands) {
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            answer = 0;

            n = clockHands.length;

            counts = new int[n][n];
            neighbors = new int[n][n][4][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dirs[k][0];
                        int nj = j + dirs[k][1];
                        if(ni < 0 || ni == n || nj < 0 || nj == n) continue;
                        neighbors[i][j][cnt++] = new int[]{ni, nj};
                    }
                    counts[i][j] = cnt+1;
                }
            }

            boolean[][] visited = new boolean[n][n];
            dfs(counts.clone(),clockHands,visited);

            return answer;
        }
    }

    public static void main(String[] args) {
    }
}