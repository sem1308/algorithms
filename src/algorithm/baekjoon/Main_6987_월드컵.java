package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6987_월드컵{

	static class Info implements Comparable<Info>{
		int idx;
		int num;
		public Info(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
		@Override
		public int compareTo(Info o) {
			return o.num - this.num;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 총 6C2 = 15번의 경기, 승, 무, 패 3가지
		 * 3^15 경우의 수라 완전탐색 불가
		 * 
		 * 1. 승 = 패
		 * 2. (승+패+무)/2  = 15
		 * 3. 팀당 승+무+패 = 5
		 * 4. 무승부 합은 짝수
		 * 5. 가능한 무승부 경우의 수 찾기
		 * 6. 가능한 승패 경우의 수 찾기
		 * 
		 * 
		 * 222255
		 * 111140
		 * 
		 * 
		 * 112222
		 * 002220
		 * 001100
		 * 
		 * 
		 * 000000
		 * 
		 * 
		 * 012345
		 * 012345
		 * 
		 * 011344
		 * 002335
		 * 
		 * 011340
		 * 001224
		 * 		 
		 * 011300
		 * 000113		
		 * 
		 *  
		 *  
		 *  
		 */
		
		int[] draws = new int[6];
		Info[] wins = new Info[6];
		Info[] loses = new Info[6];
		for (int i = 0; i < 4; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			boolean isValid = true;
			int numWin = 0;
			int numLose = 0;
			int numDraws = 0;
			for (int j = 0; j < 6; j++) {
				int win = Integer.parseInt(tokens.nextToken());
				int draw = Integer.parseInt(tokens.nextToken());
				int lose = Integer.parseInt(tokens.nextToken());
				
				draws[j] = draw;
				wins[j] = new Info(j,win);
				loses[j] = new  Info(j,lose);

				numWin += win;
				numLose += lose;
				numDraws += draw;
				
				if(win+draw+lose != 5) {
					isValid = false;
					break;
				}
			}
			
			if(numWin != numLose || (numWin+numLose+numDraws) != 30 || numDraws % 2 != 0 || !isValid) {
				System.out.println(0);
				continue;
			}
			
			Arrays.sort(draws);
			Arrays.sort(wins);
			Arrays.sort(loses);
			
			for (int j = 5; j >= 0; j--) {				
				for(int k=0; k<j; k++) {
					if(draws[j]==0) break;
					if(draws[k] > 0) {
						draws[k]--;
						draws[j]--;
					}
				}
				if(draws[j]!=0) {
					isValid = false;
					break;
				}
			}
			
			if(isValid) {
				for (int j = 0; j < 6; j++) {		
					Arrays.sort(loses);	

					for(int k=0; k<6; k++) {
						if(wins[j].num==0) break;
						if(loses[k].idx == wins[j].idx) continue;
						if(loses[k].num > 0) {
							loses[k].num--;
							wins[j].num--;
						}
					}

					if(wins[j].num!=0) {
						isValid = false;
						break;
					}
				}
			}
			
			System.out.println(isValid ? 1 : 0);
		}

	}
}
