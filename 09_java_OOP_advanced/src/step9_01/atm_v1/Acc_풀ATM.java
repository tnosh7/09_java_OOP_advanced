package step9_01.atm_v1;

import java.util.Random;
import java.util.Scanner;

public class Acc_풀ATM {
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	Acc_풀UserManager userManager = new Acc_풀UserManager(); 
	
	int log = -1; 
	
	void printUserMenu() {
		
		while (true) { 
			System.out.println("====MEGA ATM====");
			System.out.println("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료]");
			int sel = scan.nextInt();
			
			if (sel == 1 ) login() ;
			else if (sel ==2 ) logout();
			else if (sel ==3 ) join();
			else if (sel ==4 ) leave();
			else if (sel ==0 ) break;
		}
		System.out.println("[메시지] 프로그램을 종료합니다.");
	}
	
	void login() {
		log = userManager.l
		
	}
	void logout() { 
		
	}
	void join() {
		
	}
	void leave() { 
		
	}
}