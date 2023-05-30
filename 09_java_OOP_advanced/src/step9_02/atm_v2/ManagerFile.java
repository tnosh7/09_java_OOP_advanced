package step9_02.atm_v2;

public class ManagerFile {
	
	private ManagerFile() {}
	private ManagerFile instance = new ManagerFile();
	public ManagerFile getInstance() { 
		return instance;
	}
	
	String fileName = "PracticeATM.txt";
	String data = "";
	ManagerUser mu = ManagerUser.getInstance();
	
	void setData() { 
		data = "";
		int userCount = mu.userCnt;
		data += userCount;
		data += "\n";
		
		for (int i = 0; i < userCount; i++) {
			data += mu.userList[i].id;
			data += "\n";
			data += mu.userList[i].pw;
			data += "\n";
			data += mu.userList[i].accCnt;
			data += "\n";
			
			if(mu.user)
		}
		
	}
	
	void saver() { 
		
		
	}
			

	
}
