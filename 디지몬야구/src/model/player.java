package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class player {

	public ArrayList<playerDTO> Dlist = new ArrayList<>();
	public ArrayList<playerDTO> MyD = new ArrayList<>();
	public ArrayList<playerDTO> OpD = new ArrayList<>();
	public ArrayList<playerDTO> temp = new ArrayList<>();

	Random rd = new Random();
	Scanner sc = new Scanner(System.in);

	public ArrayList<Integer> cnt = new ArrayList<>();
	public ArrayList<playerDTO> rank = new ArrayList<>();
	int score = 0; // 랭킹 환산

	public ArrayList<playerDTO> player() {
		playerDTO dto = new playerDTO("아구몬1");
		Dlist.add(dto);
		dto = new playerDTO("아구몬2");
		Dlist.add(dto);
		dto = new playerDTO("아구몬3");
		Dlist.add(dto);
		dto = new playerDTO("아구몬4");
		Dlist.add(dto);
		dto = new playerDTO("아구몬5");
		Dlist.add(dto);
		dto = new playerDTO("아구몬6");
		Dlist.add(dto);
		dto = new playerDTO("아구몬7");
		Dlist.add(dto);
		dto = new playerDTO("아구몬8");
		Dlist.add(dto);
		dto = new playerDTO("아구몬9");
		Dlist.add(dto);
		dto = new playerDTO("아구몬10");
		Dlist.add(dto);

		return Dlist;
	}

	public ArrayList<playerDTO> select() {

		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < Dlist.size(); j++) {
				System.out.println(j + 1 + ", " + Dlist.get(j).getName());
			}

			System.out.println(i + "번째 선수를 영입하세요");
			int num = sc.nextInt();
			MyD.add(Dlist.get(num - 1));
			Dlist.remove(num - 1);
		}
		if (Dlist.size() != 6) {
			for (int i = 0; i < Dlist.size(); i++) {
				System.out.println(Dlist.get(i).getName());
			}
		}
		return MyD;

	}

	public ArrayList<playerDTO> op() {

		for (int i = 1; i <= 4; i++) {
			int num = rd.nextInt(Dlist.size());
			OpD.add(Dlist.get(num));
			Dlist.remove(num);
		}
		return OpD;
	}

	public void CM() { // 나의 선수 명단 확인
		System.out.println("나의 선수 명단");
		for (int i = 0; i < MyD.size(); i++) {
			System.out.println(i + 1 + ", " + MyD.get(i).getName() + " 능력치 : " + MyD.get(i).getAb());
		}
	}

	public void att() {
		for (int i = 0; i < MyD.size(); i++) {
			temp.add(MyD.get(i));
		}
		int num1;

		boolean gi = true;
		for (int i = 0; i < 3; i++) {
			System.out.println("다음 타자 준비!");
			int cnt = 0;
			for (int j = 0; j < temp.size(); j++) {
				System.out.println(j + 1 + ", " + temp.get(j).getName() + " 능력치 : " + temp.get(j).getAb());
			}
			System.out.print("출전 시킬 디지몬 : ");
			num1 = sc.nextInt();
			System.out.println(temp.get(num1 - 1).getName() + " 능력 : " + temp.get(num1 - 1).getAb());

			while (cnt < 3) {

				System.out.println("Are you ready? Y/N");
				String ans = sc.next();

				int num = rd.nextInt(OpD.size());
				System.out.println("상대의 캐릭터 :  " + OpD.get(num).getName() + ", 능력 : " + OpD.get(num).getAb());
				playerDTO My = temp.get(num1 - 1);
				playerDTO Op = OpD.get(num);

				if (ans.equals("N")) {
					System.out.println("경기를 포기하시겠습니까? Y/N");
					String ans2 = sc.next();
					if (ans2.equals("Y")) {
						gi = false;
						break;
					}
				}

				if (My.getAb() < Op.getAb() + 10) {
					System.out.print("스트라이크!");
					if (cnt == 0) {
						System.out.println(" ● ○ ○ ");
					} else if (cnt == 1) {
						System.out.println(" ● ● ○ ");
					} else if (cnt == 2) {
						System.out.println(" ● ● ● 삼진 아웃");
					}
					cnt++;
				} else if (My.getAb() >= Op.getAb() + 40) {
					System.out.println("홈런 4득점!");
					My.score += 4;
					break;
				} else if (My.getAb() >= Op.getAb() + 30) {
					System.out.println("3루타 3득점!");
					My.score += 3;
					break;
				} else if (My.getAb() >= Op.getAb() + 20) {
					System.out.println("2루타 2득점!");
					My.score += 2;
					break;
				} else if (My.getAb() >= Op.getAb() + 10) {
					System.out.println("1루타 1득점!");
					My.score += 1;
					break;
				}
			}
			temp.remove(num1 - 1);
			if (gi = false) {
				break;
			}
		}
		System.out.println("공수 교대!");
	}

	public void def() {
		
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			int num = rd.nextInt(OpD.size());

			playerDTO Op = OpD.get(num);

			CM();
			System.out.print("출전 시킬 디지몬 : ");
			int num1 = sc.nextInt();
			playerDTO My = MyD.get(num1 - 1);
			System.out.println("상대의 캐릭터 : " + OpD.get(num).getName() + ", 능력 : " + OpD.get(num).getAb());
			System.out.println("나의 캐릭터 : " + MyD.get(num1 - 1).getName() + " 능력 : " + MyD.get(num1 - 1).getAb());

			while (cnt < 3) {

				if (Op.getAb() < My.getAb() + 10) {
					System.out.print("스트라이크!");
					if (cnt == 0) {
						System.out.println(" ● ○ ○ ");
					} else if (cnt == 1) {
						System.out.println(" ● ● ○ ");
					} else if (cnt == 2) {
						System.out.println(" ● ● ● 삼진 아웃");
					}
					cnt++;
				} else if (Op.getAb() >= My.getAb() + 40) {
					System.out.println("홈런 4득점!");
					Op.score += 4;
					break;
				} else if (Op.getAb() >= My.getAb() + 30) {
					System.out.println("3루타 3득점!");
					Op.score += 3;
					break;
				} else if (Op.getAb() >= My.getAb() + 20) {
					System.out.println("2루타 2득점!");
					Op.score += 2;
					break;
				} else if (Op.getAb() >= My.getAb() + 10) {
					System.out.println("1루타 1득점!");
					Op.score += 1;
					break;
				}
			}
		}
	}

	public void score() {
		System.out.println("득점 기록 : " + score);

	}

// 정렬 해보자
	public void rank() {
		playerDTO top = null;
		for (int i = 0; i < MyD.size(); i++) {
			rank.add(MyD.get(i));
		}
		for (int i = 0; i < OpD.size(); i++) {
			rank.add(OpD.get(i));
		}
		for (int i = 0; i < rank.size(); i++) {

			top = rank.get(i);
		}
	}

}
