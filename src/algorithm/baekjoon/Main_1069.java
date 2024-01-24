package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        int X,Y,D,T;
        
        X = Integer.parseInt(tokenizer.nextToken());
        Y = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken());
        T = Integer.parseInt(tokenizer.nextToken());
        
        /*
			1. 걸어서 갈 수 있는 시간(거리) (dist) 구함
			2. 점프를 n번 해서 갈 수 있는 최소 거리 중 최솟값 구함
			    - n*D >= dist --> n*T
			    - n*D < dist --> n*T + (dist - n*D)
			       - 최대 n = dist / D
        */
        
        double dist = Math.sqrt(Math.pow(X, 2)+Math.pow(Y, 2));

        int n = (int)(dist / D);
        
        double t1, t2;
        if(n == 0) {
            t1 = 2*T;
            t2 = T + D - dist;
        }else {
            t1 = (n+1)*T;
            t2 = n*(T-D) + dist;
        }
        
        double answer = Math.min(dist, Math.min(t1,t2));
        
        System.out.println(answer);
    }
}