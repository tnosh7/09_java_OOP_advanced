package step9_01.atm_v1;

import java.util.Scanner;

public class Account_풀UserManager {
	
	Scanner scan = new Scanner(System.in);
	Account_풀User[] user =null;
	int userCnt = 0;
	
	void printAllUser() {
		for (int i = 0; i < userCnt; i++) {
			user[i].printAccount();
		}
	}
	void addUser() { 
		if (userCnt == 0) {
			user = new Account_풀User[1];
			
			System.out.println("아이디 입력 : ");
			String id = scan.next();
			
			user[userCnt] = new Account_풀User();
			user[userCnt].id = id;
			System.out.println("id : " + id + "님 환영합니다.");
			userCnt++;
		}
		else {
			System.out.println("아이디를 입력하세요");
			String id = scan.next();
			
			boolean isDuple =false;
			for (int i = 0; i < userCnt; i++) {
				if (user[i].id.equals(id)) {
					isDuple = true;
				}
			}
			if (!isDuple) {
				Account_풀User[]temp = user;
				user = new Account_풀User[userCnt+ 1];
				for (int i = 0; i < userCnt; i++) {
					user[i] = temp[i];
				}
				temp = null;
				user[userCnt] = new Account_풀User();
				user[userCnt].id = id;
				System.out.println("id " + id +"님 환영합니다.");
				userCnt++;
 			}
			else {
				System.out.println("이미 가입된 아이디입니다.");
			}
		}
	}
	
	Account_풀User getUser(int idx) {
		return user[idx];
	}
	
	int logUser() { 
		int log = -1; 
		System.out.println("아이디입력");
		String id = scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			if (id.equals(user[i].id)) {
				log = i ;
				System.out.println("[" + user[log].id + "]" + "환영합니다..");
			}
		}
		return log;
	}
	void leave() { 
		System.out.println("탈퇴할 아이디입력");
		String id = scan.next();
		int log = -1;
		for (int i = 0; i < userCnt; i++) {
			if (id.equals(user[i].id)) {
				log = i;
			}
		}
		if (log == -1) {
			System.out.println("가입후에 이용가능");
			return;
		}
		System.out.println("id : " + user[log].id + "님 탈퇴되엇스비낟.");
	
		Account_풀User[]temp = user;
		user = new Account_풀User[userCnt-1];
		for (int i = 0; i < log; i++) {
			user[i] = temp[i];
		}
		for (int i = log; i < userCnt; i++) {
			user[i] = temp[i+1];
		}
		userCnt--;
		
	}
	
}