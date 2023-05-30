package filas;

import entidades.Sensores;

public class FilaSensoresAnomalia {

    private class NO {
        Sensores dado;
        NO prox;
    }

    NO ini, fim;

    public void init() {
        ini = fim = null;
    }

    public boolean isEmpty() {
        if (ini == null && fim == null)
            return true;
        else
            return false;
    }

    public void enqueue(Sensores elem) {
        NO novo = new NO();
        novo.dado = elem;
        if (isEmpty())
            ini = novo;
        else
            fim.prox = novo;
        fim = novo;
    }

    public Sensores dequeue() {
        Sensores n = ini.dado;
        ini = ini.prox;
        if (ini == null)
            fim = null;
        return n;
    }

    public Sensores first() {
        return (ini.dado);
    }

    public void apresenta() {
        NO aux = ini;
        System.out.println("\n *** LISTA ***");
        while (aux != null) {
            System.out.println("\t " + aux.dado.toString());
            aux = aux.prox;
        }
    }
    
    public void esvaziar() {	
    	while(ini != null) {
    		ini = ini.prox;
    		
    	}
    	
    }

    public int contaNos() {

        int cont = 0;
        NO aux = ini;
        while (aux != null) {
            cont++;
            aux = aux.prox;
        }
        return cont;
    }

}
