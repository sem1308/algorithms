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
	int mid;
	
	void addPlayer(Player np, int l, Player p) {
		while(np != null && np.ability >= p.ability) {
			np = np.next;
		}
		
		// 현재 플레이어를 np 앞에 삽입
		if(np == null) {
			// 맨 뒤 삽입
			pTails[l].next = p;
			p.prev = pTails[l];
			pTails[l] = p;
		}else if(np.prev == null) {
			// 맨 앞 삽입
			pHeads[l].prev = p;
			p.next = pHeads[l];
			pHeads[l] = p;
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
    	mid = M/2;
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
//    		print(pMids[i]);
//    		print(pTails[i]);
		}
    }

    int move() {
    	// <= 500
    	
    	// 가운데 리그
    	for (int i = 0; i < L-1; i++) {
    		// i , i+1 바꾸기
    		
    		
    		
		}
    	
    	
        return 0;
    }

    int trade() {
    	// <= 1000
    	
    	
        return 0;
    }
}