package algorithm.SWEA.problems;

import java.util.Arrays;

class UserSolution_긴사다리게임
{
	
	
	/*
	 * 각 세로선 마다 가로줄 리스트 생성
	 * 
	 */
	
	class Line{
		int x, y; // 연결된 x, y축 번호 x -> x+1
		Line prevLeft, prevRight; // 왼쪽, 오른쪽으로 왔을 때 연결된 가로줄
		Line nextLeft, nextRight; // 왼쪽, 오른쪽으로 갔을 때 연결된 가로줄
		
		Line prev, next;
		
		public Line(int x, int y) {
			this.x = x;
			this.y= y;
		}
	}
	
	Line[] lines = new Line[101];
	
	public void init()
	{
		Arrays.fill(lines, null);
	}
	
	public Line getLine(int mX, Line newLine) {
		if(lines[mX] == null) {
			lines[mX] = newLine;
			return lines[mX];
		}else {
			Line line = lines[mX];
			while(line.y < newLine.y && line.next != null) {
				line = line.next;
			}
			
			return line;
			
//			if(line.next == null) {
//				// 맨 마지막에 설치해야 할 때
//				line.next = newLine;
//				newLine.prev = line;
//			}else if(line == lines[mX]) {
//				// 처음에 설치해야 할 때
//				newLine.next = line;
//				line.prev = newLine;
//				lines[mX] = newLine;
//			}else {
//				// 중간에 설치해야 할 때
//				newLine.prev = line.prev;
//				newLine.next = line;
//				
//				line.prev.next = newLine;
//				line.prev = newLine;
//			}
		}
	}

	public void add(int mX, int mY)
	{
		// (mX, mY)와 (mX+1, mY)를 잇는 가로줄을 추가
		// 200,000 이하
		Line newLine = new Line(mX,mY);
		
		Line line1 = getLine(mX,newLine);
		Line line2 = getLine(mX+1,newLine);
	}

	public void remove(int mX, int mY)
	{
		// (mX, mY)와 (mX+1, mY)를 잇는 가로줄을 삭제
		// 5000 이하
		
		Line line = lines[mX];
		
		while(line.y != mY) {
			line = line.next;
		}
		
		if(line.prev == null) {
			line.next.prev = null;
			lines[mX] = line.next;
		}else if(line.next == null) {
			line.prev.next = null;
		}else {
			line.prev.next = line.next;
			line.next.prev = line.prev;
		}
	}

	public int numberOfCross(int mID)
	{
		// 사다리 게임 진행시 mID번 참가자가 지나게 되는 가로줄 개수 반환
		// 500 이하
		
		Line line = lines[mID];
		
		int cnt = 0;
		int curX = mID;
		while(line != null) {
			if(line.left == curX) {
				
			}else {
				
			}
			
			
			cnt++;
		}
		
		return cnt;
	}

	public int participant(int mX, int mY)
	{
		// (mX, mY)를 지나게 되는 참가자의 번호를 반환
		// 500 이하
		
		
		return 0;
	}
}