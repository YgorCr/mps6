package gui;

import java.math.BigInteger;

import controllers.UserMemento;
import model.User;

public class teste {

	public static void main(String[] args) {
		User u = new User();
		u.setEndereco("Rua A, 0");
		u.setId(0L);
		u.setIdade(0);
		u.setNome("A");
		
		System.out.println(u);
		
		UserMemento uM = new UserMemento(u, 10L);
		
		u.setEndereco("Rua B, 0");
		uM.save(u);
		
		System.out.println(uM.toString());
		System.out.println(u);
		
		u = uM.undo(u);
		
		System.out.println(u);
	}

}
