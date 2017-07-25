package util;

import java.text.DecimalFormat;

public class Grafo {

	private int numVertice, posicao;
	private int[][] mat;
	private Vertice[] vertices;
	
	public Grafo() {
		vertices = new Vertice[numVertice]; //Inicia-se o vetor de vertices com o numero recebido.
        mat = new int[numVertice][numVertice]; //Inicia-se a matriz quadrada com o tamanho recebido.s
        this.numVertice = numVertice; //Armazena-se a quantidade máxima de vértices.
        
            //Percorre-se a Matriz zerando todas as ligações.
        for (int i = 0; i < this.numVertice; i++) { 
            for (int j = 0; j < this.numVertice; j++) {
                mat[i][j] = 0;
            }
        }
        posicao = 0; //Inicia-se a posicão para se percorrer o vetor.
	}

	public int getNumVertice() {
		return numVertice;
	}

	public void setNumVertice(int numVertice) {
		this.numVertice = numVertice;
	}

	public int[][] getMatrizAdj() {
		return mat;
	}

	public Vertice[] getVertices() {
		return vertices;
	}

	public void setVertices(Vertice[] vertices) {
		this.vertices = vertices;
	}
	
	public void insereVertice(Vertice p){
        if(posicao < numVertice) //Verificação se o numero maximo de vertices foi excedido.
            vertices[posicao++] = p;
    }
	
	public void insereAresta(String origem, String destino){
        int cont_origem = buscarVertice(origem); //Busca-se o inteiro correspondente ao vertice origem.
        int cont_destino = buscarVertice(destino); //Busca-se o inteiro correspondente ao vertice destino.
        
        //Calcula-se as distancias e essas são inseridas na matriz de adjacências.
        mat[cont_origem][cont_destino] = 10;
        mat[cont_destino][cont_origem] = 10;  
    }
	
	public int buscarVertice(String v){ 
		int aux = -1;
		for (int i = 0; i < vertices.length; i++) {
			Vertice p = vertices[i];
			if (p.equals(v)) {
				aux = i;
			}
		}
        return aux;
    }
	
	public void imprimeMatriz() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("   ");
        for (int i = 0; i < this.numVertice; i++) {
            System.out.print(" "+ i + "     ");
        }
        System.out.println();
        for (int i = 0; i < this.numVertice; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < this.numVertice; j++) {
                System.out.print(df.format(this.mat[i][j]) + "   ");
            }
            System.out.println();
        }
    }
	
}
