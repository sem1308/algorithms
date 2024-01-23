package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int answer = 0;
        int MAX_LOC = 100000;

        int[] dists = new int[MAX_LOC+1];
        for (int i = 0; i < dists.length; i++) {
        	dists[i] = MAX_LOC;
		}

        if(N < K){
            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{N,0});
            dists[N] = 0;

            while(!q.isEmpty()){
                int[] info = q.poll();
                int idx = info[0];
                int cnt = info[1];

                if(idx == K){
                    answer = cnt;
                    break;
                }                
                
                int ncnt = cnt+1;
                
                int rightIdx = idx+1;
                if(rightIdx <= MAX_LOC && dists[rightIdx] == MAX_LOC) {
                	dists[rightIdx] = ncnt;
                	q.add(new int[]{rightIdx,ncnt});
                } 

                int leftIdx = idx-1;
                if(leftIdx >= 0 && dists[leftIdx] == MAX_LOC) {
                	dists[leftIdx] = ncnt;
                	q.add(new int[]{leftIdx,ncnt});
                }

                int teleportIdx = idx * 2;
                if(teleportIdx <= MAX_LOC && dists[teleportIdx] > cnt) {
                	dists[teleportIdx] = cnt;
                	q.addFirst(new int[]{teleportIdx,cnt});
                }
            }
        }else{
            answer = N - K;
        }

        System.out.println(answer);
    }
}