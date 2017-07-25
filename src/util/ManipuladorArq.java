package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManipuladorArq {

	private FileReader fr;
	private BufferedReader bf;
	private int num;
	private String inicio, fim;
	
	private String[] lerarq(){
		try {
			fr =  new FileReader("Destino.txt");
			bf = new BufferedReader(fr);
			
			String x = bf.readLine();
			
			String[] aux = x.trim().split(";");
			
			return aux;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Não achou o arquivo!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String [] a = {"deu ruim"};
		return  a;
	}
	
}
