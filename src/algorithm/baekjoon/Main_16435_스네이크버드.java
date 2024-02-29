package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16435_스네이크버드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, M;
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		int[] heights = new int[N];
		
		tokens = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			heights[j] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(heights);
		
		for (int j = 0; j < N; j++) {
			if(M >= heights[j]) M++;
		}
			
		System.out.println(M);
	}
}
