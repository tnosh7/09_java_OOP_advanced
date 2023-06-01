package step9_02.atm_v2;

import java.util.Random;
import java.util.Scanner;

public class AccountManager_풀이 {		//4번 
	
	private AccountManager_풀이() {}
	private static AccountManager_풀이 instance  = new AccountManager_풀이();
	public static AccountManager_풀이 getInstacne() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager_풀이 mu = UserManager_풀이.getInstance();
	
	void creatAcc(int identifier) {
		
		int accCntbyUser = mu.userList[identifier].accCnt;
		
		if(accCntbyUser == mu.ACC_MAX_CNT) {
			System.out.println("메시지 계좌개설은 3개까지만 가능합니다.");
			return;
		}
		mu.userList[identifier].acc[accCntbyUser] = new Account();
		
		String makeAccount = "";
		
		while(true) {
			makeAccount = ran.nextInt(900000) + 1000001 + "";
			if (!mu.getCheckAcc(makeAccount)) {
				break;
			}
		}
		mu.userList[identifier].acc[accCntbyUser].accNumber = makeAccount;
		mu.userList[identifier].accCnt++;
		System.out.println("메시지 " + makeAccount + "계좌가 생성되었습니다.");
				
	}
	void printAcc (int identifier) {
		
		User temp = mu.userList[identifier];
		System.out.println("========================");
		System.out.println("ID : " + temp.id);
		System.out.println("========================");
		for (int i = 0; i < temp.accCnt; i++) {
			System.out.println("accNumber : " + temp.acc[i].accNumber + "money : " + temp.acc[i].money);
		}
		System.out.println("\n========================\n");
	}
	
	void delAcc(int identifier) {
		
		int accCntbyUser = mu.userList[identifier].accCnt;
		
		if (accCntbyUser < 0) {
			System.out.println("메시지 계좌개설 후에 이용해주세요");
			return;
		}
		else {
			Account temp = mu.userList[idetifier].acc[accCntbyUser];
			
			
			
		}
		mu.userList[identifier].acc
		
		
		
	}
}