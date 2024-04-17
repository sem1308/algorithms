package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class Kakao_2017_카카오코드_본선_GPS {

    public static void main(String[] args) {
    }
    class Solution {
        int answer;
        int n,m,k;
        int[] gps_log;

        List<Integer>[] adjList;

        public void dfs(int idx, int t, int changeCnt){
            if(changeCnt >= answer) return;

            if(t == k-1){
                if(idx == gps_log[k-1]){
                    answer = changeCnt;
                }
                return;
            }

            if(idx != gps_log[t]) changeCnt++;

            for (int i : adjList[idx]) {
                dfs(i, t+1, changeCnt);
            }
        }

        public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
            /*
                n : 거점 개수 <= 200
                m : 도로 개수 <= 10,000
                edge_list : 연결된 도로 정보
                k : 거점 정보 총 개수 <= 100
                gps_log : 거점 정보

                현재 위치와 다르면 거점 변경 개수 증가하고 그렇지 않으면 변경 개수 그대로



            */
            this.n = n;
            this.m = m;
            this.k = k;
            this.gps_log = gps_log;

            adjList = new ArrayList[n+1];

            for (int i = 1; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int[] edge = edge_list[i];
                int a = edge[0];
                int b = edge[1];
                adjList[a].add(b);
                adjList[b].add(a);
            }

            answer = Integer.MAX_VALUE;

            dfs(gps_log[0], 0, 0);

            return answer;
        }
    }
}