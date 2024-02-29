package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {    
    
    static int N,M;
    // 집과 치킨집 사이 거리 저장 배열
    static int[][] dists;
    
    // 집 좌표 저장 배열
    static int[][] houseXY;
    // 치킨집 좌표 저장 배열
    static int[][] cHouseXY;

    static int numC = 0; // 치킨집 개수
    static int numH = 0; // 집 개수

    static int answer;
    
    public static void comb(int idx, int cnt, int[] dist) {
        if(cnt == M) {
            return;
        }
        
        for (int i = idx; i < numC; i++) {
            int[] copyDist = dist.clone();
            
            boolean isMin = false;
            int totalDist = 0;
            for (int j = 0; j < numH; j++) {
                if(copyDist[j] > dists[j][i]) {
                    isMin = true;
                    copyDist[j] = dists[j][i];
                }
                totalDist += copyDist[j];
            }
            if(isMin){
                answer = Math.min(answer,totalDist);
                comb(i+1,cnt+1,copyDist);
            }
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokens;
        
        /*
         * 빈 칸, 치킨집, 집
         *  0     2    1
         *  
         *  (1,1)부터 시작
         *  
         *  치킨 거리
         *  - 집과 가장 가까운 치킨집 사이의 거리
         *  - 맨허튼 거리
         *  
         *  도시의 치킨 거리 : 모든 집의 치킨 거리 합
         *  
         *  최대 M개 치킨집을 골랐을 때 도시의 치킨 거리의 최솟값 구하기
         *  
         *  치킨집 1개를 고를 때 마다 distance update
         *  
         *  
         */
        
        tokens = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        
        // 집과 치킨집 사이 거리 저장 배열
        dists = new int[2*N][13];
        
        // 집 좌표 저장 배열
        houseXY = new int[2*N][2];
        // 집 좌표 저장 배열
        cHouseXY = new int[13][2];
        
        numC = 0; // 치킨집 개수
        numH = 0; // 집 개수

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(tokens.nextToken());
                if(num == 1) {
                    // 집 좌표 저장
                    houseXY[numH][0] = i;
                    houseXY[numH][1] = j;
                    // 집과 다른 치킨집 사이 거리 저장
                    for (int k = 0; k < numC; k++) {
                        dists[numH][k] = Math.abs(i-cHouseXY[k][0]) + Math.abs(j-cHouseXY[k][1]);
                    }
                    numH++;
                }else if(num == 2) {
                    // 집 좌표 저장
                    cHouseXY[numC][0] = i;
                    cHouseXY[numC][1] = j;
                    // 치킨집과 다른 집 사이 거리 저장
                    for (int k = 0; k < numH; k++) {
                        dists[k][numC] = Math.abs(i-houseXY[k][0]) + Math.abs(j-houseXY[k][1]);
                    }
                    numC++;
                }
            }
        }
        
        answer = Integer.MAX_VALUE;

        int[] dist = new int[numH];
        Arrays.fill(dist,100);
        comb(0,0,dist);
        
        System.out.println(answer);
    }
}