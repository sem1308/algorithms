package algorithm.SWEA.problems;

import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

class UserSolution_삼국지게임 {
	/*
	 * 전체 영토 크기 N : 4 <= N x N <= 625
	 * 
	 * 각 영토 당 군주 존재
	 * 각 영토 당 병사 존재
	 * 
	 * 동맹관계 리스트
	 * 적대관계 리스트
	 * 
	 * 
	 * 
	 */
	
	
	class Monarch{
		Monarch parent; // 동맹관계
		List<Monarch> childs;
		
		String name;
		int x,y;
		int numSoldiers;

		public Monarch(String name, int x, int y, int numSoldiers) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.numSoldiers = numSoldiers;
			
			childs = new LinkedList<>();
		}
	}
	
	Monarch[][] map;
    TreeMap<String,Monarch> nameToMonarch;
	
    String getName(char[] name) {
    	StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length; ++i)
        	if(name[i] == '\0') {
        		break;
        	}else {
        		sb.append(name[i]);
        	}
        return sb.toString();
    }
    
    Monarch find(Monarch m) {
    	Monarch p = m;
    	while(p.parent != null) {
    		p = p.parent;
    	}
    	if(m != p) {
    		m.parent.childs.remove(m);
    		m.parent = p;
    	}
    	return p;
    }

    void init(int N, int mSoldier[][], char mMonarch[][][])
    {
    	map = new Monarch[N][N];
    	nameToMonarch = new TreeMap<>();
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				String name = getName(mMonarch[i][j]);
				
				Monarch m = new Monarch(name, i, j, N);
				
				nameToMonarch.put(name, m);
				map[i][j] = m;
			}
		}
    	
    	
    }
    void destroy()
    {

    }
    int ally(char mMonarchA[], char mMonarchB[])
    {
    	/*
    	 * <= 8000
    	 * 
    	 * 어떤 군주와 다른 군주의 동맹
    	 * union find?
    	 * 
    	 * 군주 mMonarchA, 군주 mMonarchB 동맹
    	 * 
    	 * A, B 동일 or 이미 동맹관계 => -1 반환
    	 * A, B 적대관계 -> -2 반환
    	 * 
    	 * 그렇지 않으면 동맹 맺고 1 반환
    	 *  
    	 *  
    	 * 1. 각 군주 이름 받아옴
    	 * 2. 군주 이름에 해당하는
    	 *  
    	 */
    	
    	Monarch A = nameToMonarch.get(getName(mMonarchA));
    	Monarch B = nameToMonarch.get(getName(mMonarchB));
    	
    	Monarch pA = find(A);
    	Monarch pB = find(B);
    	if(A == B) {
    		return -1;
    	}else{
    		if(pAA == pBA) {
        		return -2;
    		}else {
	        	pB.parent = pA;
	            return 1;
    		}
    	}
    }
    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[])
    {
    	/*
    	 * <= 8000
    	 * 
    	 * 어떤 군주와 그 동맹 군주들이 다른 군주 영토 공격
    	 * 공격시 동맹과 동맹 사이는 적대관계 생성
    	 * 
    	 * 자신이 가진 병사의 절반을 공격
    	 * 방어 군주의 인접 동맹도 병사 절반을 방어 보냄
    	 * 
    	 * 남은 병사 수로 승리 여부 판단
    	 * 
    	 * 공격 > 방어
    	 * - 영토 함락 -> 공격 지휘 장수가 새 군주
    	 * - 새 군주의 병사 수 = 공격하고 남은 병사 수
    	 * 
    	 */
    	
    	
    	
    	
        return -3;
    }
    int recruit(char mMonarch[], int mNum, int mOption)
    {
    	/*
    	 * <= 13000
    	 * 
    	 * 병사 모집
    	 * mOption = 0
    	 * - mMonarch 군주 영토에만 mNum명 추가
    	 * 
    	 * mOption = 1
    	 * - mMonarch 군주 모든 동맹에 mNum명 추가
    	 * 
    	 * 
    	 * 
    	 */
    	
    	if() {
    		
    	}
    	
    	
        return -1;
    }
}