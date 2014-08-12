package gui;

import model.User;

public class teste {

	public static void main(String[] args) {
		User u = new User();
		u.setEndereco("Rua 1, 0");
		u.setId(0L);
		u.setIdade(0);
		u.setNome("A");
		
		
		System.out.println(u);
	}

}
