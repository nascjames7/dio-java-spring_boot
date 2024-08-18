package pilares.poo.mensenger.apps;

public class FacebookMessenger extends ServicoMensagemInstatanea {
    @Override
    public void enviarMensagem() {
        validarConectadoInternet();
        System.out.println("Enviando mensagem pelo FacebookMessenger.");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo FacebookMessenger.");
    }
}
