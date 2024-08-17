package pilares.poo.mensenger;

public class FacebookMessenger extends ServicoMensagemInstatanea{
    @Override
    public void enviarMensagem() {
        System.out.println("Enviando mensagem pelo FacebookMessenger.");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo FacebookMessenger.");
    }
}
