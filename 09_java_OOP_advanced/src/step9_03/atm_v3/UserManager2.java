package step9_03.atm_v3;
//23-06-02 16:30 ~ 
public class UserManager2 {
	
	private UserManager2() { }
	private static UserManager2 instance = new UserManager2();
	public static UserManager2 getInstance () { 
		return instance;
	}
	
	User[] userList;
	int userCount; 
	int identifier = -1;
	
	
	void printAllUserInfo() { 
		System.out.println("아이디\t패스워드\t계좌정보\t");
		for (int i = 0; i < userCount; i++) {
			userList[i].printOneUserAllAccounts();
		}
		System.out.println();
	}
	
	void setDummy() {
		
		userCount = 5; 
		userList = new User[userCount];
		for (int i = 0; i < userCount; i++) {
			userList[i] = new User();
		}
		String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
		String[] b = {"l", "b", "c", "m", "e", "f", "g", "n", "i", "p", "k"};
		String[] c = {"s", "t", "u", "w", "v", "o", "x", "n", "q", "p", "r"};
		
		for (int i = 0; i < userCount; i++) {
			String id = "";
			int rNum = ATM.ran.nextInt(a.length);
			id += a[rNum];
			rNum = ATM.ran.nextInt(b.length);
			id += b[rNum];
			rNum = ATM.ran.nextInt(c.length);
			id += c[rNum];
			
			userList[i].id = id;
		}
		
		String[] d = {"1", "8", "9", "4"};
		String[] e = {"2", "7", "0", "6"};
		String[] f = {"5", "3", "2", "7"};
		
		for (int i = 0; i < userCount; i++) {
			String pw = "";
			int rNum = ATM.ran.nextInt(d.length);
			pw += d[rNum];
			rNum = ATM.ran.nextInt(e.length);
			pw += e[rNum];
			rNum = ATM.ran.nextInt(f.length);
			pw += f[rNum];
			
			userList[i].password = pw;
		}
		
		System.out.println("[메시지] 더미 파일을 추가했습니다.");
		
		
	}
	
	
	void joinUser() { 
		System.out.print("[가입] 아이디를 입력해주세요 : ");
		String id = ATM.scan.next();
		
		int checkedId = checkId(id);
		if (checkedId != -1 ) {
			System.out.println("[메세지] 아이디가 중복됩니다.");
			return;
		}
		System.out.print("[가입] 비밀번호를 입력해주세요 : ");
		String password = ATM.scan.next();
		
		if (userCount == 0) {
			userList = new User[1];
			userList[userCount] = new User(id, password);
		}
		else if (userCount > 0 ) {
			User[] temp = userList;
			
			userList = new User[userCount + 1];
			for (int i = 0; i < userCount; i++) {
				userList[i] = temp[i];
			}
			userList[userCount] = new User(id, password);
			temp = null;
		}
		userCount++;
		System.out.println("[메세지] 회원가입을 완료하였습니다.\n");
		//파일매니저 저장 추가하기 
	}
	
	int checkId (String id) {
		
		int check = -1;
		for (int i = 0; i < userCount; i++) {
			if (userList[i].id.equals(id)) {
				check = i;
			}
		}
		return check;
	}
	void loginUser() { 
		
		System.out.print("[로그인] 아이디를 입력하세요 : ");
		String id = ATM.scan.next();
		
		System.out.print("[로그인] 패스워드를 입력하세요 : ");
		String password = ATM.scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if (userList[i].id.equals(id) && userList[i].password.equals(password)) {
				identifier = i;
			}
		}
		if (identifier == -1) {
			System.out.println("[메시지]회원가입 이후에 이용해주세요.");
		}
		else {
			System.out.println("[메시지] ID : " + userList[userCount].id + "님, 환영합니다.");
			//로그인 후에 계좌 출력메뉴 추가하기. 
		}
	}
	
	void logoutUser() { 
		identifier = -1;
		System.out.println("[메시지] 로그아웃되었습니다.");
	}
	
	void leaveUser() { 
		if (userCount == 1) {
			userList = null;
		}
		else if (userCount > 1) {
			User[]temp = userList;
			userList = new User[userCount-1];
			
			int j= 0;
			for (int i = 0; i < userCount -1 ; i++) {
				if (i != identifier) {
					userList[j++] = temp[i];
				}
			}
		}
		userCount--;
		
		System.out.println("[메시지] 탈퇴되었습니다.");
		logoutUser();
		//저장 나중에 추가하기 
	}
	
	void afterloginMenu() { 
		
		while (true) { 
			
			System.out.println("[" + userList[userCount].id + "님, 환영합니다.");
			System.out.println("1.계좌생성\n2.입금하기\n3.출금하기\n4.이체하기\n5.계좌조회\n6.계좌삭제\n7.회원탈퇴\n0.뒤로가기");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = ATM.scan.nextInt();
			
			if (choice == 1) {
				AccountManager.getInstance().createAccount();
			}
			else if (choice == 2) {}
			else if (choice == 3) {}
			else if (choice == 4) {}
			else if (choice == 5) {}
			else if (choice == 6) {}
			else if (choice == 7) {}
			else if (choice == 0) {
				break;
			}
			
		}
	} 
	
}	
