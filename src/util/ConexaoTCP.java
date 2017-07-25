package util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexaoTCP extends Thread{
	
	private ServerSocket sskt;
	private Socket skt;
	private int porta;
	
	public ConexaoTCP(int porta) {
		this.porta = porta;
		
		
	}
	
	public void run() {

        try {
            sskt = new ServerSocket(porta);
            System.out.println("criou a thread");
            while (true) {
                skt = sskt.accept();
                new Atendente(skt, this).start();

            }
        } catch (IOException ex) {
            System.out.println("Deu rum em criar o socket");
        }
    }

}
