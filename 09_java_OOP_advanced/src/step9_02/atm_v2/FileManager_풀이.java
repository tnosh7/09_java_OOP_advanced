package step9_02.atm_v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager_풀이 {	// 5번 
	
	private FileManager_풀이(){}
	private static FileManager_풀이 instance = new FileManager_풀이();
	public static FileManager_풀이 getInstance() {
		return instance;
	}
	
	String fileName = "ATM_Practice.txt";
	String data = "";
	UserManager_풀이 mu = UserManager_풀이.getInstance();
	
	void setData() {
		
		data = "";
		int userCnt = mu.userCnt;
		data += userCnt; 
		data += "\n";
		
		for (int i = 0; i < userCnt; i++) {
			data += mu.userList[i].id;
			data += "\n";
			data += mu.userList[i].pw;
			data += "\n";
			data += mu.userList[i].accCnt;
			data += "\n";
		
			if (mu.userList[i].accCnt == 0) {
				data += "0\n";
			}
			else {
				for (int j = 0; j < mu.userList[i].accCnt; j++) {
					data += mu.userList[i].acc[j].accNumber;
					data += "/n";
					data += mu.userList[i].acc[j].money;
					if (j != mu.userList[i].accCnt-1) {
						data += ",";
					}
				}
				data += "\n";
			}
		}
	}
	void loadData() {
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					data += line;
					data += "\n";
				}
				
				//값 
				String[] temp = data.split("/");
				mu.userCnt = Integer.parseInt(temp[0]); 
				mu.userList = new User[mu.userCnt];
				for (int i = 0; i < mu.userCnt; i++) {
					mu.userList[i] = new User();
				}
				
				int j = 0 ;
				for (int i = 0; i < temp.length; i++) {
					
					String id = temp[i];
					String pw = temp[i+1];
					int accCnt = Integer.parseInt(temp[i+2]);	//계좌수 accCnt 
					
					mu.userList[j].id = id;
					mu.userList[j].pw = pw;
					mu.userList[j].accCnt= accCnt;
					String accInfo = temp[i+3];				//계좌넘버 // 계좌돈 
					
					if (accCnt == 1) {
						String[] tmp = accInfo.split("/");
						
						String acc = temp[0];
						int money = Integer.parseInt(temp[1]);
						
						mu.userList[i].acc[0] = new Account();
						mu.userList[i].acc[0].accNumber = acc;
						mu.userList[i].acc[0].money = money;
					}
					if (accCnt > 1) {
						String[] tmp = accInfo.split(",");
						
						for (int k = 0; k < tmp.length; k++) {
							String[] parse = tmp[k].split("/n");
							String acc = tmp[0];
							int money = Integer.parseInt(tmp[1]);
							
							mu.userList[j].acc[k] = new Account();
							mu.userList[j].acc[k].accNumber = acc;
							mu.userList[j].acc[k].money = money;
						}
					}
					j++;
				}
				
			}
			else {
				saveData();
				setData();
			}
			} catch (Exception e) {
			e.printStackTrace();
			} finally {
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e1) {e1.printStackTrace();}
			}
	}
	
	
	void saveData() {
		
		setData();
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{ {
			if (fw != null) {
				try {fw.close();} catch (IOException e) {e.printStackTrace();}
			}
		}
		}
	}
	
}
