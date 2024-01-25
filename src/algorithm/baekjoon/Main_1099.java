package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1099 {
	
	static String sentence;
	static int N;
	static Map<String,List<String>> words;
	static int[] dp;
	static int answer = Integer.MAX_VALUE;
	
	public static void solve(int idx) {
		if(idx == sentence.length()) return;
		
        String word = "";
        for (int i = idx; i < sentence.length(); i++) {
        	char c = sentence.charAt(i);
        	int j;
			for (j = 0; j < word.length(); j++) {
				if(c < word.charAt(j)) break;
			}
			word = word.substring(0,j) + c + word.substring(j);
			if(words.containsKey(word)) {
				String curWord = sentence.substring(idx,i+1);
				int minCost = Integer.MAX_VALUE;
				for (String savedWord : words.get(word)) {
					int curCost = 0;
					for (int k = 0; k < curWord.length(); k++) {
						if(savedWord.charAt(k) != curWord.charAt(k)) curCost++;
					}
					minCost = Math.min(minCost,curCost);
				}
				if(dp[i+1] == Integer.MAX_VALUE) solve(i+1);
				if(dp[i+1] != -1) {
					dp[idx] = Math.min(dp[idx], minCost + dp[i+1]);
				}
			}
		}
        
        dp[idx] = dp[idx] == Integer.MAX_VALUE ? -1 : dp[idx];
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sentence = br.readLine();
        dp = new int[sentence.length()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[sentence.length()] = 0;

        N = Integer.parseInt(br.readLine());
        
        words = new HashMap<>();

        /*
         * 1. String to char[]
         * 2. sort
         * 3. toString 
         * 4. Map에 등록
         * 
         * 1. String 생성
         * 2. 앞에서부터 하나씩 정렬해서 넣음 
         * 3. 일치하는 단어가 있으면
         * 	  3.1) 최소 비용으로 만들 수 있는 단어 선택
         *    	   - 다시 1번으로
         *    3.2) 단어 선택하지 않고 넘어가기
         */
        
        for (int i = 0; i < N; i++) {
        	String str = br.readLine();
        	char[] strArr = str.toCharArray();
        	Arrays.sort(strArr);
        	String sortedStr = String.copyValueOf(strArr);
        	List<String> list = words.getOrDefault(sortedStr, new ArrayList<>());
        	list.add(str);
        	words.put(sortedStr, list);
		}
        
        solve(0);
        
        System.out.println(dp[0]);
    }
}