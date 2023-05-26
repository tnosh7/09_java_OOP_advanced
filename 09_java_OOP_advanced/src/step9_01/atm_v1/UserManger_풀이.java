package step9_01.atm_v1;

import java.util.Scanner;

public class UserManger_풀이 {

	Scanner scan = new Scanner(System.in);
	User[] user = null;
	int userCnt = 0;
	
	//유저 추가 삭제 로그인 로그아웃 프린트 
	
	void printAllUser() { 
		for (int i = 0; i < userCnt; i++) {
			user[i].printAccount();
		}
	}
	void addUser() {
		if (userCnt == 0) {
			
			user = new User[1]; 
			
			System.out.println("[가입] 아이디 입력하세요.");
			String id = scan.next();
			
			user[userCnt] = new User();
			user[userCnt].id = id;
			System.out.println("[메시지] ID : " + id + "가입 완료");
		}
		else {
			
			System.out.println("[가입] 아이디 입력하세요.");
			String id = scan.next();
			
			boolean isDuple = false; 
			for (int i = 0; i < userCnt; i++) {
				if (user[i].id.equals(id)) {
					isDuple=true;
				}
			}
			if (!isDuple) {
				User[]temp = user;
				user = new User[userCnt+1];
				
				for (int i = 0; i < temp.length; i++) {
					user[i] = temp[i];
				}
				temp = null;
				
				user[userCnt] = new User();
				user[userCnt].id = id;
				System.out.println("[메시지] ID : " + id + "가입 완료");
				userCnt++;
			}
			else {
				System.out.println("[메시지] 이미 가입된 아이디입니다.");
			}
		}
	}
	User getUser(int idx) {
		return user[idx];
	}
	void leave() {
		System.out.print("[입력] 탈퇴할 아이디를 입력하세요 : ");
		String delId = scan.next();
		
		int identifier = -1;
		for (int i = 0; i < userCnt; i++) {
			if (user[i].id.equals(delId)) {
				identifier = i;
			}
		}
		if (identifier == -1 ) {
			System.out.println("없는 아이디입니다.");
		}
		System.out.println("Id : " + user[identifier].id + "탈퇴완료");
		User[]temp = user;
		user = new User[userCnt-1];
		
		for (int i = 0; i < identifier; i++) {
			user[i] = temp[i];
		}
		for (int i = identifier; i < userCnt-1; i++) {
			user[i] = temp[i+1];
		}
		temp = null;
		userCnt--;
	}
	int logUser() { 
		int identifier = -1; 
		System.out.print("[입력] 아이디를 입력하세요 : ");
		String name= scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			if (user[i].id.equals(name)) {
				identifier = i;
				System.out.println(user[identifier].id + "님 환영합니다.");
			}
		}
		return identifier;
	}
}
