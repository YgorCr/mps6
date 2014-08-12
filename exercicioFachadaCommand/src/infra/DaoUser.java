package infra;

import java.util.HashMap;

import model.User;

public class DaoUser extends DaoMemo<User>{
	private static DaoUser dao;
	private Long myId;
	private HashMap<Long,User> bd;
	
	private DaoUser(){
		this.myId = 0L;
		bd = new HashMap<Long, User>();
	}
	
	public static DaoIF<User> getInstance(){
		if(DaoUser.dao == null){
			DaoUser.dao =  new DaoUser();
		}
		
		return DaoUser.dao;
	}
	
	@Override
	public User create(HashMap<String, Object> obj) {
		// TODO Auto-generated method stub
		
		User u = new User();
		obj.put("id", myId++);
		this.setCampos(obj, u);
		this.bd.put(u.getId(), u);
		
		return u;
	}

	@Override
	protected HashMap<Long, User> getDB() {
		// TODO Auto-generated method stub
		return this.bd;
	}

}
