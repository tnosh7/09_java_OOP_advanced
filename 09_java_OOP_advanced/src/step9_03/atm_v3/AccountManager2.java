package step9_03.atm_v3;


public class AccountManager2 {

	private AccountManager2() {}
	private static AccountManager2 instance = new AccountManager2();
	public static AccountManager2 getInstance() {
		return instance;
	}
	
	UserManager userManager = UserManager.getInstance();
	
	
	
}
