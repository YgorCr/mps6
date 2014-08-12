package controllers;

import java.util.HashMap;

import model.User;

public class UserMemento {
	private Integer currentState = 0;
	private HashMap<Integer, User> states;
	
	public UserMemento(User u){
		this.states = new HashMap<Integer, User>();
		this.states.put(currentState, u);
	}
	
	public User undo(User u){
		
		
		return null;
	}
}
