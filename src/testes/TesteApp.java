package testes;

import java.util.Random;
import java.util.Scanner;

import entidades.Sensores;
import filas.FilaSensoresAnomalia;
import listas.ListaSensoresDesc;

public class TesteApp {
    public static final float PH_MIN = (float) 3;
    public static final float PH_MAX = (float) 9;
    public static final int UMIDADE_MIN = 20;
    public static final int UMIDADE_MAX = 70 - UMIDADE_MIN;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        ListaSensoresDesc listaSensores = new ListaSensoresDesc();
        FilaSensoresAnomalia filaSensoresAnomalia = new FilaSensoresAnomalia();

        String coordenadasSensores[] = { "47°55'44\"W,21°00'34\"S", "47°55'42\"W,21°00'35\"S",
                "47°55'39\"W,21°00'37\"S",
                "47°55'44\"W,21°00'39\"S", "47°55'40\"W,21°00'40\"S", "47°55'32\"W,21°00'34\"S",
                "47°55'28\"W,21°00'34\"S",
                "47°55'28\"W,21°00'38\"S", "47°55'33\"W,21°00'39\"S" };
        int n = coordenadasSensores.length;

        for (int i = 0; i < n; i++) {
            int umidade = r.nextInt(UMIDADE_MAX) + UMIDADE_MIN;
            float ph = PH_MAX - (PH_MIN * ((float) r.nextInt(10) / 10));
            int potassio = r.nextInt(1000);
            int temp = r.nextInt(40);
            Sensores sensorNew = new Sensores(i, coordenadasSensores[i], umidade, ph, potassio, temp);
            listaSensores.insere(sensorNew);
        }

        int opcao = 0;

        do {
            System.out.println("0 - Encerra o programa");
            System.out.println("1 - Novo Sensor");
            System.out.println("2 - Mostrar Sensores");
            System.out.println("3 - Procurar sensor");
            System.out.println("4 - Buscar anomalias");
            
            opcao = input.nextInt();
            switch (opcao) {
                case 0:

                    break;
                case 1:

                    Sensores sensor = new Sensores();

                    System.out.println("Digite a cordenada do sensor: ");
                    input.nextLine();
                    sensor.setCoordenadas(input.nextLine());
                    System.out.println("Digite a umidade do solo: ");
                    sensor.setUmidade(input.nextInt());
                    System.out.println("Digite o ph do solo: ");
                    sensor.setPh(input.nextFloat());
                    System.out.println("Digite o potassio do solo: ");
                    sensor.setPotassio(input.nextInt());
                    System.out.println("Digite o temperatura do solo: ");
                    sensor.setTemperatura(input.nextInt());

                    listaSensores.insere(sensor);
                    System.out.println("Sensor registrado com sucesso!");
                    break;
                case 2:
                    listaSensores.apresenta();
                    System.out.println("Sensores encontrados: " +  listaSensores.contaNos());
                    break;
                case 3:
                    String cordenadaProcurada = null;
                    System.out.println("Digite a cordenada desejada: ");
                    cordenadaProcurada = input.next();
                    System.out.println(listaSensores.procurarSensor(cordenadaProcurada) + "\n");

                    break;
                case 4:
                    filaSensoresAnomalia = listaSensores.procurarAnomalia();
                    filaSensoresAnomalia.apresenta();
                    System.out.println("Anomalias encontradas: " + filaSensoresAnomalia.contaNos());

                    break;

                default:
                    System.out.println("Opcao Invalida!\n");
            }
        } while (opcao != 0);

        input.close();
    }
}
