package step9_03.atm_v3;

public class User2 {
	
	String id;
	String password;
	Account[] accList;
	int accCount;
	
	
	User2() {}
	User2(String id, String password) {
		this.id = id;
		this.password = password;
	}
	User2(String id, String password, Account[] accList, int accCount ){
		this.id = id;
		this.password = password;
		this.accList = accList;
		this.accCount = accCount;
				
	}
	void printOneUserAllAccounts() { 
		
		if (accCount == 0) {
			System.out.println(id + "\t" + password + "\t계좌 개설 후이 이용해주세요.");
		}
		else if (accCount > 0) {
			System.out.println(id + "\t" + password + "\t");
			for (int i = 0; i < accCount; i++) {
				System.out.println(accList[i].number + "\t" + accList[i].money + "원");
			}
			System.out.println();
		}
	}
	
	
}
