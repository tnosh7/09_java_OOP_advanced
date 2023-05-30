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
			System.out.println("");
		}
		
	}
	
}
