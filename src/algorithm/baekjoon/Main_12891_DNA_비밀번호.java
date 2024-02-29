package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA_비밀번호 {	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		
		int lenS = Integer.parseInt(tokens.nextToken());
		int lenP = Integer.parseInt(tokens.nextToken());
		
		char[] S = (br.readLine()+" ").toCharArray();
		
		int[] condsIdxs = {'A','C','G','T'}; // ���� ���ĺ�
		int[] conds = new int[4]; // ����

		tokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < conds.length; i++) {
			conds[i] = Integer.parseInt(tokens.nextToken());
		}		
		
		// ���ĺ� ���� ���� �迭
		int[] numAlpha = new int['T'+1];
		
		// ó�� �κй��ڿ��� �� ���ĺ� ���� ����
		for (int i = 0; i < lenP; i++) numAlpha[S[i]]++;
		
		int answer = 0;
		int limit = lenS-lenP;
		for (int i = 0; i <= limit; i++) {
			boolean isValid = true;
			for (int k = 0; k < conds.length; k++) {
				if(conds[k] > numAlpha[condsIdxs[k]]) {
					isValid = false;
					break;
				}
			}
			
			if(isValid) answer++;
			
            numAlpha[S[i]]--;
            numAlpha[S[i+lenP]]++;
		}
		
		System.out.println(answer);
	}
}
