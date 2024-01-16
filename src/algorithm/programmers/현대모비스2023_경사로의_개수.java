package algorithm.programmers;

import java.util.ArrayList;

class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int n;
    int m;
    boolean[][][][] se;
    int sx, sy;
    boolean flag;
    public void dfs(int x, int y, int[][] grid, int[] d, int cnt) {
        if (d.length == cnt) {
            se[sx][sy][x][y] = true;
            flag = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];

            if(nx < 0 || nx == n || ny < 0 || ny == m || (grid[nx][ny] - grid[x][y]) != d[cnt]) continue;

            dfs(nx, ny, grid, d, cnt + 1);
        }
    }
    public int solution(int[][] grid, int[] d, int k) {
        int answer = 0;
        n = grid.length;
        m = grid[0].length;

        boolean[][] isS = new boolean[n][m];

        // 시작, 끝 구하기
        se = new boolean[n][m][n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag = false;
                sx = i;
                sy = j;
                dfs(sx, sy, grid, d, 0);
                if(!flag) isS[sx][sy] = true;
            }
        }

        int p = (int)Math.pow(10, 9) + 7;

        return answer;
    }
}

public class 현대모비스2023_경사로의_개수 {

    public static void main(String[] args) {
    }
}