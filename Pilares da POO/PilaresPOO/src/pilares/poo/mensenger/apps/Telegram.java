package pilares.poo.mensenger.apps;

public class Telegram extends ServicoMensagemInstatanea {
    @Override
    public void enviarMensagem() {
        validarConectadoInternet();
        System.out.println("Enviando mensagem pelo Telegran.");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo Telegran.");
    }
}
