package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import model.User;
import model.UserMemento;

public class CareTaker {
	private ArrayList<UserMemento> stateList = new ArrayList<UserMemento>();
	
	public void addMemento(UserMemento memento){
		this.stateList.add(memento);
	}
	
	public UserMemento getMemento(Integer index){
		return this.stateList.get(index);
	}
}
