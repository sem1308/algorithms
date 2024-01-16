package algorithm.programmers;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] roads = {{1, 2, 2},{1, 2, 2}, {3, 2, 3}};
        int[] traps = {2};
        System.out.println(solution(3,1,3,roads,traps));

        roads = new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        traps = new int[]{2,3};
        System.out.println(solution(4,1,4,roads,traps));

        roads = new int[][]{{1, 2, 1}, {2, 3, 1}, {3, 2, 1}, {3, 5, 1}, {1, 5, 10}};
        traps = new int[]{2,3};
        System.out.println(solution(5,1,5,roads,traps));
    }

    public static class Graph implements Comparable<Graph>{
        Integer current;
        boolean[] trapped;
        int[] visited;
        Integer totalCost;

        public Graph(Integer current, boolean[] trapped, int[] visited, Integer totalCost) {
            this.current = current;
            this.trapped = trapped;
            this.visited = visited;
            this.totalCost = totalCost;
        }

        @Override
        public int compareTo(Graph other) {
            return Integer.compare(this.totalCost, other.totalCost);
        }
    }

    public static void printDir(Boolean[][] dir, boolean[] trapped, int n){
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(dir[i][j] != null && dir[i][j] ^ trapped[i] ^ trapped[j] ||
                        dir[j][i] != null && !dir[j][i] ^ trapped[i] ^ trapped[j]) System.out.print(i+"->"+j+", ");
            }
            System.out.println();
        }
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        System.out.println("=========");
        int answer = 0;
        Set<Integer>[] map = new Set[n+1];
        Integer[][] cost = new Integer[n+1][n+1];
        Boolean[][] dir = new Boolean[n+1][n+1];

        // 각 배열 요소를 초기화
        for (int i = 0; i < n+1; i++) {
            map[i] = new HashSet<>(); // 각 요소를 빈 ArrayList로 초기화
        }

        for (int[] road : roads) {
            int P = road[0], Q = road[1], S = road[2];
            map[P].add(Q);
            map[Q].add(P);
            if(cost[P][Q] == null){
                dir[P][Q] = true;
                cost[P][Q] = S;
            } else cost[P][Q] = cost[P][Q] < S ? cost[P][Q] : S;
        }

        PriorityQueue<Graph> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Graph(start,new boolean[n+1],new int[n+1],0));

        while(!priorityQueue.isEmpty()){
            Graph graph = priorityQueue.poll();
            Integer current = graph.current;
            boolean[] trapped = graph.trapped;
            int[] visited = graph.visited;
            // 현재 있는 곳이 도착점인지
            if(current == end){
                answer = graph.totalCost;
                break;
            }
            visited[current] += 1;
            if(visited[current] > 2) continue;
            // 현재 있는 곳이 함정인지
            if(Arrays.stream(traps).anyMatch(current::equals)) trapped[current] = !trapped[current];
            // 다음으로 갈 수 있는 곳 queue에 넣음
            for(int to : map[current]){
                if(dir[current][to] != null && dir[current][to] ^ trapped[current] ^ trapped[to]){
                    int nextCost = cost[current][to] != null ? graph.totalCost + cost[current][to] : graph.totalCost + cost[to][current];
                    priorityQueue.add(new Graph(to,trapped.clone(),visited.clone(),nextCost));
                }else if(dir[to][current] != null && !dir[to][current] ^ trapped[current] ^ trapped[to]){
                    int nextCost = cost[to][current] != null ? graph.totalCost + cost[to][current] : graph.totalCost + cost[current][to];
                    priorityQueue.add(new Graph(to,trapped.clone(),visited.clone(),nextCost));
                }
            }
        }

        return answer;
    }
}