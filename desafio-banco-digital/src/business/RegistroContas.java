package business;

import business.beans.Conta;
import data.IRepositoryConta;
import exceptions.ContaNaoExistenteException;
import exceptions.ContaNaoPodeSerDuplicadaException;

public class RegistroContas {
    private IRepositoryConta repository;

    public RegistroContas(IRepositoryConta instanciaRepositorio) {
        this.repository = instanciaRepositorio;
    }

    //Verifica se o numero da conta já existe.
    public boolean existe(String numero) {
        return this.repository.existe(numero);
    }

    //Procura conta pelo número da conta.
    public Conta procurarConta(String numero) throws ContaNaoExistenteException {
        return this.repository.procurarConta(numero);
    }

    //Remove conta do repositório.
    public void removerConta(String numero) throws ContaNaoExistenteException {
        this.repository.removerConta(numero);
        this.repository.salvarArquivo();
    }

    //Remove uma conta anteriormente registrda.
    public void removerRegistroDeConta(String numero) throws ContaNaoExistenteException {
        //Procura o numero da conta a ser removida no repositório de contas.
        Conta conta = this.repository.procurar(numero);
        //Verififica se a conta é nula e se o saldo é zero.
        if (conta != null && conta.getSaldo() == 0) {
            //Caso positivo, remove a conta e salva as alterações
            this.repository.removerConta(numero);
            this.repository.salvarArquivo();
        } else {
            //Se a conta não for encontrada, lança a exceção.
            throw new ContaNaoExistenteException(numero);
        }
    }

    //Realiza o registro de uma conta.
    public void registrarConta(Conta conta) throws ContaNaoPodeSerDuplicadaException {
        /**
         * Verifica se a String não é nula.
         * Caso seja nula, lança uma exceção.
         */
        if (conta == null) {
            throw new IllegalArgumentException("Parâmetro inválido");
        } else {
            /**
             * Verifica se o número da conta já existe.
             * Caso não exista, realiza o registro e salva.
             * Se o número já existe, lança uma exceção.
             */
            if (!this.existe(conta.getNumero())) {
                this.repository.registrarConta(conta);
                this.repository.salvarArquivo();
            } else {
                throw new ContaNaoPodeSerDuplicadaException(conta.getNumero());
            }
        }




    }

}
