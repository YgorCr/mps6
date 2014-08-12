package model;

import java.util.HashMap;

public class CareTaker {
	private Long oldierState; 
	private Long currentState;
	private Long newestState;
	private Long maxSize;
	
	private HashMap<Long, User> states;
	
	CareTaker(User u, Long maxSize){
		this.maxSize = maxSize;
		this.currentState = 0L;
		this.oldierState = 0L;
		this.newestState = 0L;
		
		this.states = new HashMap<Long, User>();
		this.states.put(currentState, u.clone());
	}
	
	User undo(User u){
		if(this.currentState.compareTo(this.oldierState) == 0){
			User oldier = this.states.get(this.currentState);
			u.setEndereco(oldier.getEndereco());
			u.setIdade(oldier.getIdade());
			u.setNome(oldier.getNome());
			
			return null;
		}
		else{
			this.currentState--;
			
			User oldier = this.states.get(this.currentState);
			u.setEndereco(oldier.getEndereco());
			u.setIdade(oldier.getIdade());
			u.setNome(oldier.getNome());
			
			return u;
		}
	}
	
	User redo(User u){
		if(this.currentState.compareTo(this.newestState) == 0){
			return null;
		}
		else{
			this.currentState++;
			
			User oldier = this.states.get(this.currentState);
			u.setEndereco(oldier.getEndereco());
			u.setIdade(oldier.getIdade());
			u.setNome(oldier.getNome());
			
			return u;
		}
	}
	
	void save(User u){
		if(this.maxSize == this.states.size()
				&& this.currentState.compareTo(this.newestState) == 0){
			
			this.states.remove(this.oldierState);
			
			this.oldierState++;
			this.currentState++;
			this.newestState++;
			
			this.states.put(this.currentState, u.clone());
		}
		else{
			this.currentState++;
			this.states.put(this.currentState, u.clone());
			
			for(Long i = this.currentState+1; i <= this.newestState; i++){
				this.states.remove(i);
			}
			this.newestState = this.currentState;
		}
	}
	
	public String toString(){
		String memento =  "";
		for (Long i : this.states.keySet()) {
			memento += "Key: (" + i + ")  |  value: (" + this.states.get(i) + ")\n";
		}
		return memento;
	}
}
