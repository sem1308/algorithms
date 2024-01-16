package algorithm.programmers;

import java.util.*;

public class Kakao_2020_5 {

    public static void main(String[] args) {
    }
    class Solution {

        boolean[] visited;
        boolean flag = false;

        class Node{
            int num;
            List<Node> children;
            Queue<Node> linked;
            boolean isComplete;

            public Node(int num){
                this.num = num;
                this.children = new ArrayList<>();
                this.linked = new LinkedList<>();
                this.isComplete = false;
            }
        }

        public void dfs(Node node){
            if(flag) return;

            visited[node.num] = true;
            for(Node child : node.children){
                if(!visited[child.num]) dfs(child);
                else if(!child.isComplete){
                    flag = true;
                    break;
                }
            }
            node.isComplete = true;
        }

        public boolean solution(int n, int[][] path, int[][] order) {
            Node[] nodes = new Node[n];
            visited = new boolean[n];

            for(int i=0; i<n; i++) nodes[i] = new Node(i);
            Node root = nodes[0];

            for(int[] p : path){
                int a = p[0];
                int b = p[1];
                Node nodeA = nodes[a];
                Node nodeB = nodes[b];
                nodeA.linked.add(nodeB);
                nodeB.linked.add(nodeA);
            }

            boolean[] v = new boolean[n];
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            v[0] = true;

            while(!q.isEmpty()){
                Node cur = q.poll();

                while(!cur.linked.isEmpty()){
                    Node link = cur.linked.poll();
                    if (v[link.num]) continue;
                    v[link.num] = true;
                    q.add(link);
                    cur.children.add(link);
                }
            }

            for(int[] o : order){
                int a = o[0];
                int b = o[1];
                nodes[a].children.add(nodes[b]);
            }

            dfs(root);
            return !flag;
        }
    }
}