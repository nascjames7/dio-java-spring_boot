package pilares.poo.mensenger;

public class MSNMessenger extends ServicoMensagemInstatanea{

    @Override
    public void enviarMensagem() {
        System.out.println("Enviando mensagem pelo MSNMessenger.");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo MSNMessenger.");
    }
}
