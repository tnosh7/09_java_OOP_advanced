package step9_01.atm_v1;

public class Acc_풀User {
	
	String id; 
	int accCnt; 
	Acc_풀[]acc; 
	
	void printAccount() { 
		for (int i = 0; i < accCnt; i++) {
			acc[i].printOwnAccount();
		}
	}
}
	
