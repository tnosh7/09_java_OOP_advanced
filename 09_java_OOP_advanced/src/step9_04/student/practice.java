package step9_04.student;

import java.util.HashMap;

public class practice {
	
	//추가 수정 삭제 출력 전체출력 종료/
	private StudentDAO studentDAO;

	public practice(StudentDAO stDAO) {
		this.studentDAO =stDAO;
	}
	
	public void insert(StudentVO studentVO) {
		String id = studentVO.getId();
		if (checkId(id)) {
			studentDAO.insert(studentVO);
		}
		else {
			System.out.println("중복아이디입니다.");
		}
	}
	public boolean checkId(String id) {
		StudentVO studentVO = studentDAO.select(id);
		return studentVO == null? true:false;
	}
	
}
