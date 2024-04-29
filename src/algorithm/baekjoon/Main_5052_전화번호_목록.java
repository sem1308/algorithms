package algorithm.baekjoon;

import java.io.*;

public class Main_5052_전화번호_목록{
	
	static class Number {
		Number[] numbers;
		
		boolean isNumber;

		public Number() {
			this.numbers = new Number[10];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 한 번호가 다른 번호의 접두어인 경우가 없어야함
		 * 
		 * 번호는 길어야 10자리
		 * 
		 * 트라이
		 */
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			Number root = new Number();
			
			boolean isValid = true;
			for (int i = 0; i < n; i++) {
				String number = br.readLine();
				
				if(!isValid) continue;
				
				Number temp = root;
				
				for (int j = 0; j < number.length(); j++) {
					int num = number.charAt(j)-'0';
					
					if(temp.numbers[num] == null) {
						temp.numbers[num] = new Number();
					}else {
						if(temp.numbers[num].isNumber || j == number.length()-1) {
							isValid = false;
							break;
						}
					}
					temp = temp.numbers[num];
				}
				
				temp.isNumber = true;
			}
			
			sb.append(isValid ? "YES\n" : "NO\n");
		}
		
		System.out.println(sb);
	}
}
