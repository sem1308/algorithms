package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1943_동전_분배{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] nums = new int[N];
			int[] cnts = new int[N];
			
			int sum = 0;
			for (int j = 0; j < N; j++) {
				StringTokenizer tokens = new StringTokenizer(br.readLine());
				
				nums[i] = Integer.parseInt(tokens.nextToken());
				cnts[i] = Integer.parseInt(tokens.nextToken());				
				sum += nums[i] * cnts[i];
			}

			/*
			 * �� ���� ���忡�� ����
			 * A, B�� ������ �����شٸ�
			 * A�� ���ؼ��� ����
			 * 
			 * A�� �� ������ ������ ���� �Ȱ��� �� ���� ����
			 * 
			 * A�� ��� ���� ���� ������ ������ �� �ִ��� Ȯ��
			 * 
			 * i��° ���� ��ȣ�� nums[i], ������ cnts[i]�� �ϸ�
			 * 
			 * dp[k] = N���� ������� k���� ���� �� �ִ���?
			 * 
			 * 10��,
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			
			
		}

	}
}
