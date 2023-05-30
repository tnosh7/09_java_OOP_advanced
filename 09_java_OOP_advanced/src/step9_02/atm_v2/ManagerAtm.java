package step9_02.atm_v2;

import java.util.Scanner;

public class ManagerAtm {
	
	Scanner scan = new Scanner(System.in);
	int log = -1; 
	ManagerUser mu = ManagerUser.getInstance();
	
	void printAtmAccMenu() { 
		// UserManager에서 join, login, 추가 --> 여기서 join, login 출력 
		while (true) {
			System.out.println("[ATM]");
			System.out.println("[1.회원가입] [2.로그인] [0.종료]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel ==1 ) join();
			else if (sel == 2) login();
			else if (sel == 0) break;
			
		}
		
	}
	void login() { 
		log = mu.logUser();
		if (log == -1) ;
		else System.out.println("[메시지] 아이디와 패스워드를 확인해주세요.");
	}
	
	void join() {
		
	}
	
	void loginMenu() { 
		
		
	}
}
