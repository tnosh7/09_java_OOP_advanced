package step9_01.atm_v1;

public class User_풀이 {
	
	String id; 
	int accCnt;
	Account[] acc; 
	
	void printAccount() { 
		for (int i = 0; i < accCnt; i++) {
			acc[i].printOwnAccount();
		}
	}
}
