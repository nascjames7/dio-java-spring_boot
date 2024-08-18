package pilares.poo.multi_tarefas;

import pilares.poo.multi_tarefas.equipamentos.impressora.DeskJet;
import pilares.poo.multi_tarefas.equipamentos.impressora.Impressora;

public class Fabrica {

    public static void main(String[] args) {

        //Instanciamento.
        Impressora impressora = new DeskJet();

       //Chamada dos métodos.

        impressora.imprimir();

    }
}
