package pilares.poo.mensenger;

public abstract class ServicoMensagemInstatanea {

    public void enviarMensagem() {
        validarConectadoInternet();
        System.out.println("Enviando mensagem.");
        salvarHistoricoMensagem();
    }
    public void receberMensagem() {
        System.out.println("Recebendo mensagem.");
    }
    private void validarConectadoInternet() {
        System.out.println("Validando conexão de internet.");
    }
    private void salvarHistoricoMensagem() {
        System.out.println("Salvando histórico de mensagens.");
    }
}
