package algorithm.SWEA.top;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2
{
    static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    static int numDot = 0;
    static int answer = 0;

    public static void dfs(int x, int y, char[][] map, int N, boolean isFirst){
        int sum = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || nx == N || ny < 0 || ny == N || !(map[nx][ny] == '*')) continue;
            sum++;
        }
        if(!isFirst){
            numDot--;
            map[x][y] = (char)(sum +'0');
        }
        if(sum == 0){
            if(isFirst){
                answer++;
                numDot--;
                map[x][y] = '0';
            }
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || nx == N || ny < 0 || ny == N || !(map[nx][ny] == '.')) continue;
                dfs(nx, ny, map, N, false);
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            numDot = 0;

            int N = sc.nextInt();
            char[][] map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j]=='.') numDot++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.'){
                        dfs(i, j, map, N, true);
                    }
                }
            }

            answer += numDot;
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
