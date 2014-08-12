package model;

import java.util.HashMap;

public class UserMemento{
		private HashMap<String, Object> state;
		
		UserMemento(HashMap<String, Object> state){
			this.state = state;
		}
		
		HashMap<String, Object> getState(){
			return this.state;
		}
}
