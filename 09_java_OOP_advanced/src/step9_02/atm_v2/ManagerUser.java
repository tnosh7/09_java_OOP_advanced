package step9_02.atm_v2;

import java.util.Scanner;

public class ManagerUser {
	
	private ManagerUser() {}
	private static ManagerUser instance = new ManagerUser();
	public static ManagerUser getInstance() { 
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	
	final int ACC_MAX_CNT = 3; 
	User[] userList = null;
	int userCnt = 0;
	
	void printAlluser() {
		for (int i = 0; i < userCnt; i++) {
			System.out.print((i+1) + ".ID(" + userList[i].ids + ")\tPw(" + userList[i].pws);
			if (userList[i].accCnt != 0) {
				for (int j = 0; j < userList[i].accCnt; j++) {
					System.out.println("(" + userList[i].acc[j].acNumber + ":" + userList[i].accs[j].money + ")");
				}
			}
			System.out.println();
		}
	}
	int logUser() { 
		int log = -1; 
		
		System.out.print("[로그인] ID를 입력하세요 : ");
		String id = scan.next();
		System.out.print("[로그인] PW를 입력하세요 : ");
		String pw = scan.next();
		
		for (int i = 0; i < ManagerUser.instance.userCnt; i++) {
			if (userList[i].id.equals(id) && userList[i].pw.equals(pw)) {
				log = i;
			}
		}
		return log;
	}
	
	void joinUser() { 
		
		System.out.print("[회원가입] ID를 입력하세요 : ");
		String id = scan.next();
	
		System.out.print("[회원가입] PW를 입력하세요 : ");
		String pw = scan.next();
		
		boolean isDuple = checkId(id); 
		
		if (isDuple) {
			System.out.println("[메시지] 아이디가 중복됩니다.");
			return;
		}
		if (userCnt == 0) {
			userList = new User[userCnt+1];
			userList[userCnt] = new  User();
		}
		
		else {
			
		}
		userList[userCnt].id = id;
		userList[userCnt].pw = pw;
		
		userCnt++;
		System.out.println("[메시지] 회원가입을 축하합니다.");
		////////////////////////////-FW추가 ! 
	}
	
	boolean checkId(String id ) { 
		boolean isDuple = false; 
		for (int i = 0; i < userCnt; i++) {
			if (userList[i].id.equals(id)) {
				isDuple = true;
			}
		}
		return isDuple;
	}
	
	
}
