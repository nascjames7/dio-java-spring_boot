package pilares.poo.multi_tarefas.equipamentos.multifuncional;

import pilares.poo.multi_tarefas.equipamentos.copiadora.Copiadora;
import pilares.poo.multi_tarefas.equipamentos.digitalizadora.Digitalizadora;
import pilares.poo.multi_tarefas.equipamentos.impressora.Impressora;

public class EquipamentoMultifuncional implements Copiadora, Digitalizadora, Impressora {
    @Override
    public void copiar() {
        System.out.println("Copiando via equipamento multifuncional.");
    }

    @Override
    public void digitalizar() {
        System.out.println("Digitalizando via equipamento multifuncional.");
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo via equipamento multifuncional.");
    }
}
