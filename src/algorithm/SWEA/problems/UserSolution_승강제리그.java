package algorithm.SWEA.problems;
class UserSolution_승강제리그 {
	/*
	 * N명 선수 경기 <= 39990
	 * 0 ~ N-1까지 ID값 가짐 
	 * 능력값 존재
	 * 능력값 높고 ID 낮은 선수가 좋음
	 * 
	 * 여러 리그로 나눠 경기 진행
	 * 
	 * L : 리그 개수 <= 10
	 * 0 ~ L-1까지 ID값 가짐
	 * 
	 * ID가 작을 수록 우수한 리그
	 * 
	 * N/L명씩 앞 리그부터 배치
	 * N/L = M은 홀수 <= 3,999
	 * 
	 * 능력이 가장 좋지 않은 선수는 바로 아래 리그로
	 * 능력이 가장 좋은 선수는 바로 위 리그로
	 * 
	 * 트레이드 : 각각의 리그에서 능력이 가장 좋은 선수를 바로 위 리그의 중간 급 능력의 선수와 맞교환
	 * (M+1) / 2번째 선수와 교환
	 * 
	 */
	
	class Player {
		int id;
		int ability;
		
		Player next, prev;
		
		Player(int id, int ability){
			this.id = id;
			this.ability = ability;
		}

		@Override
		public String toString() {
			return "Player [id=" + id + ", ability=" + ability + ", next=" + next +"]";
		}
	}
	
	Player[] pHeads; // 가장 높은 선수
	Player[] pMids; // 중간 선수
	Player[] pTails; // 가장 낮은 선수
	
	int L;
	int M;
	
	void addPlayer(Player np, int l, Player p) {
		while(np != null && (np.ability > p.ability || (np.ability == p.ability && np.id < p.id))) {
			np = np.next;
		}
		
		// 현재 플레이어를 np 앞에 삽입
		if(np == null) {
			// 맨 뒤 삽입
			pTails[l].next = p;
			p.prev = pTails[l];
			pTails[l] = p;
			p.next = null;
		}else if(np.prev == null) {
			// 맨 앞 삽입
			pHeads[l].prev = p;
			p.next = pHeads[l];
			pHeads[l] = p;
			p.prev = null;
		}else {
			p.next = np;
			p.prev = np.prev;
			
			np.prev.next = p;
			np.prev = p;
		}
	}
	
	Player getPlayer(Player p, int k) {
		for (int i = 0; i < k; i++) {
			p = p.next;
		}
		
		return p;
	}
	
	void print(Player head) {
		System.out.println(head);
	}
	
    void init(int N, int L, int mAbility[]) {
    	pHeads = new Player[L];
    	pMids = new Player[L];
    	pTails = new Player[L];
    	 
    	M = N / L;
    	this.L = L;
    	int mid = M/2;
    	int curId = 0;
    	for (int i = 0; i < L; i++) {
    		for (int j = 0; j < M; j++) {
				Player p = new Player(curId, mAbility[curId++]);
				
				if(pHeads[i] == null) {
					pHeads[i] = pTails[i] = p;
				}else {
					addPlayer(pHeads[i],i,p);
				}
			}
    		// mid 구하기
    		pMids[i] = getPlayer(pHeads[i],mid);
//    		print(pHeads[i]);
//    		print(pMids[i]);
//    		print(pTails[i]);
		}
//    	System.out.println();
    }

    int move() {
    	// <= 500
    	
    	Player[] hs = new Player[L-1];
    	Player[] ls = new Player[L-1];
    	
    	int res = 0;
    	for (int i = 0; i < L-1; i++) {
    		ls[i] = pTails[i];
    		hs[i] = pHeads[i+1];
    		
    		res += (hs[i].id + ls[i].id);
    		
    		pTails[i] = pTails[i].prev;
    		pTails[i].next = null;
    		pHeads[i+1] = pHeads[i+1].next;
    		pHeads[i+1].prev = null;
    	}
    	
    	int[] diff = new int[L];
    	diff[0] = -1;
    	diff[L-1] = 1;
    	
    	for (int i = 0; i < L-1; i++) {
			if(pMids[i].ability < hs[i].ability || (pMids[i].ability == hs[i].ability && pMids[i].id > hs[i].id)) {
				addPlayer(pHeads[i],i,hs[i]);
				diff[i]--;
			}else {
				addPlayer(pMids[i],i,hs[i]);
				diff[i]++;
			}
    		
			if(pMids[i+1].ability < ls[i].ability || (pMids[i+1].ability == ls[i].ability && pMids[i+1].id > ls[i].id)) {
				addPlayer(pHeads[i+1],i+1,ls[i]);
				diff[i+1]--;
			}else {
				addPlayer(pMids[i+1],i+1,ls[i]);
				diff[i+1]++;
			}
		}
    	
    	for (int i = 0; i < L; i++) {
			if(diff[i] < 0) {
				pMids[i] = pMids[i].prev;
			}else if(diff[i] > 0) {
				pMids[i] = pMids[i].next;
			}
			
//			print(pHeads[i]);
//			print(pMids[i]);
		}
    	
//    	System.out.println(res);
    	
        return res;
    }

    int trade() {
    	// <= 1000
    	Player[] ms = new Player[L-1];
    	Player[] hs = new Player[L-1];
    	
    	int res = 0;
    	for (int i = 0; i < L-1; i++) {
    		ms[i] = pMids[i];
    		hs[i] = pHeads[i+1];
    		
    		res += (hs[i].id + ms[i].id);
    		
    		if(pMids[i].prev == null) {
    			pHeads[i] = pMids[i].next;
    		}else {
        		pMids[i].prev.next = pMids[i].next;    			
    		}
    		pMids[i].next.prev = pMids[i].prev;
    		pMids[i] = pMids[i].next;
    		
    		pHeads[i+1] = pHeads[i+1].next;
    		pHeads[i+1].prev = null;
    	}
    	
    	int[] diff = new int[L];
    	diff[0] = -1;
    	diff[L-1] = 1;
    	
    	for (int i = 0; i < L-1; i++) {
			if(pMids[i].ability < hs[i].ability || (pMids[i].ability == hs[i].ability && pMids[i].id > hs[i].id)) {
				addPlayer(pHeads[i],i,hs[i]);
				diff[i]--;
			}else {
				addPlayer(pMids[i],i,hs[i]);
				diff[i]++;
			}
    		
			if(pMids[i+1].ability < ms[i].ability || (pMids[i+1].ability == ms[i].ability && pMids[i+1].id > ms[i].id)) {
				addPlayer(pHeads[i+1],i+1,ms[i]);
				diff[i+1]--;
			}else {
				addPlayer(pMids[i+1],i+1,ms[i]);
				diff[i+1]++;
			}
		}
    	
    	for (int i = 0; i < L; i++) {
			if(diff[i] < 0) {
				pMids[i] = pMids[i].prev;
			}else if(diff[i] > 0) {
				pMids[i] = pMids[i].next;
			}
			
//			print(pHeads[i]);
//			print(pMids[i]);
		}
    	
//    	System.out.println(res);
    	
        return res;
    }
}