package BancoDigital;

import java.util.Scanner;

public class Cliente {
    //atributos do cliente
    Scanner sc = new Scanner(System.in);
    int idClient ;
    String nome;
    String CPF;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.CPF = cpf;
    }


    public int getIdClient() {
        return idClient;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
