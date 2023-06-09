package step9_04.student;
public class StudentInsert {
	//[1]아이디 추가할 때 아이디중복 체크 클래스 
	private StudentDAO studentDAO;
	
	//생성자를 이용
	public StudentInsert(StudentDAO stDAO) {
		this.studentDAO = stDAO;
	}	
	
	public void insert(StudentVO studentVO) {
		String id = studentVO.getId();
		if (checkId(id)) {
			studentDAO.insert(studentVO);
		}
		else {
			System.out.println("중복아이디 입니다");
		}
	}
	
	// ? 참 : 거짓 
	public boolean checkId(String id) {
		StudentVO studentVO = studentDAO.select(id);
		return studentVO == null? true:false;
	}
	
}
