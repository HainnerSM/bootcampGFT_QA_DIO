package BancoDigital;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor,Conta origem, Conta contaDestino);

    void imprimirExtrato();

}
