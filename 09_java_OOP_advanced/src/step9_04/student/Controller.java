package step9_04.student;

public class Controller {
	
	private StudentDAO stDAO; 			//StudentDAO에 저장된 데이터 - 클래스 호출 --> DAO는 학생Repository클래스의 데이터를 참조한다. 
	private StudentInsert insert;
	private StudentSelect select;	
	private StudentSelectAll selectAll;
	//getsetter
	public Controller() {
		stDAO = new StudentDAO();	
		insert = new StudentInsert(stDAO);
		select = new StudentSelect(stDAO);
		selectAll = new StudentSelectAll(stDAO);
	}
	public StudentDAO getStDAO() {
		return stDAO;
	}
	
	public void setStDAO(StudentDAO stDAO) {
		this.stDAO = stDAO;
	}
	// [1]추가
	public StudentInsert getInsert() {
		return insert;
	}
	
	public void setInsert(StudentInsert insert) {
		this.insert = insert;
	}
	//[4]출력 - 아이디 선택 
	public StudentSelect getSelect() {
		return select;
	}
	
	public void setSelect(StudentSelect select) {
		this.select = select;
	}
	//[5]전체 출력 
	public StudentSelectAll getSelectAll() {
		return selectAll;
	}
	
	public void setSelectAll(StudentSelectAll selectAll) {
		this.selectAll = selectAll;
	}
	
}
