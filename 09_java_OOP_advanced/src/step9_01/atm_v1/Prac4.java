package step9_01.atm_v1;

import java.util.Random;
import java.util.Scanner;

public class Prac4 {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	Prac3 userManager = new Prac3();
	int identifier = -1;
	
	void printMainMenu () { 
		while (true) {
			System.out.println("==Mega ATM==");
			System.out.println("1.로그인\n2.로그아웃\n3.회원가입\n4.회원탈퇴\n0종료 : ");
			int sel =scan.nextInt();
			if (sel == 1 ) login();
			else if (sel == 2) ;
			else if (sel == 3) ;
			else if (sel == 4) ;
			else if (sel == 0) break;
		}
	}
	void login() {
		identifier = userManager.logUser();
		if (identifier != -1) {
			printAccountMenu();
		}
		else {
			System.out.println("[오류]회원가입 후에 이용가능합니다.");
		}
	}
	void logout() { 
		
	}
	void printAccountMenu() { 
		
	}
}
