package step9_04.student;

import java.util.Map;
//VO -> DAO -> Controller
public class StudentDAO {
	//[1]학생 아이디 추가
	public void insert(StudentVO st) {
		StudentRepository.getStDB().put(st.getId(), st);
	}
	//학생 아이디 선택 후 출력 
	public StudentVO select(String id) {
		return StudentRepository.getStDB().get(id);
	}
	
	public Map<String , StudentVO> getStudentDB(){
		return StudentRepository.getStDB();
	}

}
