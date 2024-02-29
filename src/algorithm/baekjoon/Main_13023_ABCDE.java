package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
	
	static int N,M;
	static List<Integer>[] link;
	static boolean[] visited;
	
	public static boolean dfs(int idx, int cnt) {
		if(cnt == 5) {
			return true;
		}
		
		for (int l : link[idx]) {
			if(visited[l]) continue;
			visited[l] = true;
			if(dfs(l,cnt+1)) return true;
			visited[l] = false;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		link = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			link[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			link[a].add(b);
			link[b].add(a);
		}
		
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			if(dfs(i,1)) {
				System.out.println("1");
				return;
			}
			visited[i] = false;
		}
		System.out.println("0");
	}
}
