package pilares.poo.veiculo;

public class Autodromo {

    public static void main(String[] args) {

        //Instância da classe carro (um objeto).
        Carro jeep = new Carro();

        //Chamada de procedimento.
        //jeep.confereCombustivel(); -> foi encapsulado no método ligar
        //jeep.confereCambio(); -> foi encapsulado no método ligar
        jeep.ligar();

        //Instância da classe moto (um objeto).
        Moto z400 = new Moto();

        //Chamada de procedimento.
        z400.ligar();

        //Método set.
        z400.setChassi("456987");
        jeep.setChassi("456123");

        //Clonando um objeto a partir de outro.
        Veiculo coringa01 = jeep;
        coringa01.ligar();

        Veiculo coringa02 = z400;
        coringa02.ligar();

    }
}
