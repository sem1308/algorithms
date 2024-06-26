package algorithm.SWEA.problems;
import java.util.*;
import java.io.*;

public class Solution_4013_특이한자석{
	public static void rotate(int curIdx, int spinDir, int moveDir, int[][] gears, int[] topIdx) {
		if(curIdx == -1 || curIdx == 4) return;
		
		int prevIdx = curIdx-moveDir;
		int[] curGear = gears[curIdx];
		int[] prevGear = gears[prevIdx];
		
		int curCoef = moveDir == 1 ? 6 : 2;
		int prevCoef = 8 - curCoef;
		int curCheckIdx = (topIdx[curIdx]+curCoef) % 8;
		int prevCheckIdx = (topIdx[prevIdx]+prevCoef) % 8;
		
		if(curGear[curCheckIdx] != prevGear[prevCheckIdx]) {
			int nextIdx = curIdx+moveDir;
			if(nextIdx != -1 && nextIdx != 4)
				rotate(curIdx+moveDir, spinDir * -1, moveDir, gears, topIdx);
			topIdx[curIdx] = (topIdx[curIdx]-spinDir+8) % 8;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer;
        
		int T = Integer.parseInt(br.readLine());
		
        StringBuilder sb = new StringBuilder();

        int[][] gears = new int[4][8];
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());

            for (int i = 0; i < 4; i++) {
            	tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }		

            int[] topIdx = {0,0,0,0};

            for (int i = 0; i < K; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                int which = Integer.parseInt(tokenizer.nextToken())-1;
                int dir = Integer.parseInt(tokenizer.nextToken());

                // 왼쪽으로
                rotate(which-1, dir * -1, -1, gears, topIdx);

                // 오른쪽으로
                rotate(which+1, dir * -1, 1, gears, topIdx);

                topIdx[which] = (topIdx[which]-dir+8) % 8;
            }

            int answer = 0;
            int num = 1;
            for (int i = 0; i < 4; i++) {
                answer += gears[i][topIdx[i]] * num;
                num *= 2;
            }

			sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
	}

}