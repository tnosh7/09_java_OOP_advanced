package step9_04.student;

public class Controller {
	
	private StudentDAO stDAO;
	private StudentInsert insert;
	private StudentSelect select;	
	private StudentSelectAll selectAll;
	
	public Controller() {
		stDAO = new StudentDAO();	
		insert = new StudentInsert(stDAO);
		select = new StudentSelect(stDAO);
		selectAll = new StudentSelectAll(stDAO);
	}
	// 입력은 DAO
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
