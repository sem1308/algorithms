package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());

		// 분할정복
		// 한 변의 길이 = 2^N

		int len = (int)Math.pow(2,N-1);
		int answer = 0;
		while(len >= 1) {
			
			int rq = r / len; // r을 4개의 정사각형의 한 변의 길이로 나누었을 때 몫
			int cq = c / len; // c를 4개의 정사각형의 한 변의 길이로 나누었을 때 몫
			
			r -= rq*len;
			c -= cq*len;
			
			if(rq == 0 && cq == 1) {
				// 위 오른쪽
				answer += len*len;
			}else if(rq == 1 && cq == 0) {
				// 아래 왼쪽
				answer += len*len*2;
			}else if(rq == 1 && cq == 1){
				// 아래 오른쪽
				answer += len*len*3;
			}
			len /= 2;			
		}
		
		System.out.println(answer);

	}
}
