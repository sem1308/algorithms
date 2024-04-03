package algorithm.SWEA.problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
        
        StringTokenizer tokens;
        
        // 내 앞에 몇 명이고 내 뒤에 몇 명인지 정확히 하는 사람
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < M; i++) {
				
			}
		}
        System.out.println(sb);
    }
}