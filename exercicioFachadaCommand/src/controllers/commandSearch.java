package controllers;

import infra.DaoUser;

import java.util.HashMap;

public class commandSearch extends CommandAB{
	@Override
	public Object execute(HashMap<String, Object> args) {
		Long max, offset;

		if(args.containsKey("offset")){
			offset = (Long) args.get("offset");
			args.remove("offset");
		}
		else{
			offset = 0L;
		}
		
		if(args.containsKey("max")){
			max = (Long) args.get("max");
			args.remove("max");
			
			return DaoUser.getInstance().findBy(args, max, offset);
		}
		
		return DaoUser.getInstance().findBy(args);
	}
}
