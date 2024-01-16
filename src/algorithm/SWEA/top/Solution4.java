package algorithm.SWEA.top;

import java.util.Scanner;

public class Solution4
{

    public static int getNumNodes(int root, int[][] tree) {
        int sum = 1;
        if(tree[root][0]!=0){
            sum += getNumNodes(tree[root][0], tree);
            if(tree[root][1]!=0) sum += getNumNodes(tree[root][1], tree);
        }
        return sum;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 1;

            int V = sc.nextInt();
            int E = sc.nextInt();

            int A = sc.nextInt();
            int B = sc.nextInt();

            int[] parent = new int[V + 1];
            int[][] tree = new int[V + 1][2];
            for (int i = 0; i < E; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();
                parent[c] = p;
                if(tree[p][0]==0) tree[p][0] = c;
                else tree[p][1] = c;
            }

            int num = A;
            boolean[] visited = new boolean[V + 1];
            while (parent[num] != 0) {
                visited[parent[num]] = true;
                num = parent[num];
            }

            num = B;
            while (!visited[parent[num]]) {
                num = parent[num];
            }
            int common_parent = parent[num];

            answer = getNumNodes(common_parent, tree);

            System.out.println("#"+test_case+" "+common_parent+" "+answer);
        }
    }
}
