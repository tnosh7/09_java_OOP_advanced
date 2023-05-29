package step9_01.atm_v1;

public class Account_풀User {
	String id; 
	int accCnt;
//account까지 나온 배열 	
	Account_풀[] acc;
	
	void printAccount() {
		for (int i = 0; i < accCnt; i++) {
			acc[i].printOwnAccount();
		}
	}
	
}