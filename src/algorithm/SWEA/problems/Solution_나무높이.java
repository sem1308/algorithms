package algorithm.SWEA.problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_나무높이
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T;
        T=Integer.parseInt(br.readLine());
 
        StringTokenizer tokens;
 
        StringBuilder sb = new StringBuilder();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
 
            tokens = new StringTokenizer(br.readLine());
 
            int[] heights = new int[N];
            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(tokens.nextToken());
                maxHeight = Math.max(maxHeight, heights[i]);
            }
 
            int numOdd = 0;  // 홀수 개수 구하기
            int numEven = 0; // 짝수 개수 구하기
            for (int i = 0; i < N; i++) {
                if(heights[i] == maxHeight) continue;
                int diff = maxHeight - heights[i];
                if(diff % 2 == 1){
                    heights[i]++;
                    numOdd++;
                }
                numEven += (maxHeight - heights[i])/2;
            }
 
            int min = Math.min(numOdd, numEven);
 
            numOdd -= min;
            numEven -= min;
 
            int maxDate = 2*min;
            if(numOdd > 0){
                maxDate += (numOdd-1) * 2 +1;
            }else if(numEven > 0){
                int k = numEven / 3;
                int r = numEven % 3;
                maxDate += (numEven - k) * 2;
                if(r == 2) maxDate--;
            }
 
            sb.append("#").append(test_case).append(" ").append(maxDate).append(" ").append("\n");
        }
        System.out.println(sb);
    }
}