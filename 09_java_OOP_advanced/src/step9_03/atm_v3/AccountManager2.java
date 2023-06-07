package step9_03.atm_v3;


public class AccountManager2 {

	private AccountManager2() {}
	private static AccountManager2 instance = new AccountManager2();
	public static AccountManager2 getInstance() {
		return instance;
	}
	
	UserManager userManager = UserManager.getInstance();
	
	void creatAccount() { 
		
		User loginUser = userManager.userList[userManager.identifier];
		if (loginUser.accCount == 3) {
			System.out.println("더이상 생성할 수 없습니다.");
			return;
		}
		if (loginUser.accCount == 0 ) {
			loginUser.accList = new Account[loginUser.accCount + 1];
			
		}
		else if (loginUser.accCount > 0) {
			Account[]temp = loginUser.accList;
			loginUser.accList = new Account[loginUser.accCount + 1];
			for (int i = 0; i < loginUser.accCount; i++) {
				loginUser.accList[i] = temp[i];
			}
			temp = null;
		}
		loginUser.accList[loginUser.accCount] = new Account();
		
		String makeAccount = ATM.ran.nextInt(90000000) + 10000001 + "";
		loginUser.accList[loginUser.accCount].number = makeAccount;
		loginUser.accList[loginUser.accCount].money  = 0;
		
		loginUser.accCount++;
		System.out.println("[메시지] 계좌가 생성되었습니다.");
		
		FileManager.getInstance().saveData();
	}
	
	int showAccList(String msg) {
		int loginAccIndex = -1;
		
		User loginUser = userManager.userList[userManager.identifier];
		
		if (loginUser.accCount > 0) {
			for (int i = 0; i < loginUser.accCount; i++) {
				System.out.print("[" + (i+1)+ "]" + loginUser.accList[i].number);
			}
			
			System.out.print("[" + msg + "] 내 계좌를 메뉴에서 선택하세요 : ");
			loginAccIndex = ATM.scan.nextInt();
			loginAccIndex--;
		}
		return loginAccIndex;
	}
	
	void income() { 
		
		int loginAccIndex = showAccList("입금");
		
		
	}
	
}
