package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Atendente extends Thread{
	
    private Socket sktCli;
    private ConexaoTCP server;

    public Atendente(Socket sktCli, ConexaoTCP server) {
        this.sktCli = sktCli;
        this.server = server;
    }
    
    @Override
    public void run() {
    	try {
			ObjectOutputStream oo = new ObjectOutputStream(sktCli.getOutputStream());
			ObjectInputStream oi = new ObjectInputStream(sktCli.getInputStream());

	        String x = (String) oi.readObject();
	        String[] aux = x.split("@");

	        System.out.println(x);
	        
	        if (aux[0].equals("SL")) {
				//Retorna a lista de lugares disponiveis
	        	oo.writeObject("L");
                oo.flush();
			}else if (aux[0].equals("ODR")) {
				//retorna a lista de rotas para aquela origem e destino
				//Tem interação com os servidores
				oo.writeObject("LR");
                oo.flush();
			}else if (aux[0].equals("SR")) {
				//Processa a rota selecionada
				//Tem interação com os servidores
				oo.writeObject("RC");
                oo.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
