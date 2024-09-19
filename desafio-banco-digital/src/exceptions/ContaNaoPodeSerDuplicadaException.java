package exceptions;

public class ContaNaoPodeSerDuplicadaException extends Exception{
    private String numero;

    public ContaNaoPodeSerDuplicadaException(String numero) {
        super("Proibida a duplicação de conta existente!" +
                "A conta de número " + numero + " já existe e não pode ser duplicada!");
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

}
