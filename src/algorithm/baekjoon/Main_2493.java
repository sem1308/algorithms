package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower{
	int num;
	int height;
	
	public Tower(int num, int height) {
		this.num = num;
		this.height = height;
	}
}

public class Main_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
         * 6 9 5 7 4
         * 
         * 레이저 왼쪽으로
         * 1. 앞에서 부터 stack에 쌓음
         * 2. 만약 stack의 맨 위에 있는 것이 자신의 높이보다 작다면 맨 위에걸 pop
         * 3. 그렇지 않으면 자신의 정답 index에 그 tower의 index 저장한 후 push
         * 
         * 1) 6			[0,0,0,0,0]
         * 2) 9			[0,0,0,0,0]
         * 3) 9 5		[0,0,2,0,0] 
         * 4) 9 7		[0,0,2,2,0]
         * 5) 9 7 4 	[0,0,2,2,4]
         */

        StringTokenizer tokens = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        Stack<Tower> stack = new Stack<>();
        stack.add(new Tower(0,Integer.MAX_VALUE));
        for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(tokens.nextToken());
			
			while(stack.peek().height < height) {
				stack.pop();
			}
			
			sb.append(stack.peek().num).append(" ");
			stack.add(new Tower(i+1,height));
		}
        
        System.out.println(sb);
    }
}