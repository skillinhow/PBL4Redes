package view;

import util.ConexaoTCP;

public class Interface {

	public static void main(String[] args) {
		ConexaoTCP c = new ConexaoTCP(5000);
		c.start();
		System.out.println("foi");

	}

}
