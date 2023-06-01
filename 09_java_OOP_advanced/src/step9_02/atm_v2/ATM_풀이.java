package step9_02.atm_v2;

import java.util.Scanner;

public class ATM_풀이 {						// 6번 

	Scanner scan = new Scanner(System.in);
	int identifier = -1 ;
	UserManager_풀이 mu = UserManager_풀이.getInstance();
	
	void play() {
		FileManager_풀이.getInstance().loadData();
		UserManager_풀이.getInstance().printAllUser();
		
		while (true) {
			
			System.out.println("[ATM]");
			System.out.println("[1.회원가입]\n[2.로그인]\n[0.종료]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) join();
			else if (sel == 2) login();
			else if (sel == 0) {
				break;
			}
		}
		
	}
	void join() {
		UserManager_풀이.getInstance().joinMember();
	}
	
	void login() {
		identifier = mu.logUser();
		if (identifier != -1) loginMenu();	//////loginMenu후 추가 
		else System.out.println("[메시지]아이디와 패스워드를 확인해주세요.");
	
	}
	
	void delAccount() {
		
	}
	void loginMenu() {
		while (true) {
			
			
			System.out.println("[" + mu.userList[identifier].id + "님, 환영합니다.]");
			System.out.println("[1.계좌생성]\n[2.계좌삭제]\n[3.조회]\n[4.회원탈퇴]\n[0.로그아웃]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel ==1) {
				AccountManager_풀이.getInstacne().creatAcc(identifier);
				FileManager_풀이.getInstance().saveData();
				
			}
			else if (sel == 2) {
				
			}
			else if (sel == 3) {
				AccountManager_풀이.getInstacne().printAcc(identifier);
			}
			else if (sel == 4) {
				identifier = mu.delMember(identifier);
				break;
			}
			else if (sel == 0) {
				identifier = -1;
				System.out.println("로그아웃 되었습니다.");
				break;
			}
		}
	}





}