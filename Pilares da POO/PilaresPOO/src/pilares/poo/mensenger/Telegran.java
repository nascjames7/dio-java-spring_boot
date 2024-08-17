package pilares.poo.mensenger;

public class Telegran extends ServicoMensagemInstatanea{
    @Override
    public void enviarMensagem() {
        System.out.println("Enviando mensagem pelo Telegran.");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo Telegran.");
    }
}
