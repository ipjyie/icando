package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GameController;
import controller.MemberController;
import model.MemberDTO;

public class GameMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		GameController gcont = new GameController();
		MemberController mcont = new MemberController();

		int result = 0;

		while (true) {
			System.out.println("[1] 회원가입 [2] 로그인 [3] 조회 [4] 탈퇴 [5] 종료");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("====회원가입 기능====");

				System.out.println("아이디 : ");
				String id = sc.next();

				System.out.println("비밀번호 : ");
				String pw = sc.next();

				System.out.println("닉네임 : ");
				String nick = sc.next();

				result = mcont.conInsert(id, pw, nick);

				if (result > 0) {
					System.out.println("가입 성공");
				} else {
					System.out.println("가입 실패");
				}

			} else if (menu == 2) {
				System.out.println("====로그인 기능!====");

				System.out.print("아이디 입력 : ");
				String id = sc.next();

				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();

				String nick = mcont.conLogin(id, pw);

				if (nick != null) {
					System.out.println("환영합니다~~ " + nick + "님");
					System.out.print("게임을 시작하시겠습니까?? Y/N >>");
					String ans = sc.next();
					if (ans.equals("Y")) {
						break;
					}
				}
			} else if (menu == 3) { // 조회 기능
				ArrayList<MemberDTO> resultList = new ArrayList<MemberDTO>();

				resultList = mcont.conSelect();

				for (int i = 0; i < resultList.size(); i++) {
					System.out.println(resultList.get(i).getId() + " / " + resultList.get(i).getNick());
				}

			} else if (menu == 4) { // 탈퇴

				ArrayList<MemberDTO> resultList = new ArrayList<MemberDTO>();

				resultList = mcont.conSelect();

				for (int i = 0; i < resultList.size(); i++) {
					System.out.println(resultList.get(i).getId() + " / " + resultList.get(i).getNick());
				}

				System.out.println("어느 아이디를 탈퇴하시겠습니까? ");
				String id = sc.next();

				mcont.conDel(id);
				System.out.println("삭제가 완료되었습니다!");
			} else if (menu == 5) {
				System.out.println("게임을 종료합니다.");
				break;
			}

		}

		while (true) {
			gcont.printMenu();
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("디지몬들을 불러오고 있습니다.");
				gcont.Cplayer();
				System.out.println();
				
				gcont.Cselect();
				if (gcont.OpD.size() != 4) {
					gcont.CopP();
				}
			} else if (menu == 2) {
				gcont.Catt();
				gcont.Cdef();
			} else if (menu == 3) {
				gcont.Ccheck();
			} else if (menu == 4) {
				gcont.Cscore();
			} else if (menu == 5) {
				gcont.Crank();
			}
		}

	}

}
