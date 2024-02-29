package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11286_절댓값_힙 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			if(absA == absB) {
				return a - b;
			}
			return absA - absB;
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int op = Integer.parseInt(br.readLine());
			if(op != 0) {
				pq.offer(op);				
			}else {
				if(pq.isEmpty()) sb.append("0");
				else sb.append(pq.poll());
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}
