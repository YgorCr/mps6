package model;

public class User {
	private String nome;
	private String endereco;
	private Integer idade;
	
	
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
	public Object clone() throws CloneNotSupportedException {
		User clone = new User();
		synchronized (this){
			clone.setEndereco(this.getEndereco());
			clone.setIdade(this.getIdade());
			clone.setNome(this.getNome());
		}
		
		return clone;
	}
}
