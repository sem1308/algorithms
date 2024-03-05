package algorithm.SWEA.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class UserSolution_리스트복사
{
	class Log{
		int time; // 변경 시간
		int index; // 변경 index
		int value; // 변경 value

		public Log(int time, int index, int value) {
			this.time = time;
			this.index = index;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Log [time=" + time + ", index=" + index + ", value=" + value + "]";
		}
	}
	
	class JList{
		int[] originList;
		
		int time; // 리스트 복사 시간
		String name; // 리스트 이름
		JList prev; // 이전 버전 리스트
		List<Log> changeLog; // 해당 리스트의 변경 이력

		public JList(int time, String name, JList prev) {
			this.time = time;
			this.name = name;
			this.prev = prev;
			changeLog = new ArrayList<>();
		}
		
		public void change(int time, int index, int value) {
			changeLog.add(new Log(time,index,value));
		}
		
		public int get(int index, int time) {
			int element = -1;
			
			for(Log log : changeLog) {
				if(log.time > time) break;
					 
				if(log.index == index) {
					element = log.value;
				}
			}
			
			if(element == -1) {
				if(prev != null ) {
					element = prev.get(index, this.time);
				}else {
					element = originList[index];
				}
			}
			
			return element;
		}
	}
	
	/*
	 * 
	 */
	
	Map<String,JList> lists; // 깊은 복사시 저장할 정보
	
	int time; // 복사, 수정 마다 증가
	
	public String getName(char mName[]) {
		String name = "";
		for (int i = 0; i < mName.length; i++) {
			if(mName[i] == '\0') break;
			name += mName[i];
		}
		return name;
	}
	
	public void init()
	{
		lists = new TreeMap<>();
	}

	public void makeList(char mName[], int mLength, int mListValue[])
	{ 
		// 10 이하       
		String name = getName(mName);
		JList list = new JList(time++, name, null);
		lists.put(name, list);
		list.originList = Arrays.copyOf(mListValue, mLength);
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{
		// 5,000 이하
		String src = getName(mSrc);
		String dest = getName(mDest);

		JList srcList = lists.get(src);
		if(mCopy) {
			// 깊은 복사
			lists.put(dest, new JList(time++, dest, srcList));
		}else {
			lists.put(dest, srcList);
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue)
	{
		// 100,000 이하
		String name = getName(mName);
		JList list = lists.get(name);
		list.change(time++,mIndex,mValue);
	}

	public int element(char mName[], int mIndex)
	{
		// 400 이하
		String name = getName(mName); 
		JList list = lists.get(name);
		
		return list.get(mIndex,time);
	}
}