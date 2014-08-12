package controllers;

import java.math.BigInteger;
import java.util.HashMap;

import model.User;

public class UserMemento {
	private BigInteger oldierState; 
	private BigInteger currentState;
	private BigInteger newestState;
	private Long maxSize;
	
	private static final BigInteger one = BigInteger.ONE;
	
	private HashMap<BigInteger, User> states;
	
	public UserMemento(User u, Long maxSize){
		this.maxSize = maxSize;
		this.currentState = new BigInteger("0");
		this.oldierState = new BigInteger("0");
		this.newestState = new BigInteger("0");
		
		this.states = new HashMap<BigInteger, User>();
		this.states.put(currentState, u.clone());
	}
	
	public User undo(User u){
		if(this.currentState.compareTo(this.oldierState) == 0){
			return null;
		}
		else{
			this.currentState = this.currentState.subtract(one);
			
			User oldier = this.states.get(this.currentState);
			u.setEndereco(oldier.getEndereco());
			u.setIdade(oldier.getIdade());
			u.setNome(oldier.getNome());
			
			return u;
		}
	}
	
	public User redo(User u){
		if(this.currentState.compareTo(this.newestState) == 0){
			return null;
		}
		else{
			this.currentState = this.currentState.add(one);

			User oldier = this.states.get(this.currentState);
			u.setEndereco(oldier.getEndereco());
			u.setIdade(oldier.getIdade());
			u.setNome(oldier.getNome());
			
			return u;
		}
	}
	
	public void save(User u){
		if(this.maxSize == this.states.size()
				&& this.currentState.compareTo(this.newestState) == 0){
			
			this.states.remove(this.oldierState);
			
			this.oldierState = this.oldierState.add(one);
			this.currentState = this.currentState.add(one);
			this.newestState = this.newestState.add(one);
			
			this.states.put(this.currentState, u.clone());
		}
		else{
			this.currentState = this.currentState.add(one);
			
			this.states.put(this.currentState, u.clone());
			
			for(BigInteger i = this.currentState.add(one); i.compareTo(this.newestState) != 0; i = i.add(one)){
				this.states.remove(i);
			}
			this.states.remove(this.newestState);
			
			this.newestState = this.currentState.add(one).subtract(one);
		}
	}
}
