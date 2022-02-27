package BancoDigital;

import java.util.ArrayList;

public abstract class Conta implements IConta {
    protected static final int AGENCIA_PADRAO = 1932;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }



    @Override
    public void sacar(double valor) {
        saldo -= valor;

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor,Conta origem, Conta contaDestino) {
        origem.sacar(valor);
        contaDestino.depositar(valor);

    }

    protected void imprimirInformacoes(){
        System.out.println("~~~~~~~~INFORMACOES~~~~~~");
        System.out.println("Titular: " + this.cliente.nome);
        System.out.println("CPF do Titular: " + this.cliente.CPF);


        System.out.println("Agencia: " +this.agencia);
        System.out.println("Conta "+ this.numero);
        System.out.printf("Saldo atual: R$ %.2f\n\n",this.saldo);

    }



    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getClienteNome() {
        return cliente.nome;
    }



}