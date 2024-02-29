package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호_만들기{
	
	static int L,C;
	static char[] apbs; // 알파벳 종류
	static boolean[] isVowel; // 모음인지 아닌지
	static final char[] vowels = {'a','e','i','o','u'};
	
	static StringBuilder sb;
	
	public static void dfs(int idx, int cnt, char[] secret) {
		if(cnt == L) {	
			int numVowel = 0;
			for (char c : secret) {
				if(isVowel[c-'a']) {
					numVowel++;
				}
			}
			
			if(numVowel > 0 && (L-numVowel) >= 2) {
				sb.append(String.valueOf(secret)).append("\n");
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			secret[cnt] = apbs[i];
			dfs(i+1,cnt+1,secret);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 서로 다른 L개 알파벳 소문자
		 * 최소 한 개의 모음, 최소 두 개의 자음
		 * 
		 * 알파벳이 정렬된 상태
		 * 
		 * 알파벳 종류 C가지
		 */
		
		tokens = new StringTokenizer(br.readLine());

		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		apbs = new char[C];
		
		tokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			apbs[i] = tokens.nextToken().charAt(0);
		}
		
		Arrays.sort(apbs);
		
		isVowel = new boolean[27];
		
		for(char c : vowels) {
			isVowel[c - 'a'] = true;
		}
		
		sb = new StringBuilder();
		
		dfs(0,0,new char[L]);
		
		System.out.println(sb.toString());

	}
}
