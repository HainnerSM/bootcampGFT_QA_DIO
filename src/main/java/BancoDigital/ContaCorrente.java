package BancoDigital;


import com.sun.security.ntlm.Client;

import java.util.ArrayList;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente) {
        super(cliente);
        super.numero += 10000;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Conta Corrente");
        super.imprimirInformacoes();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
    }





}