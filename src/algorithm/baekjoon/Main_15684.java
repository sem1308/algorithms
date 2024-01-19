package algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class Main_15684{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int H = Integer.parseInt(tokenizer.nextToken());

		int answer = -1;
		
		short[][] map = new short[H][N];
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokenizer.nextToken())-1;
			int b = Integer.parseInt(tokenizer.nextToken())-1;
			
			map[a][b] = 1;
			map[a][b+1] = -1;
		}
		
		/*
		 * [1,-1, 0, 0, 0] [0, 1, 2, 3, 4]
		 * [0, 0, 1,-1, 0] [1, 0, 2, 3, 4]
		 * [0, 1,-1, 0, 0] [1, 0, 3, 2, 4]
		 * [0, 0, 0, 0, 0] [1, 3, 0, 2, 4]
		 * [1,-1, 0, 1,-1] [1, 3, 0, 2, 4]
		 * [0, 0, 0, 0, 0] [3, 1, 0, 4, 2]
		 * 				   [3, 1, 0, 4, 2]
		 * */

		short[][] numArr = new short[H+1][N];

		for (short i = 0; i < N; i++) {
			numArr[0][i] = i;
		}
		
		for (short i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				numArr[i+1][j] = numArr[i][j+map[i][j]];
			}
		}

		List<short[]> coordList = new ArrayList<>();
		for (short i = 0; i < H; i++) {
			for (short j = 0; j < N-1; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					coordList.add(new short[]{i,j});
				}
			}
		}

		short[][] coordArr = coordList.toArray(new short[0][]);

		Queue<List<Short>> q = new ArrayDeque<>();
		List<Short> list = new ArrayList<>();
		q.add(list);

		while(!q.isEmpty()) {
			List<Short> coordIndices = q.poll();

			short[] idxToNum = numArr[0].clone();
			short[] result = numArr[H].clone();

			for (short coordIdx : coordIndices) {
				int x = coordArr[coordIdx][0];
				int y = coordArr[coordIdx][1];

				int a = numArr[x][y];
				int b = numArr[x][y+1];

				int aIdx = 0, bIdx = 0;
				for (int i = 0; i < N; i++) {
					if(idxToNum[a] == result[i]) aIdx = i;
					else if(idxToNum[b] == result[i]) bIdx = i;
				}

				short temp = result[aIdx];
				result[aIdx] = result[bIdx];
				result[bIdx] = temp;

				temp = idxToNum[a];
				idxToNum[a] = idxToNum[b];
				idxToNum[b] = temp;
			}

			boolean isValid = true;
			for (int i = 0; i < N; i++) {
				if(result[i] != i) {
					isValid = false;
					break;
				}
			}

			if(isValid) {
				answer = coordIndices.size();
				break;
			}

			if (coordIndices.size() != 3){
				int stIdx = 0;
				if(!coordIndices.isEmpty()){
					int lastIdx = coordIndices.get(coordIndices.size()-1);
					stIdx = (lastIdx != (coordArr.length-1) &&
							coordArr[lastIdx][0] == coordArr[lastIdx+1][0] &&
							coordArr[lastIdx][1]+1 == coordArr[lastIdx+1][1]) ? lastIdx+2: lastIdx+1;
				}
				for (short i = (short) (stIdx); i < coordArr.length; i++) {
                    List<Short> temp = new ArrayList<>(coordIndices);
					temp.add(i);
					q.add(temp);
				}
			}
		}

		System.out.println(answer);
		
	}

}
