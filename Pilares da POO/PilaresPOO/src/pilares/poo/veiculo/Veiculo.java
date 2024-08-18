package pilares.poo.veiculo;


//Utilização de abstração.
public abstract class Veiculo {

    //Atributos
    private String chassi;

    //Aplicação de Java Beans (getters  and setters).
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public abstract void ligar();
}
