package listas;

import entidades.Sensores;
import filas.FilaSensoresAnomalia;

public class ListaSensoresDesc {
    private final int MAXTEMP = 30;
    private final int MINTEMP = 20;
    private final int MAXUMIDADE = 80;
    private final int MINUMIDADE = 50;
    private final int MAXPH = 7;
    private final int MINPH = 6;

    private class NO {
        Sensores dado;
        NO prox;
    }

    private NO lista = null;

    public void insere(Sensores elem) {
        NO novo = new NO();
        novo.dado = elem;
        if (lista == null) {
            novo.prox = null;
            lista = novo;
        } else {
            if (novo.dado.getTemperatura() > lista.dado.getTemperatura()) {
                novo.prox = lista;
                lista = novo;
            } else {
                NO aux = lista;
                boolean achou = false;
                while (aux.prox != null && !achou) {
                    if (aux.prox.dado.getTemperatura() > novo.dado.getTemperatura())
                        aux = aux.prox;
                    else
                        achou = true;
                }
                novo.prox = aux.prox;
                aux.prox = novo;
            }
        }
    }

    public boolean remove(String cordenada) {
        boolean achou = false;
        if (lista != null) {
            if (cordenada == lista.dado.getCoordenadas()) {
                achou = true;
                lista = lista.prox;
            } else {
                NO aux = lista;
                while (aux.prox != null && !achou) {
                    if (aux.prox.dado.getCoordenadas() != cordenada)
                        aux = aux.prox;
                    else {
                        achou = true;
                        aux.prox = aux.prox.prox;
                    }
                }
            }
        }
        return achou;
    }

    public int contaNos() {

        int cont = 0;
        NO aux = lista;
        while (aux != null) {
            cont++;
            aux = aux.prox;
        }
        return cont;
    }

    public String procurarSensor(String cordenada) {
        boolean achou = false;
        if (lista != null) {
            if (cordenada.equalsIgnoreCase(lista.dado.getCoordenadas())) {
                achou = true;
                return lista.dado.toString();
            } else {
                NO aux = lista;
                while (aux.prox != null && !achou) {
                    if (!aux.prox.dado.getCoordenadas().equalsIgnoreCase(cordenada))
                        aux = aux.prox;
                    else {
                        achou = true;
                        return aux.prox.dado.toString();
                    }
                }

            }
        }
        if (achou == false)
            System.out.println("Nao encontrado!");
        return null;
    }

    public FilaSensoresAnomalia procurarAnomalia() {
        FilaSensoresAnomalia listaDeAnomalia = new FilaSensoresAnomalia();
        if (lista != null) {
            NO aux = lista;
            while (aux != null) {
                int temp = aux.dado.getTemperatura();
                float ph = aux.dado.getPh();
                int umidade = aux.dado.getUmidade();

                if (temp > MAXTEMP || ph > MAXPH || umidade > MAXUMIDADE || temp < MINTEMP || ph < MINPH
                        || umidade < MINUMIDADE) {
                    
                    listaDeAnomalia.enqueue(aux.dado);
                }

                aux = aux.prox;
            }
        }
        return listaDeAnomalia;
    }

    public void apresenta() {
        NO aux = lista;
        System.out.println("\n *** LISTA ***");
        while (aux != null) {
            System.out.println("\t " + aux.dado.toString());
            aux = aux.prox;
        }
    }

}
