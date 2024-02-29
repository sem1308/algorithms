package algorithm.SWEA.problems;

import java.util.ArrayList;
import java.util.List;

class Soldier{
	int mID;
	int mTeam;
	int mScore;
	boolean fired;
	int enteredUpdatedCnt;

	public Soldier(int mID, int mTeam, int mScore, int enteredUpdatedCnt) {
		this.mID = mID;
		this.mTeam = mTeam;
		this.mScore = mScore;
		this.enteredUpdatedCnt = enteredUpdatedCnt;
	}
}

class Team{
	static final int MAX_CNT = 100_000;
	int curCnt;
	List<Soldier> soldierList;
	int[] updatedScorePerCnt;
	
	Team(){
		soldierList = new ArrayList<>();
		updatedScorePerCnt = new int[MAX_CNT];
	}
}

class UserSolution_병사관리
{	
	static final int MAX_SOLDIER_ID = 100_000;
	
	Team[] teamList;
	Soldier[] soldierArr;
	
	public void init()
	{
		teamList = new Team[6];
		for (int i = 0; i < 6; i++) {
			teamList[i] = new Team();
		}
		soldierArr = new Soldier[MAX_SOLDIER_ID+1];
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		Team team = teamList[mTeam];
		Soldier soldier = new Soldier(mID, mTeam, mScore, team.curCnt);
		team.soldierList.add(soldier);
		soldierArr[soldier.mID] = soldier;
	}
	
	public void fire(int mID)
	{
		Soldier soldier = soldierArr[mID];
		soldier.fired = true;
	}

	public void updateSoldier(int mID, int mScore)
	{
		Soldier soldier = soldierArr[mID];
		soldier.mScore = mScore;
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		Team team = teamList[mTeam];
		
		for (int i = 0; i <= team.curCnt; i++) {
			team.updatedScorePerCnt[i] += mChangeScore;
		}		
		team.curCnt++;
	}
	
	public int bestSoldier(int mTeam)
	{
		Team team = teamList[mTeam];
		int[] addScore = team.updatedScorePerCnt;
		for (int i = 0; i <= team.curCnt; i++) {
			System.out.print(addScore[i] + " ");
		}
		System.out.println();
		int ID = 0;
		int maxScore = 0;
		for (Soldier soldier : team.soldierList) {
			if(soldier.fired) continue;
			int score = soldier.mScore + addScore[soldier.enteredUpdatedCnt];
			if(score < 1) score = 1;
			else if(score > 5) score = 5;
			System.out.print("["+soldier.mID+ " " + soldier.mTeam + " " + soldier.mScore+"]");
			if(maxScore < score || (maxScore == score && ID < soldier.mID)) {
				maxScore = score;
				ID = soldier.mID;
			}
		}
		System.out.println();
		return ID;
	}
}