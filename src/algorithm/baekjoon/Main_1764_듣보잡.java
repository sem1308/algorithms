package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1764_듣보잡{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());

		
		
		Set<String> set = new HashSet<>();
		List<String> people = new ArrayList<>();
		for (int i = 0; i < N+M; i++) {
			String person = br.readLine();
			if(set.contains(person)) {
				people.add(person);
			}else {
				set.add(person);
			}
		}
		
		Collections.sort(people);
		
		StringBuilder sb = new StringBuilder();
		
		for(String person : people) {
			sb.append(person).append("\n");
		}
		
		System.out.println(people.size());
		System.out.println(sb);
	}

}
