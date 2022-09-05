package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.player;
import model.playerDTO;
import view.GameMain;

public class GameController implements GameInterface {
	
	GameMain gm = new GameMain();
	player p = new player();
	public ArrayList<playerDTO> Dlist = new ArrayList<>();
	public ArrayList<playerDTO> MyD = new ArrayList<>();
	public ArrayList<playerDTO> OpD = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	@Override
	public void printMenu() {
		System.out.println("[1] 엔트리 생성 [2] 배틀 시작 [3] 선수 명단 확인 [4] 선수 기록 확인 [5] 선수 랭킹 확인");

	}

	@Override
	public void Cplayer() {
		Dlist = p.player();

	}

	@Override
	public void Cselect() {
		if (p.MyD.size() > 0) {
			System.out.println("이미 선수를 뽑았습니다.");
			
		} else {
			System.out.println("4개의 캐릭터 영입 가능합니다.");
			MyD = p.select();
			System.out.println("나의 선수 명단");
			for (int i = 0; i < MyD.size(); i++) {
				System.out.println(i + 1 + ", " + MyD.get(i).getName() + " 능력치 : " + MyD.get(i).getAb());
			}
		}
	}

	@Override
	public void CopP() {

		OpD = p.op();
		System.out.println("상대 선수 명단");
		for (int i = 0; i < OpD.size(); i++) {
			System.out.println(i + 1 + ", " + OpD.get(i).getName() + " 능력치 : " + OpD.get(i).getAb());
		}

	}

	@Override
	public void Catt() {
		if (p.MyD.size() != 4) {
			System.out.println("선수를 먼저 영입해주세요");
		} else {
			p.att();
		}

	}

	@Override
	public void Ccheck() {
		if (p.MyD.size() != 4) {
			System.out.println("선수를 먼저 영입해주세요");
		} else {
			p.CM();

			System.out.println("상대 선수 명단");
			for (int i = 0; i < OpD.size(); i++) {
				System.out.println(i + 1 + ", " + OpD.get(i).getName() + " 능력치 : " + OpD.get(i).getAb());
			}
		}

	}

	public void Cscore() {
		if (p.MyD.size() != 4) {
			System.out.println("선수를 먼저 영입해주세요");
		} else {
			p.CM();
			System.out.print("누구의 기록을 확인하시겠습니까? ");
			int num = sc.nextInt();
			System.out.println(MyD.get(num - 1).getName() + " 능력치 : " + MyD.get(num - 1).getAb() + " 득점 기록 : "
					+ MyD.get(num - 1).score);

		}
	}

	@Override
	public void Crank() {
		p.rank();

	}

	@Override
	public void Cdef() {
		p.def();

	}

}
