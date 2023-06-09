package step9_01.atm_v1;

public class Prac {

	String id;
	int accCnt; 
	Prac2[]acc = null;
	
	void printAllCount() {
		
		for (int i = 0; i < accCnt; i++) {
			acc[i].printOwnAccount();
		}
	}
}
