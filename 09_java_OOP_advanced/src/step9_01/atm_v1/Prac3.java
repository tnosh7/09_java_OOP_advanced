package step9_01.atm_v1;

import java.util.Scanner;

public class Prac3 {
	
	Scanner scan = new Scanner(System.in);
	Prac[] user = null;
	int userCnt = 0;
	
	void printAllUser() { 
		
		for (int i = 0; i < userCnt; i++) {
			user[i].printAllCount();
		}
	}
	
	void addUser() { 
		
		if(userCnt == 0) {
			user = new Prac[1];
			
			System.out.print("[가입] 아이디를 입력하세요 : ");
			String id = scan.next();
			
			user[userCnt] = new Prac();
			user[userCnt].id = id;
			System.out.println("[" + id + "]님, 가입을 환영합니다.");
			userCnt++;
 		}
		
		else {

			System.out.print("[가입] 아이디를 입력하세요 : ");
			String id = scan.next();
			
			boolean isCheck = false;
			for (int i = 0; i < userCnt; i++) {
				if (id.equals(user[i].id)) {
					isCheck = true;
				}
			}
			if (isCheck) {
				System.out.println("[오류]중복아이디입니다.");
			}
			else {
				Prac[]temp = user;
				user = new Prac[userCnt+1];
				for (int i = 0; i < temp.length; i++) {
					user[i] = temp[i];
				}
				temp = null;
				
				user[userCnt] = new Prac();
				user[userCnt].id = id;
				System.out.println("[" + id + "]님, 가입을 환영합니다.");
				userCnt++;
			}
		}
	}
	Prac checkUser(int idx) {
		return user[idx];
	}
	
	int logUser() { 
		int identifier = -1;
		System.out.print("[로그인]아이디를 입력하세요.");
		String id = scan.next();
		for (int i = 0; i < userCnt; i++) {
			if (id.equals(user[i].id)) {
				identifier = i;
				System.out.println("[" + id + "]님, 환영합니다.");
			}
		}
		return identifier;
	}
	void delUser() {
		int identifier = -1;
		System.out.println("[탈퇴]아이디를 입력하세요.");
		String id = scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			if (id.equals(user[i].id)) {
				identifier = i;
			}
		}
		if (identifier != -1) {
			Prac[]temp = user;
			user = new Prac[userCnt-1];
			
			for (int i = 0; i < identifier; i++) {
				user[i] = temp[i];
			}
			for (int i = identifier; i < userCnt-1; i++) {
				user[i] = temp[i+1];
			}
			userCnt--;
		}
		
	}
	
}
