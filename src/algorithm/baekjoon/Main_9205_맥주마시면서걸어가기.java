package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_9205_맥주마시면서걸어가기{
	
	public static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 맥주 한 박스에 20개
		 * 
		 * 50미터에 1병
		 * 
		 * 편의점 -> 빈 병 버리고 새 백주 병 사기
		 * 
		 * 한 박스에 1000미터 가능
		 * 
		 */
		
		int T = Integer.parseInt(br.readLine());
		
		int[] x = new int[102];
		int[] y = new int[102];
		boolean[] visited = new boolean[102];
	
		List<Integer>[] reachList = new List[102];
		for (int i = 0; i < reachList.length; i++) {
			reachList[i] = new ArrayList<>();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N+2; i++) {
				reachList[i].clear();
			}
			
			for (int i = 0; i < N+2; i++) {
				tokens = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(tokens.nextToken());
				y[i] = Integer.parseInt(tokens.nextToken());
				
				for (int j = 0; j < i; j++) {
					int dist = getDist(x[i],y[i],x[j],y[j]);
					if(dist <= 1000) {
						reachList[i].add(j);
						reachList[j].add(i);
					}
				}
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			
			Arrays.fill(visited, false);
			visited[0] = true;
			q.add(0);
			
			boolean isValid = false;
			while(!q.isEmpty()) {
				int num = q.poll();
				
				if(num == N+1) {
					isValid = true;
					break;
				}
				
				for (int n : reachList[num]) {
					if(!visited[n]) {
						visited[n] = true;
						q.add(n);
					}
				}
			}
			
			sb.append(isValid ? "happy\n" : "sad\n");
		}
		System.out.println(sb);
		
	}
}
