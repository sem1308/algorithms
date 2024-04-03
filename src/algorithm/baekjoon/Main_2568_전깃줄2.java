package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2568_전깃줄2{
	
	static class Line implements Comparable<Line>{
		int from, to;

		public Line(int from, int to) {
			this.from = from;
			this.to = to;
		}

		public int compareTo(Line o) {
			return from - o.from;
		}
	}
	
	static class Num{
		int num;
		int order;

		public Num(int num, int order) {
			this.num = num;
			this.order = order;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		/*
		 * 
		 * 
		 * 
		 * 
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		Line[] lines = new Line[N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			lines[i] = new Line(from,to);
		}
		
		Arrays.sort(lines);
		
		List<Num>[] lineList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			lineList[i] = new ArrayList<>();
		}
		
		int[] C = new int[N];
		int maxK = 0;
		Arrays.fill(C, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			Line line = lines[i];
			
			int k = Arrays.binarySearch(C, 0, maxK, line.to);
			if(k < 0) k = -k-1;
			
			if(C[k] > line.to) {
				C[k] = line.to;
				lineList[k].add(new Num(line.from,i));
			}
			
			if(k == maxK) {
				maxK++;
			}
		}
		
		int[] result = new int[maxK];
		int lastOrder = N;
		for (int i = 0; i < maxK; i++) {
			int n = 0;
			for(Num num : lineList[i]) {
				if(num.order > lastOrder) break;
				n = num.num;
			}
			result[i] = n;
		}
		
		System.out.println(N-maxK);
		
		System.out.println(Arrays.toString(result));
	}
}
