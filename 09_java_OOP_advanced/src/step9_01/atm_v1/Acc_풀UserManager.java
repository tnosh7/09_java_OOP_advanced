package step9_01.atm_v1;

import java.util.Scanner;

public class Acc_풀UserManager {
	
	Scanner scan = new Scanner(System.in);
	Acc_풀User[] user = null; 
	int userCnt = 0;
	
	
	void printAllUser() { 
		for (int i = 0; i < userCnt; i++) {
			user[i].printAccount();
		}
	}
	
	void addUser() { 
		if (userCnt == 0) {
			user = new Acc_풀User[1];
			
			System.out.print("[가입] 아이디를 입력하세요 : ");
			String name = scan.next();
			
			user[userCnt] = new Acc_풀User(); 
			user[userCnt].id = name;
			System.out.println("[메시지] ID : " + name + "가입 완료 ");
			userCnt++;
		}
		else {
			
			System.out.print("[가입] 아이디를 입력하세요 : ");
			String name = scan.next();
			boolean isDuple = false; 
			for (int i = 0; i < userCnt; i++) {
				if (user[i].id.equals(name)) {
					isDuple = true;
				}
			}
			if (!isDuple) { 
				
				Acc_풀User[] tmp = user;
				user = new Acc_풀User[userCnt+1];
				for (int i = 0; i < userCnt; i++) {
					user[i] = tmp[i];
				}
				tmp = null;
				
				user[userCnt] = new Acc_풀User();
				user[userCnt].id = name;
				System.out.println("[메시지] ID : " + name + "가입을 환영합니다.");
				
				userCnt++;
			}
			else {
				System.out.println("[메시지] " + name + "는 이미 가입된 아이디입니다.");
			}
		}
	}
	void logUser() { 
		
		int idx = -1; 
		System.out.print("[로그인] 아이디를 입력해주세요 : ");
		String name = scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			if (user[i].id.equals(name)) { 
				idx = i;
				System.out.println("[" + user[idx].id + "] 님 로그인되었습니다.");
			}
		}
	}
	
	
	
	
	
	
	void delUser() {
		System.out.print("[탈퇴] 아이디를 입력해주세요 : ");
		String id = scan.next();
		int delIdx = -1; 
		for (int i = 0; i < userCnt; i++) {
			if (id.equals(user[i].id)) {
				delIdx = i;
			}
		}
		if (delIdx == -1 ) {
			System.out.println("[메시지] 아이디를 확인해주세요.");
			return;
		}
		System.out.println("ID : " + user[delIdx].id + "가 탈퇴되었습니다.");
		Acc_풀User[] tmp = user;
		user = new Acc_풀User[userCnt -1];
		
		for (int i = 0; i < delIdx; i++) {
			user[i] = tmp[i];
		}
		for (int i = delIdx; i < userCnt -1 ; i++) {
			user[i] = tmp[i +1 ] ; 
		}
		userCnt--;
	}
	
	
	Acc_풀User loginCheck(int idx) {
		return user[idx]; 
	}
}