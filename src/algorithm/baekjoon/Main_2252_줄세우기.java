package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기{

	public static void addNums(Queue<Integer> q, int[] degrees, int N) {
		for (int i = 1; i <= N; i++) {
			if(degrees[i] == 0) {
				q.add(i);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		int[] degrees = new int[N+1];
		List<Integer>[] students = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			students[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());

			students[A].add(B);
			degrees[B]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new ArrayDeque<>();
		
		while(true) {
			addNums(q,degrees,N);
			if(q.isEmpty()) break;
			while(!q.isEmpty()) {
				int num = q.poll();
				sb.append(num).append(" ");
				
				degrees[num]--;
				
				for (int s : students[num]) {
					degrees[s]--;
				}
			}
		}
		
		System.out.println(sb);
	}
}
