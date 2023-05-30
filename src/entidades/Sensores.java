package entidades;

public class Sensores {

    private int idSensor;
    private String coordenadas;
    private int umidade;
    private float ph;
    private int potassio;
    private int temperatura;
  

    public Sensores() {
    }

    public Sensores(int numSensor, String coordenadas, int umidadeSolo, float ph, int potassioSolo, int temperaturaSolo) {
        this.idSensor = numSensor;
        this.coordenadas = coordenadas;
        this.umidade = umidadeSolo;
        this.ph = ph;
        this.potassio = potassioSolo;
        this.temperatura = temperaturaSolo;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int numSensor) {
        this.idSensor = numSensor;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String condenadas) {
        this.coordenadas = condenadas;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidadeSolo) {
        this.umidade = umidadeSolo;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public int getPotassio() {
        return potassio;
    }

    public void setPotassio(int potassioSolo) {
        this.potassio = potassioSolo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperaturaSolo) {
        this.temperatura = temperaturaSolo;

    }

    

    @Override
    public String toString() {
        return "\nID Sensor: " + idSensor + "\nCordenadas: " + coordenadas + "\nUmidade: " + umidade
                + "\nPH: " + ph + "\nPotassio: " + potassio + "\nTemperatura: " + temperatura;
    }

}
