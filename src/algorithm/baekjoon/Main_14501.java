package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501 {

    static int[][] TP;
    static int N;
    static int answer=0;

    public static void dfs(int i, int curP, int requestP){
        if(i >= N) {
            curP = i==N ? curP + requestP : curP;
            answer = Math.max(answer,curP);
            return;
        }
        curP+=requestP;
        dfs(i+1,curP,0);
        dfs(i+TP[i][0],curP,TP[i][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());

        TP = new int[N][2];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(tokenizer.nextToken());
            int P = Integer.parseInt(tokenizer.nextToken());
            TP[i] = new int[]{T,P};
        }

        dfs(0,0,0);

        System.out.println(answer);
    }
}