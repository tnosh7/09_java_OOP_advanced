package step9_01.atm_v1;

import java.util.Random;
import java.util.Scanner;

public class Account_풀ATM {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	Account_풀UserManager userManager = new Account_풀UserManager();
	int log = -1;
	
	void printMainMenu() { 
		
		while (true) {
			System.out.println("MEGE ATM");
			System.out.println("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료]");
			int sel = scan.nextInt();
			if (sel == 1) {
				login();
			}
			else if (sel == 2 ) {
				logout();
			}
			else if (sel == 3 ) {
				join();
			}
			else if (sel == 4 ) {
				leave();
			}
			else if (sel == 0 ) {
				break;
			}
		}
	}
	void login() {
		log = userManager.logUser();
		if (log != -1) {
			printAccountMenu();
		}
		else {
			System.out.println("로그인 실패");
		}
	}
	void logout() { 
		if (log == -1) {
			System.out.println("로그인후에 이용가능");
		}
		else {
			log = -1;
			System.out.println("로그아웃되었ㅆ브");
 		}
	}
	void join() { 
		userManager.addUser();
	}
	void leave() { 
		userManager.leave();
	}
	void printAccountMenu() {
		
	}
	
}