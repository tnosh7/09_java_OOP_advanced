package step9_01.atm_v1;

import java.util.Random;
import java.util.Scanner;

public class ATM_풀이 {
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager userManger = new UserManager();
	int identifier = -1;
	
	void printMainMenu() {
	
		while (true) {
			System.out.println("[ MEGA ATM ]");
			System.out.print("[1.로그인]" + " " + "[2.로그아웃]" + " " + "[3.회원가입]" + " " + "[4.회원탈퇴]" + " " + "[0.종료]");		
			int sel = scan.nextInt();	
			
			if (sel == 1) login();
			else if (sel ==2) logout();	
		
		
		}
	}
	void login() { 
		identifier = userManger.logUser();
		if (identifier == -1 ) { 
			printMainMenu();
		}
		else {
			System.out.println("[메세지] 로그인 실패");
		}
	}
	void logout() { 
		if (identifier == -1) {
			System.out.println("[메세지] 로그인 후에 이용가능합니다.");
		}
		else {
			identifier = -1;
			System.out.println("[메세지] 로그아웃 되었습니다.");
		}
	}
	void leave() { 
		userManger.leave();
	}
	void printAccountMenu () { 
		if (identifier != -1) {
			while (true) {
				System.out.print("[1.계좌생성] + [2.계좌삭제] + [3.조회] + [0.로그아웃]");
				int atmSel = scan.nextInt();
				String makeAccount = Integer.toString(ran.nextInt(90001) + 10000);
				
				if (atmSel == 1) {
					
					if (userManger.user[identifier].accCnt == 0) {
						userManger.user[identifier].acc = new Account_풀이[1];
					}
				
				
				}
				
				
				
				
			}
			
		}
		
		
		
		
	}
	
	
}
