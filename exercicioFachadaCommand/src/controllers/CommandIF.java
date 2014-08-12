package controllers;

import java.util.HashMap;

public interface CommandIF {
	public Object execute(HashMap<String, Object> args);
}
