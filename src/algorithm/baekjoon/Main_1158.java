package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());

        /*
         * 1 ~ N번 사람이 원을 이루며 앉아 있음
         * K번째 사람 제거
         * 제거된 순서 구하기 
         * 
         * 1 2 3 4 5 6 7
         * (0-1 +3) % 7
         * 2 % 7 = 2
         * 1 2 4 5 6 7
         * (2-1 +3) % 6
         * 4 % 6 = 4
         * 1 2 4 5 7
         * (4-1 + 3) % 5
         * 6 % 5 = 1
         * 1 4 5 7
         * (1-1 + 3) % 4
         * 3 % 4 = 3
         * 1 4 5
         * (3-1 + 3) % 3
         * 5 % 3 = 2
         * 1 4
         * (2-1 + 3) % 2
         * 4 % 2 = 0
         * 4
         * 
         */
        
        // Queue 사용
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
			q.add(i);
		}
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int k = 0;
        while(q.size() > 1) {
        	int num = q.poll();
        	if(++k == K) {
        		sb.append(num).append(", ");
        		k = 0;
        	}else{
        		q.add(num);
        	}
        }
        sb.append(q.peek()).append(">");
        System.out.println(sb);
    }
}