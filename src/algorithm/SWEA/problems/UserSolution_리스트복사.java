package algorithm.SWEA.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class UserSolution_리스트복사
{
	static class JList{
		JList list; // 복사한 리스트
		boolean isCopy; // 복사한 것인지
		int[] tempList; // 자신만의 리스트
		
		public JList(int[] list, boolean isCopy) {
			super();
			this.tempList = list;
			this.isCopy = isCopy;
			
			if(isCopy) {
				this.tempList = new int[list.length];
				Arrays.fill(this.tempList, -1);
			} else {
				
			}
		}
		
		public void update(int mIndex, int mValue) {
			if(isCopy) {
			}else {
				
			}
		}
	}
	
	Map<String,JList> lists;
	
	public void init()
	{
		lists = new HashMap<>();
	}

	public void makeList(char mName[], int mLength, int mListValue[])
	{
		// 10 이하
		lists.put(String.valueOf(mName), new JList(mListValue,false));
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{
		// 5,000 이하
		if(mCopy) {
			// TODO
			
			
		}else {
			lists.put(String.valueOf(mDest), lists.get(String.valueOf(mSrc)));
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue)
	{
		// 100,000 이하
		
		JList list = lists.get(String.valueOf(mName));
		list.update(mIndex, mValue);
	}

	public int element(char mName[], int mIndex)
	{
		// 400 이하
		return 0;
	}
}