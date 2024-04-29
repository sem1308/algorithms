package algorithm.baekjoon;
import java.io.*;
import java.util.*;

public class Main_1516 {

    public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;

         
         int n = Integer.parseInt(br.readLine());
         int degree[] = new int[n+1];
         int times[] = new int[n+1];
         int result[] = new int[n+1];
         ArrayList<ArrayList<Integer>> al = new ArrayList();
         
         for(int i=0;i<=n;i++) {
             al.add(new ArrayList<>());
         }
         
         for(int i=1;i<=n;i++) {
             st = new StringTokenizer(br.readLine());
             times[i] = Integer.parseInt(st.nextToken());
             
             while(true) {
                 int pre = Integer.parseInt(st.nextToken());
                 if(pre == -1) break;
                 
                 degree[pre]++;
                 al.get(pre).add(i);
             }
         }
         
         int max = -1, maxIdx = -1;
         //차수 큰 것 구하기
         for(int i=1;i<=n;i++) {
             if(max < degree[i]) {
                 max = degree[i];
                 maxIdx = i;
             }
         }
         result[maxIdx] += times[maxIdx];
         
         
         while(true) {
             max = -1; maxIdx = -1;
             //차수 큰 것 구하기
             for(int i=1;i<=n;i++) {
                 if(max < degree[i]) {
                     max = degree[i];
                     maxIdx = i;
                 }
             }
             
             if(max == -1) break;
             
             degree[maxIdx] = -1;
             
             for(int i : al.get(maxIdx)) {
                 result[i] = Math.max(result[i], result[maxIdx] + times[i]);
             }
         }
         
         for(int i=1;i<=n;i++) System.out.println(result[i]);
    }

}