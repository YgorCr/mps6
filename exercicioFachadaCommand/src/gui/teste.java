package gui;

import java.math.BigInteger;

import controllers.UserMemento;
import model.User;

public class teste {

	public static void main(String[] args) {
		User u = new User();
		u.setEndereco("Rua 1, 0");
		u.setId(0L);
		u.setIdade(0);
		u.setNome("A");
		
		UserMemento uM = new UserMemento(u, 10L);

		u.setEndereco("Rua 2, 0");
		uM.save(u);
		u.setEndereco("Rua 3, 0");
		uM.save(u);
		u.setEndereco("Rua 4, 0");
		uM.save(u);
		u.setEndereco("Rua 5, 0");
		uM.save(u);
		u.setEndereco("Rua 6, 0");
		uM.save(u);
		u.setEndereco("Rua 7, 0");
		uM.save(u);
		u.setEndereco("Rua 8, 0");
		uM.save(u);
		u.setEndereco("Rua 9, 0");
		uM.save(u);
		u.setEndereco("Rua 10, 0");
		uM.save(u);
		u.setEndereco("Rua 11, 0");
		uM.save(u);
		
		System.out.println(uM.toString());

		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		uM.undo(u);
		
		u.setNome("aeee");
		uM.save(u);
		
		System.out.println(uM.toString());
		
		System.out.println(u);
	}

}
