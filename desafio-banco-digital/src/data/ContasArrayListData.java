package data;

import business.beans.Cliente;
import business.beans.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContasArrayListData extends AbstractArrayListData<Conta>{

    public ContasArrayListData() {
        super();

        Cliente client = new Cliente("Anderson", "5494130-45");
        // Exemplo de chamada de código da super classe com tipo definido
        Conta newObj = new Conta("8976-8", 200.50, client);
        this.create(newObj);
    }

    public List<Conta> listarContasIndadimplentes() {
        List<Conta> sublista = new ArrayList<>();
        for (Conta conta : this.elements) {
            if (conta.getSaldo() < 0) {
                sublista.add(conta);
            }
        }
        return sublista;
    }
}
