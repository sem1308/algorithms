package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_17281_야구{
	
	static int N;
	static int answer = 0;

	static int[][] actions;
	
	static boolean[] selected;
	static int[] order;
	
	public static void play() {
		// 0 : 아웃
		// 1 : 안타
		// 2 : 2루타
		// 3 : 3루타
		// 4 : 홈련
		
		int totalScore = 0;

		int[] numOnBase = new int[5]; // 1,2,3,홈 베이스에 주자 있는지 (몇명 - 홈 베이스를 위함)
		
		int player = 0;
		for (int i = 0; i < N; i++) {
			int outCnt = 0;
			
			Arrays.fill(numOnBase, 0);
			
			int[] curActions = actions[i];
			
			while(outCnt != 3) {
				int action = curActions[order[player]];
				if(action == 0) {
					outCnt++;
				}else {
					for (int base = 3; base >= 1; base--) {
						if(numOnBase[base] == 0) continue;
						numOnBase[Math.min(4,base+action)]++;
						numOnBase[base] = 0;
					}
					numOnBase[action]++;
				}
				player = (player+1) % 9;
			}
			
			totalScore += numOnBase[4];
		}
		// 홈에 주자가 있으면 점수 추가
		answer = Math.max(answer, totalScore);
	}
	
	public static void permutation(int idx) {
		if(idx == 9) {
			play();
			return;
		}
		
		if(idx == 3) {
			permutation(idx+1);
		}else {
			for (int i = 0; i < 9; i++) {
				if(selected[i]) continue;
				selected[i] = true;
				order[idx] = i;
				permutation(idx+1);
				selected[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		StringTokenizer tokens;
		
		actions = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				actions[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		selected = new boolean[9];
		order = new int[9];

		selected[0] = true;
		order[3] = 0;
		permutation(0);
		
		System.out.println(answer);
	}

}
