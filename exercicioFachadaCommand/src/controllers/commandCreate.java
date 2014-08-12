package controllers;

import infra.DaoUser;

import java.util.HashMap;

public class commandCreate extends CommandAB {
	@Override
	public Object execute(HashMap<String, Object> args) {
		return DaoUser.getInstance().create(args);
	}
}
