package algorithm.SWEA.problems;
class UserSolution_계산게임 {
	class Node{
		int id;
		int num;
		
		Node next; 
		Node prev;
		
		public Node(int id, int num, Node next, Node prev) {
			this.id = id;
			this.num = num;
			this.next = next;
			this.prev = prev;
		}
	}
	
	
	// 전체 15000 이하
	int joker; // 1 <= joker <= 30
	
	Node head;
	Node tail;
	
	Node[][] jokerNumNodes; // 

    void init(int mJoker, int mNumbers[]) {
    	joker = mJoker;
    	
    	jokerNumNodes = new Node[31][20];
    }

    void putCards(int mDir, int mNumbers[]) {
    	// 10000 이하
    	// 카드 길이가 50000이하
    }

    int findNumber(int mNum, int mNth, int ret[]) {
    	/*
    	 * 1 <= mNum <= 19
    	 * 1 <= mNth <= 1000
    	 */
    	
        return -1;
    }

    void changeJoker(int mValue) {
    	joker = mValue;
    }
}