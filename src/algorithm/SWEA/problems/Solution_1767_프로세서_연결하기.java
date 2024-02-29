package algorithm.SWEA.problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
class Solution_1767_프로세서_연결하기
{
    public static int[][] map;
    public static int[][] cell;
    public static int N;
    public static int answer;
    public static int maxCell;
    public static int curMaxCell;
    public static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
     
    public static void dfs(int c, int total, int count){
        if(count > curMaxCell){
            answer = total;
            curMaxCell = count;
        }else if(count == curMaxCell){
            answer = answer > total ? total : answer;
        }
        
        if(c == maxCell || (count + (maxCell - c) < curMaxCell)) return;
         
        int x = cell[c][0];
        int y = cell[c][1];
        
        int lineNum = 2+c;
        for(int i=0; i<4; i++){
            boolean isValid = true;
            int nx = x;
            int ny = y;
            int len = 0;
            nx += dirs[i][0];
            ny += dirs[i][1];
            while(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(map[nx][ny] != 0) {
                	isValid = false;
                    break;
                }
                map[nx][ny] = lineNum;
                nx += dirs[i][0];
                ny += dirs[i][1];
                len++;
            }
            if(isValid) dfs(c+1,total+len,count+1);
            nx -= dirs[i][0];
            ny -= dirs[i][1];
            while(map[nx][ny] == lineNum){
                map[nx][ny] = 0;
                nx -= dirs[i][0];
                ny -= dirs[i][1];
            }
            if(!isValid) dfs(c+1,total,count);
        }
    }
     
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        
        StringTokenizer tokens;

        cell = new int[12][2];
        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N]; 
            maxCell=0;
            curMaxCell = 0;
            for(int i=0; i<N; i++){
            	tokens = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                    if(map[i][j]==1 &&  i !=0 && i != N-1 && j !=0 && j != N-1 ) cell[maxCell++] = new int[]{i,j};
                }
            }
             
            dfs(0,0,0);
             
            System.out.println("#"+test_case+" "+answer);
        }
    }
}