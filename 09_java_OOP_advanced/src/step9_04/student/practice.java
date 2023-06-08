package step9_04.student;

import java.util.HashMap;

public class practice {
	
	//추가 수정 삭제 출력 전체출력 종료/

	public boolean checkId(String id) {
		StudentVO studentVO = studentDAO.select(id);
		return studentVO == null? true:false;
	}
	
