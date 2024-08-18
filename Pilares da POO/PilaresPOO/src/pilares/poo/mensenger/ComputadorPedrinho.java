package pilares.poo.mensenger;

public class ComputadorPedrinho{

    public static void main(String[] args) {

        //Intânciação de objetos de todas as classes.
        MSNMessenger msn = new MSNMessenger();
        FacebookMessenger fcb = new FacebookMessenger();
        Telegram tlg = new Telegram();

        //Instanciação de objeto vazio, pois esta classe é abstrata e não pode ser instanciada.
        ServicoMensagemInstatanea smi = null;

        /**
         * Não se sabe qual APP, mas qualquer um, deverá enviar e receber mensagens.
         */
        //Definição de variável que guarda o nome do APP escolhido.
        String appEscolhido = "msn";

        //Implementação de fluxo condicional para troca de APP escolhido.
        if(appEscolhido.equals("msn")) {
            //Instancia um objeto do tipo MSNMenssenger.
            smi = new MSNMessenger();
        }
        else if(appEscolhido.equals("fcb")) {
            //Instancia um objeto do tipo FacebookMenssenger.
            smi = new FacebookMessenger();
        }
        else if(appEscolhido.equals("tlg")) {
            //Instancia um objeto do tipo Telegram.
            smi = new Telegram();
        }

        smi.enviarMensagem();
        smi.receberMensagem();


        //Chamada de método.
        /**msn.enviarMensagem();
        msn.receberMensagem();
        fcb.enviarMensagem();
        fcb.receberMensagem();
        tlg.enviarMensagem();
        tlg.receberMensagem();
         */
    }

}
