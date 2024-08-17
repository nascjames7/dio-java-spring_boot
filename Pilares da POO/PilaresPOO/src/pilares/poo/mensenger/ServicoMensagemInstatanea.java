package pilares.poo.mensenger;

public abstract class ServicoMensagemInstatanea {

    public abstract void enviarMensagem();
    public abstract void receberMensagem();

    private void validarConectadoInternet() {
        System.out.println("Validando conexão de internet.");
    }
    private void salvarHistoricoMensagem() {
        System.out.println("Salvando histórico de mensagens.");
    }
}
