package controllers;

import infra.DaoUser;

import java.util.HashMap;

public class CommandUpdate extends CommandAB{
	@Override
	public Object execute(HashMap<String, Object> args) {
		Long id = (Long) args.get("id");
		args.remove("id");
		DaoUser.getInstance().update(id, args);
		
		return null;
	}
}
