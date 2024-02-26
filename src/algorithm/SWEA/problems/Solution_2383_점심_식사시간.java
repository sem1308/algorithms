package algorithm.SWEA.problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2383_점심_식사시간
{
	static class Coord{
		int x,y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static Coord[] stairCoords;
	static Stack<Coord> stair0 = new Stack<>();
	static Stack<Coord> stair1 = new Stack<>();
	static Coord[] people;
	static int numPerson;
	
	public static void subset(int cnt) {
		if(cnt == numPerson) {
			
			return;
		}
		
		// 계단 1 선택
		stair0.add(people[cnt]);
		subset(cnt+1);
		stair0.pop();
		// 계단 2 선택
		stair1.add(people[cnt]);
		subset(cnt+1);
		stair1.pop();
	}
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
        
        /*
         * N * N 크기의 정사각형 모양의 방에 사람들이 않아 있음
         * 
         * P : 사람
         * S : 계단 입구
         * 
         * 각 사람마다 2개의 계단 중 1개로 간다고 생각
         * 
         * 사람 수가 최대 10이므로
         * 2^10의 경우 -> 가능 !!
         * 
         * 
         * 
         * 
         */
        
        StringTokenizer tokens;
        
        int stairIdx = 0;
        for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			people = new Coord[N*N];
			stairCoords = new Coord[2];
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(tokens.nextToken());
					if(num == 1) {
						people[numPerson++] = new Coord(i,j);
					}else if(num >= 2) {
						stairCoords[stairIdx++] = new Coord(i,j);
					}
				}
			}
        	
        	
			
			
			
		}

    }
}