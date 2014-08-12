package gui;

import controllers.CareTaker;
import model.User;

public class teste {

	public static void main(String[] args) {
		User u = new User();
		u.setEndereco("Rua 1, 0");
		u.setId(0L);
		u.setIdade(0);
		u.setNome("A");
		
		CareTaker uM = u.createMemento(10L); //salvo a instância só pra imprimir os testes
		
		u.setEndereco("Rua 2, 0");
		u.saveState();
		u.setEndereco("Rua 3, 0");
		u.saveState();
		u.setEndereco("Rua 4, 0");
		u.saveState();
		u.setEndereco("Rua 5, 0");
		u.saveState();
		u.setEndereco("Rua 6, 0");
		u.saveState();
		u.setEndereco("Rua 7, 0");
		u.saveState();
		u.setEndereco("Rua 8, 0");
		u.saveState();
		u.setEndereco("Rua 9, 0");
		u.saveState();
		u.setEndereco("Rua 10, 0");
		u.saveState();
		u.setEndereco("Rua 11, 0");
		u.saveState();
		
		System.out.println(uM.toString());
		
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		u.undo();
		
		u.setNome("aeee");
		u.saveState();
		
		System.out.println(uM.toString());
		
		System.out.println(u);
	}

}
