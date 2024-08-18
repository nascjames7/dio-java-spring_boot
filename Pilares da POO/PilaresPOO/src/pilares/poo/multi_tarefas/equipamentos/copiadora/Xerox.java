package pilares.poo.multi_tarefas.equipamentos.copiadora;

import pilares.poo.multi_tarefas.equipamentos.digitalizadora.Digitalizadora;

public class Xerox implements Copiadora {

    @Override
    public void copiar() {
        System.out.println("Copiando.");
    }
}
