package pilares.poo.mensenger.apps;

public class MSNMessenger extends ServicoMensagemInstatanea {

    @Override
    public void enviarMensagem() {
        validarConectadoInternet();
        System.out.println("Enviando mensagem pelo MSNMessenger.");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo MSNMessenger.");
    }
}
