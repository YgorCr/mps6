package model;

public class User {
	private Long id;
	private String nome;
	private String endereco;
	private Integer idade;
	
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
	
	public String toString(){
		return "UserId: " + this.id + "  Nome: " + this.nome + "  Endereço: " + this.endereco + "  Idade: " + this.idade;
	}
}
