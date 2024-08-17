package pilares.poo.mensenger;

public class ComputadorPedrinho{

    public static void main(String[] args) {

        //Intânciação de objetos de todas as classes.
        MSNMessenger msn = new MSNMessenger();
        FacebookMessenger fcb = new FacebookMessenger();
        Telegran tlg = new Telegran();

        //Chamada de método.
        msn.enviarMensagem();
        msn.receberMensagem();
        fcb.enviarMensagem();
        fcb.receberMensagem();
        tlg.enviarMensagem();
        tlg.receberMensagem();
    }

}
