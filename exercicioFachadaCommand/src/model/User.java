package model;

import java.util.HashMap;

public class User {
	private Long id;
	private String nome;
	private String endereco;
	private Integer idade;
		
	public UserMemento createMemento(){
		return new UserMemento(this.getState());
	}
	
	public void setMemento(UserMemento memento){
		this.setState(memento.getState());
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Override
	public User clone(){
		User clone = new User();
		synchronized (this){
			clone.setEndereco(this.getEndereco());
			clone.setIdade(this.getIdade());
			clone.setNome(this.getNome());
		}
		
		return clone;
	}

	private HashMap<String, Object> getState(){
		HashMap<String, Object> state = new HashMap<String, Object>();
		state.put("id", this.id);
		state.put("nome", this.nome);
		state.put("endereco", this.endereco);
		state.put("idade", this.idade);
		
		return state;		
	}
	
	private void setState(HashMap<String, Object> state){
		this.id = (Long) state.get("id");
		this.nome = (String) state.get("nome");
		this.endereco = (String) state.get("endereco");
		this.idade = (Integer) state.get("idade");
	}
	
	public String toString(){
		return "UserId: " + this.id + "  Nome: " + this.nome + "  Endereço: " + this.endereco + "  Idade: " + this.idade;
	}
}
