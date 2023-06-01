package step9_02.atm_v2;

import java.util.Scanner;

public class UserManager_풀이 {	// 3번 
	
	private UserManager_풀이() {} 
	private static UserManager_풀이 instance = new UserManager_풀이();
	public static UserManager_풀이 getInstance() { 
		return instance;
	}
	Scanner scan = new Scanner(System.in);
	final int ACC_MAX_CNT = 3;
	User[] userList = null;
	int userCnt = 0;
	//모든 유저 출력, 추가하기-FW에 저장하기(추가), 삭제하기, 
	//인덱스 체크해서(user에 있는 acc배열 이용해서)중복확인하기 ->로그인아이디체크 
	//계좌번호 체크해서 중복확인 
	void printAllUser() { 
		
		for (int i = 0; i < userCnt; i++) {
			System.out.println((i+1)+"ID : " + userList[userCnt].id + "\tPW : " + userList[userCnt].pw);
			if (userList[i].accCnt != 0 ) {
				for (int j = 0; j < userList[i].accCnt; j++) {
					System.out.println(userList[i].acc[j].accNumber + " : " + userList[i].acc[j].money);
				}
			}
			System.out.println();
		}
	}
	
	boolean isDuple(String account) {
		
		boolean isDuple = false;
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userList[i].accCnt; j++) {
				if(account.equals(userList[i].acc[j].accNumber) ) {
					isDuple = true;
				}
			}
		}
		
		
		return isDuple;
		
	}
	
	int logUser() { 
		int identifier = -1;
		System.out.print("로그인 아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.print("로그인 패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		for (int i = 0; i < UserManager_풀이.instance.userCnt; i++) {
			if (id.equals(userList[i].id) && pw.equals(userList[i].pw)) {
				identifier = i;
			}
		}
		return identifier;
	}
	
	boolean checkId (String id) {
		
		boolean isDuple = false; 
		for (int i = 0; i < userCnt; i++) {
			if(userList[i].acc.equals(id)) {
				isDuple = true;
			}
		}
		return isDuple;
	}
	boolean getCheckAcc (String account) {
		
		boolean isDuple = false; 
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userList[i].accCnt; j++) {
				if (account.equals(userList[i].acc[j].accNumber)) {
					isDuple = true;
				}
			}
		}
		return isDuple;
		
	}
	void joinMember() { 
		System.out.println("회원가입 아이디를 입력하세요 : ");
		String id = scan.next();
		
		System.out.println("회원가입 패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		boolean isCheck = checkId(id);
		
		if (isCheck) {
			System.out.println("메시지 아이디가 중복됩니다.");
			return;
		}
		else {
			User[] temp = userList;
			userList = new User[userCnt+1];
			userList[userCnt] = new User();
			
			for (int i = 0; i < userCnt; i++) {
				userList[i] = temp[i];
			}
			temp= null;
		}
		userList[userCnt].id = id;
		userList[userCnt].pw = pw;
		userCnt++;
		System.out.println("메시지 환영합니다.");
		//FW 추가하기 
		FileManager_풀이.getInstance().saveData();
	}
	
	int delMember(int identifier) {
		User[] temp = userList;
		userList = new User[userCnt -1]; 
		
		int j= 0;
		for (int i = 0; i < userCnt; i++) {
			if (i != identifier) {
				userList[i]= temp[i];
			}
		}
		userCnt--;
		temp = null;
		identifier = -1;
		System.out.println("메시지 탈퇴되었습니다.");
		
		//FM 추가 
		FileManager_풀이.getInstance().saveData();
		return identifier;
	}
	
	
	
}