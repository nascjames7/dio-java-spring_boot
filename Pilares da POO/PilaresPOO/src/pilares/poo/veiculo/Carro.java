package pilares.poo.veiculo;

//Utilização de herança.
public class Carro extends Veiculo {


    //Métodos diversos.
    public void ligar() {

        //Encapsulamento de métodos dentro de outro método (public -> private).
        confereCombustivel();
        confereCambio();

        System.out.println("carro ligado");
    }

    private void confereCombustivel() {
        System.out.println("conferindo combustível");
    }

    private void confereCambio() {
        System.out.println("conferindo câmbio em P");
    }


}
