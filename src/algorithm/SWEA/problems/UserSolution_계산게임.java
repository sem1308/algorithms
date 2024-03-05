package algorithm.SWEA.problems;

import java.util.Arrays;

class UserSolution_계산게임 {
	class Node{
		int id;
		int num;
		Node next;
		Node prev;

		public Node(int id, int num) {
			this(id, num,null,null);
		}

		public Node(int id, int num, Node next, Node prev) {
			this.id = id;
			this.num = num;
			this.next = next;
			this.prev = prev;
		}

		public String toString(){
			return "["+id+","+num+"]";
		}
	}

	/*
		1. 전체 번호(노드)를 저장할 리스트 (head, tail) 생성
		2. joker, num을 만들 수 있는 첫 node 배열 생성
		3. putCards에서는 리스트 만들고 첫 node 배열 갱신
		4. findNumber에서는 joker와 num에 맞는 배열에서 앞에서부터 mNth까지 탐색
	 */
	
	// 전체 15000 이하
	int joker; // 1 <= joker <= 30
	
	Node head;
	Node tail;
	
	Node[][] nodeHeads = new Node[31][20]; // joker, num을 만들 수 있는 첫 node
	Node[][] nodeTails = new Node[31][20]; // joker, num을 만들 수 있는 끝 node

	Node[] nodePool = new Node[50000];
	int lastId;

    void init(int mJoker, int mNumbers[]) {
    	joker = mJoker;

		lastId = 0;
		head = tail = null;

		for (int i = 0; i < 5; i++) {
			Node node = new Node(lastId,mNumbers[i]);
			nodePool[lastId++] = node;
			if(head == null){
				head = tail = node;
			}else{
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
		}

		for (int i = 1; i <= 30 ; i++) {
			Arrays.fill(nodeHeads[i], null);
			Arrays.fill(nodeTails[i], null);

			int sum = 0;
			for (int j = 0; j < 4; j++) {
				if(mNumbers[j] == -1) sum += i;
				else sum += mNumbers[j];
			}
			int res = sum % 20;

			nodeHeads[i][res] = nodeTails[i][res] = new Node(nodePool[0].id,nodePool[0].num);

			sum = 0;
			for (int j = 1; j < 5; j++) {
				if(mNumbers[j] == -1) sum += i;
				else sum += mNumbers[j];
			}
			res = sum % 20;

			Node node = new Node(nodePool[1].id,nodePool[1].num);
			if(nodeHeads[i][res] == null){
				nodeHeads[i][res] = nodeTails[i][res] = node;
			}else{
				nodeTails[i][res].next = node;
				node.prev = nodeTails[i][res];
				nodeTails[i][res] = node;
			}
		}
    }

    void putCards(int mDir, int mNumbers[]) {
    	// 10000 이하
    	// 카드 길이가 50000이하
		// 리스트 만들고 첫 node 배열 갱신

		int firstId = lastId;

		for (int i = 0; i < 5; i++) {
			nodePool[lastId] = new Node(lastId++, mNumbers[i]);
		}

		if(mDir == 0){
			// 앞에 삽입
			for (int i = 4; i >= 0 ; i--) {
				int id = firstId+i;
				Node node = nodePool[id];
				head.prev = node;
				node.next = head;
				head = node;

				Node[] nodes = new Node[4];
				for (int j = 0; j < 4; j++) {
					nodes[j] = node;
					node = node.next;
				}

				for (int j = 1; j <= 30; j++) {
					int sum = 0;
					for (int k = 0; k < 4; k++) {
						if(nodes[k].num == -1) sum += j;
						else sum += nodes[k].num;
					}
					int res = sum % 20;

					node = new Node(nodes[0].id,nodes[0].num);

					if(nodeHeads[j][res] == null){
						nodeHeads[j][res] = nodeTails[j][res] = node;
					}else{
						nodeHeads[j][res].prev = node;
						node.next = nodeHeads[j][res];
						nodeHeads[j][res] = node;
					}
				}
			}
		}else{
			// 뒤에 삽입
			for (int i = 0; i < 5 ; i++) {
				int id = firstId+i;
				Node node = nodePool[id];
				tail.next = node;
				node.prev = tail;
				tail = node;

				Node[] nodes = new Node[4];
				for (int j = 0; j < 4; j++) {
					nodes[j] = node;
					node = node.prev;
				}

				for (int j = 1; j <= 30; j++) {
					int sum = 0;
					for (int k = 0; k < 4; k++) {
						if(nodes[k].num == -1) sum += j;
						else sum += nodes[k].num;
					}
					int res = sum % 20;

					node = new Node(nodes[3].id,nodes[3].num);

					if(nodeTails[j][res] == null){
						nodeHeads[j][res] = nodeTails[j][res] = node;
					}else{
						nodeTails[j][res].next = node;
						node.prev = nodeTails[j][res];
						nodeTails[j][res] = node;
					}
				}
			}
		}
    }

    int findNumber(int mNum, int mNth, int ret[]) {
    	/*
    	 * 1 <= mNum <= 19
    	 * 1 <= mNth <= 1000
    	 */

		Node node = nodeHeads[joker][mNum];

		for (int i = 1; i < mNth; i++) {
			if(node == null) break;
			node = node.next;
		}

		int res = 0;

		if(node != null){
			node = nodePool[node.id];
			res = 1;
			for (int i = 0; i < 4; i++) {
				ret[i] = node.num;
				node = node.next;
			}
		}

        return res;
    }

    void changeJoker(int mValue) {
    	joker = mValue;
    }
}