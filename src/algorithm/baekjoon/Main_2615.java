package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615 {
	
	public static void main(String[] args) throws Exception {
		/*
		 * 승부 결정 X -> 0
		 * 승부 결정 O
		 * 	검은색 이김  -> 1
		 * 	흰색 이김   -> 2
		 *	이긴 돌의 5알 중 가장 왼쪽의 가로줄, 세로줄 번호 출력
		 *
		 *  ==== 로직 ====
		 *  1. 맨 왼쪽 위부터 loop
		 *  2. 현재 위치에 해당하는 값이 검은색(1)이나 흰색(2)이라면
		 *		1) 왼쪽 아래(1,-1), 오른쪽(0,1), 오른쪽 아래(1,1), 아래(1,0) 순서로 같은 색 있는지 확인
		 *			- 가장 왼쪽에 있는 좌표 출력을 위함
		 *		2) 만약 현재 위치에 대한 방향 검색이 미리 check되어있다면 continue
		 *		3) 그렇지 않으면 방향을 따라 가며 인접한 같은 색이 몇 개 있는지 확인
		 *		4) 만약 5개라면 출력 후 return
		 *		5) 그렇지 않으면 다음 칸으로 이동후 다시 2번으로 
		 */	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 범위 밖 검사를 피하기 위해 padding
		int[][] map = new int[21][21];
		
		// 바둑판 정보 저장
		for (int i = 1; i <= 19; i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		// 왼쪽 아래(1,-1), 오른쪽(0,1), 오른쪽 아래(1,1), 아래(1,0) 방향 저장
		int[][] dirs = {{1,-1},{0,1},{1,1},{1,0}};

		// 좌표당 방향 체크가 되었었는지 확인하는 논리 배열
		boolean[][][] checked = new boolean[21][21][dirs.length];
		
		// (1,1) ~ (19,19)까지 loop
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				int color = map[i][j];
				if(color == 0) continue;
				// 왼쪽 아래(1,-1), 오른쪽(0,1), 오른쪽 아래(1,1), 아래(1,0) 순서로 같은 색 있는지 확인
				for (int k = 0; k < dirs.length; k++) {
					// 만약 현재 위치에 대한 방향 검색이 미리 check되어있다면 continue
					if(checked[i][j][k])continue;
					checked[i][j][k] = true;
					int sum = 1;
					int[] dir = dirs[k];	
					int ni = i+dir[0];
					int nj = j+dir[1];
					// 방향을 따라 가며 인접한 같은 색이 몇 개 있는지 확인
					while(map[ni][nj] == color) {
						checked[ni][nj][k] = true;
						sum++;
						ni += dir[0];
						nj += dir[1];
					}
					// 만약 5개라면 출력 후 return
					if(sum == 5) {
						System.out.println(color);
                        if(k == 0) System.out.println((ni-dir[0])+" "+(nj-dir[1]));
                        else System.out.println(i+" "+j);
						return;
					}
				}
			}
		}
		// 승부가 나지 않은 경우 0 출력
		System.out.println(0);
	}
}