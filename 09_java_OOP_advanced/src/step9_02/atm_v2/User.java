package step9_02.atm_v2;

public class User { // 2번 - > UserManager에서 instance 설정후 여기서 배열 변수 설정
	
	Account[] acc = new Account[UserManager.getInstance().ACC_MAX_CNT];	
	int accCnt;	
	String id;											
	String pw;											
	

}


