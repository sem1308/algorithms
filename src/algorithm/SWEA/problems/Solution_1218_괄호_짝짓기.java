package algorithm.SWEA.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution_1218_괄호_짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokens;
		
		int T = 10;

		StringBuilder sb = new StringBuilder();

		Stack<Character>[] stacks = new Stack[4];
		
		for (int i = 0; i < stacks.length; i++) {
			stacks[i] = new Stack<>();
		}
		
		for (int t = 1; t <= T; t++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			boolean isValid = true;

			Stack<Character> stack = null;
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				boolean isOpen = false;
				switch(c) {
					case '(':
						isOpen = true;
						stack = stacks[0];
						break;
					case ')': 
						stack = stacks[0];
						break;
					case '[':
						isOpen = true;
						stack = stacks[1];
						break;
					case ']':
						stack = stacks[1];
						break;
					case '{':
						isOpen = true;
						stack = stacks[2];
						break;
					case '}':
						stack = stacks[2];
						break;
					case '<':
						isOpen = true;
						stack = stacks[3];
						break;
					case '>':
						stack = stacks[3];
						break;
				}
				
				if(isOpen) {
					// 지금 온게 여는 거라면
					stack.push(c);
				} else {
					// 지금 온게 닫는 거라면
					if(!stack.empty()) {
						stack.pop();
					}else {
						break;
					}
				}
			}
			for (int i = 0; i < stacks.length; i++) {
				if(!stacks[i].isEmpty()) {
					isValid = false;
				}
				stacks[i].clear();
			}
			
			sb.append("#").append(t).append(" ").append(isValid ? "1" : "0").append("\n");
		}
		System.out.print(sb.toString());
	}
}
