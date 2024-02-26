package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2457 {
	
	static class Project implements Comparable<Project>{
		int st;
		int ed;
		public Project(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}
		@Override
		public int compareTo(Project o) {
			return this.st - o.st;
		}
	}
	
	public static int monthToDay(int month) {
		switch(month) {
			case 1:
				return 0;
			case 2:
				return 31;
			case 3:
				return 59;
			case 4:
				return 90;
			case 5:
				return 120;
			case 6:
				return 151;
			case 7:
				return 181;
			case 8:
				return 212;
			case 9:
				return 243;
			case 10:
				return 273;
			case 11:
				return 304;
			case 12:
				return 334;
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * N개 프로젝트
		 * 
		 * 3월 1일 ~ 11월 30일
		 * 한 가지 이상 프로젝트 참여
		 * 
		 * 참여하는 프로젝트 수 가능한 적게
		 * 
		 * 선택한 프로젝트들의 최소 개수
		 * 
		 * 그리디
		 * 
		 * 현재 끝나는 지점보다 빠르거나 같이 시작하여 가장 늦게 끝나는 프로젝트 선택!!!
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens;
		
		PriorityQueue<Project> pq = new PriorityQueue<>();
				
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int stMonth = Integer.parseInt(tokens.nextToken());
			int stDay = Integer.parseInt(tokens.nextToken());
			int edMonth = Integer.parseInt(tokens.nextToken());
			int edDay = Integer.parseInt(tokens.nextToken());

			int st = monthToDay(stMonth) + stDay;
			int ed = monthToDay(edMonth) + edDay;
			
			pq.add(new Project(st,ed));
		}
				
		int ed = monthToDay(11)+30; // 11월 30일 까지 해야함
		
		int curEd = monthToDay(3)+1; // 3월 1일까지 시작 가능
		
		int answer = 0;
		Project curProj = null;
		while(!pq.isEmpty() && curEd <= ed) {
			curProj = null;
			int maxEd = 0;
			while(!pq.isEmpty() && pq.peek().st <= curEd) {
				Project proj = pq.poll();
				
				if(maxEd < proj.ed) {
					maxEd = proj.ed;
					curProj = proj;
				}
			}
			
			if(curProj == null) break;
			
			curEd = maxEd;
				
			answer++;
		}
		
		System.out.println(curProj == null || curEd <= ed ? 0 : answer);
	}
}
