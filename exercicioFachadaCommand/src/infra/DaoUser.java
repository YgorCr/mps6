package infra;

import java.util.HashMap;

import model.User;

public class DaoUser extends DaoMemo<User>{
	private DaoUser dao;
	private Long myId;
	private HashMap<Long,User> bd;
	
	private DaoUser(){
		this.myId = 0L;
		bd = new HashMap<Long, User>();
	}
	
	@Override
	public User create(HashMap<String, Object> obj) {
		// TODO Auto-generated method stub
		
		User u = new User();
		
		
		return null;
	}

	@Override
	protected HashMap<Long, User> getDB() {
		// TODO Auto-generated method stub
		return null;
	}

}