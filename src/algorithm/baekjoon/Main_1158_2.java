package algorithm.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken())-1;

        /*
         * 1 ~ N번 사람이 원을 이루며 앉아 있음
         * K번째 사람 제거 
         * 제거된 순서 구하기 
         * 
         * 1 2 3 4 5 6 7
         * (0-1 + 3) % 7
         * 2 % 7 = 2

         * 1 2 4 5 6 7
         * (2-1 + 3) % 6
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
         */
        
        // LinkedList 사용
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
        	list.add(i);
		}
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int k = 0;
        for (int i = 0; i < N-1; i++) {
        	k = (k+K) % list.size();
        	sb.append(list.remove(k)).append(", ");
        }
        sb.append(list.get(0)).append(">");
        System.out.println(sb);
    }
}