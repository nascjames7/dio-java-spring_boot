package pilares.poo.mensenger.apps;

public abstract class ServicoMensagemInstatanea {

    public abstract void enviarMensagem();
    public abstract void receberMensagem();
    //Apenas filhos conhecem esse método.
    protected void validarConectadoInternet() {
        System.out.println("Validando se está conetado a internet.");
    }
    private void salvarHistoricoMensagem() {
        System.out.println("Salvando histórico de mensagens.");

    }

}
