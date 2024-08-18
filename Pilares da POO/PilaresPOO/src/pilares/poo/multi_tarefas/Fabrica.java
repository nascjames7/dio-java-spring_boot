package pilares.poo.multi_tarefas;

import pilares.poo.multi_tarefas.equipamentos.copiadora.Copiadora;
import pilares.poo.multi_tarefas.equipamentos.digitalizadora.Digitalizadora;
import pilares.poo.multi_tarefas.equipamentos.digitalizadora.Scaner;
import pilares.poo.multi_tarefas.equipamentos.impressora.DeskJet;
import pilares.poo.multi_tarefas.equipamentos.impressora.Impressora;
import pilares.poo.multi_tarefas.equipamentos.multifuncional.EquipamentoMultifuncional;

public class Fabrica {

    public static void main(String[] args) {

        //Instanciamento.
        Impressora impressora = new DeskJet();
        EquipamentoMultifuncional em = new EquipamentoMultifuncional();
        Scaner scaner = new Scaner();


        //Polimorfismo
        Impressora impres = em;
        Digitalizadora digit = em;
        Copiadora copy = em;

        //Chamada dos métodos.
        impres.imprimir();
        digit.digitalizar();
        copy.copiar();

    }
}
