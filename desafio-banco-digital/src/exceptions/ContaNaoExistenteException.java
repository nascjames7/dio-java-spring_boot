package exceptions;

public class ContaNaoExistenteException extends Exception{
    private String numeroInexistente;

    public ContaNaoExistenteException(String numero) {
        super("A conta de número " + numero + " não existe (não foi localizada)!");
        this.numeroInexistente = numero;
    }

    public String getNumeroInexistente() {
        return numeroInexistente;
    }
}
