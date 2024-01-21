package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1135 {

    public static List<Integer>[] childs;
    public static int dfs(int num){
        if(childs[num] == null) return 0;

        int result = 0;

        int numChild = childs[num].size();
        int[] childResults = new int[numChild];

        for (int i = 0; i < numChild; i++) {
            childResults[i] = dfs(childs[num].get(i));
        }

        Arrays.sort(childResults);

        for (int i = 1; i <= numChild; i++) {
            result = Math.max(result, i + childResults[numChild-i]);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());

        childs = new ArrayList[N];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(tokenizer.nextToken());
            if(p == -1) continue;

            if(childs[p] == null) childs[p] = new ArrayList<>();
            childs[p].add(i);
        }

        System.out.println(dfs(0));

    }
}