package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11559_PuyoPuyo {
    static class Puyo{
        char c;
        boolean isBroken;

        public Puyo(char c){
            this.c = c;
        }
    }

    public static boolean isRange(int x, int y){
        return x >= 0 && x < 12 && y >= 0 && y < 6;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens;

        /*
            같은 색 뿌요 4개 이상 연결 -> 삭제
         */

        int H = 12;
        int W = 6;

        Puyo[][] map = new Puyo[H][W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = str.charAt(j);
                map[i][j] = new Puyo(c);
            }
        }

        Queue<int[]> coords = new ArrayDeque<>();
        Queue<Puyo> puyos = new ArrayDeque<>();

        boolean[][] visited = new boolean[H][W];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int cnt = 0;
        while(true){
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j].c);
                }
                System.out.println();
            }
            System.out.println();

            boolean isBroken = false;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j].c != '.' && !visited[i][j]){
                        visited[i][j] = true;
                        coords.add(new int[]{i,j});

                        while(!coords.isEmpty()){
                            int[] coord = coords.poll();
                            int x = coord[0];
                            int y = coord[1];

                            puyos.add(map[x][y]);

                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if(isRange(nx,ny) && !visited[nx][ny] && (map[nx][ny].c == map[i][j].c)){
                                    visited[nx][ny] = true;
                                    coords.add(new int[]{nx,ny});
                                }
                            }
                        }

                        if(puyos.size() >= 4){
                            isBroken = true;
                            while(!puyos.isEmpty()){
                                Puyo puyo = puyos.poll();
                                puyo.isBroken = true;
                            }
                        }else{
                            puyos.clear();
                        }
                    }
                }
            }

            if(!isBroken){
                break;
            }

            for (int i = 0; i < W; i++) {
                int top = H;
                for (int j = H-1; j >= 0; j--) {
                    // 맨 아래부터 탐색
                    if(map[j][i].c == '.')break;
                    if(!map[j][i].isBroken){
                        top--;
                        if(j != top){
                            map[top][i].c = map[j][i].c;
                            map[top][i].isBroken = false;
                            map[j][i].c = '.';
                        }
                    }else{
                        map[j][i].c = '.';
                    }
                }
            }

            for (int i = 0; i < H; i++) {
                Arrays.fill(visited[i],false);
            }

            cnt++;
        }
        System.out.println(cnt);
    }
}