package BancoDigital;


import java.lang.invoke.SwitchPoint;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner dado = new Scanner(System.in);
        Scanner scDeposito = new Scanner(System.in);
        Scanner extrato = new Scanner(System.in);
        int opcao;
        int cpfExistente =0;
        List<Conta> contas = new ArrayList<Conta>();

    System.out.println("$$$$$$$$$$ B E M   V I N D O   A O   B A N C O   D I O $$$$$$$$$$$$\n\n" +
            "                   Por favor escolha uma opcao:\n" +
            " ***************** 1- Cria uma nova conta: \n" +
            " ***************** 2- Depositar: \n" +
            " ***************** 3- Sacar: \n" +
            " ***************** 4- Transferir: \n" +
            " ***************** 5- Exibir Extrato da conta \n" +
            " ***************** 6- Exibir todas as contas do banco:\n" +
            " ***************** 7- SAIR: ");

        opcao = sc.nextInt();
        while(opcao != 7){
            switch (opcao) {
                case 1:
                    System.out.println("Por favor digite o nome do Titular: ");
                    String nomeTitutlar = dado.nextLine();
                    System.out.println("Por favor digite o CPF do Titular:");
                    String cpfTitular = dado.nextLine();
                    System.out.println("Voce quer abrir uma conta corrente ou poupanca?\n" +
                            "1- conta corrente\n" +
                            "2- conta poupanca\n" +
                            "3- voltar");
                    opcao = sc.nextInt();

                    switch (opcao) {
                        /*verifica se o cpf do titular que vai ser criado já possui uma conta corrente*/
                        case 1:
                            for (Conta c : contas) {
                                if (c.cliente.getCPF().intern() == cpfTitular.intern()) {
                                    cpfExistente = 1;

                                } else {
                                    cpfExistente = 0;
                                }
                            }
                            if (cpfExistente != 1) {
                                contas.add(new ContaCorrente(new Cliente(nomeTitutlar, cpfTitular)));
                                System.out.println("******************************************\n" +
                                        "******  Conta Criada com sucesso ! ! !**** \n" +
                                        "******  seja bem vindo ao banco DIO   **** \n" +
                                        "******      " + nomeTitutlar + " \n" +
                                        "****************************************** \n");
                            } else {
                                System.out.println("Este CPF ja possui uma Conta Corrente no nosso Banco\n" +
                                        "por favor escolha uma nova opcao");
                            }
                            break;
                        case 2:
                            /*verifica se o cpf do titular que vai ser criado já possui uma conta Poupanca*/
                            cpfExistente = 0;
                            for (Conta c : contas) {
                                if (c.cliente.getCPF().intern() == cpfTitular.intern()) {
                                    cpfExistente = 1;

                                } else {
                                    cpfExistente = 0;
                                }
                            }
                            if (cpfExistente != 1) {
                                contas.add(new ContaPoupanca(new Cliente(nomeTitutlar, cpfTitular)));
                            } else {
                                System.out.println("Este CPF ja possui uma Conta Poupanca no nosso Banco\n" +
                                        "por favor escolha uma nova opcao");
                            }
                            break;
                        case 3:
                            break;

                        default:
                            System.out.println("opcao invalida");
                    }


                    break;
                case 2:

                    System.out.println("Por favor digitie o CPF ou numero da conta que deseja fazer o deposito");
                    String buscaDeposito = dado.nextLine();
                    int nDeposito;
                    String nContaTemp;
                    cpfExistente = 0;
                    /*verifica se o cpf ou numero digitado pertence a alguma conta do banco
                     * caso pertenca ele adiciona o valor desejado.
                     * caso contrario ele emite uma mensagem de aviso falando que a contra nao existe...
                     *
                     * usei a string nContaTemp para pois o cpf esta como String logo, para ele encontrar o numero
                     * ou o cpf usando apenas uma variavel de entrada de dado converti o numero da conta para string
                     * apenas a titulo de comparacao com oque foi digitado*/
                    for (Conta c : contas) {
                        cpfExistente = 0;
                        nContaTemp = Integer.toString(c.getNumero());
                        if (buscaDeposito.intern() == c.cliente.getCPF().intern() || nContaTemp.intern() == buscaDeposito.intern()) {
                            System.out.println("qual o valor que deseja depositar? ");
                            nDeposito = scDeposito.nextInt();
                            /*verifica se o valor do deposito é um valor válido (positivo)*/
                            if (nDeposito > 0) {
                                c.depositar(nDeposito);
                                System.out.println("R$ " + nDeposito + " Foram depositados na conta: " + c.getNumero() + "\n\n");
                                cpfExistente = 1;
                                break;
                            } else {
                                System.out.println("valor invalido por favor tente novamente");
                            }
                            cpfExistente = 1;
                            break;
                        }

                    }
                    if (cpfExistente == 0) {
                        System.out.println("Conta nao encontrada por favor tente novamente\n\n");
                    }
                    break;
                case 3:
                    System.out.println("Por favor digitie o CPF ou numero da conta que deseja fazer o Saque:");
                    buscaDeposito = dado.nextLine();
                    int nSaque;
                    String nContaTempSaque;
                    cpfExistente = 0;
                    /*exatamente como a funcao de deposito par averificar CONTA, apenas chamando a funcao de Saque na conta selecionada*/
                    for (Conta c : contas) {
                        cpfExistente = 0;
                        nContaTempSaque = Integer.toString(c.getNumero());
                        if (buscaDeposito.intern() == c.cliente.getCPF().intern() || nContaTempSaque.intern() == buscaDeposito.intern()) {
                            System.out.println("qual o valor que deseja Sacar? ");
                            nSaque = scDeposito.nextInt();
                            /*verifica se o valor do saque é um valor válido (positivo e maior que o valor que possui em conta)*/
                            if (nSaque > 0 && nSaque <= c.getSaldo()) {
                                c.sacar(nSaque);
                                System.out.println("R$ " + nSaque + " Foram sacados da conta: " + c.getNumero() + "\n\n");
                                cpfExistente = 1;
                                break;
                            } else {
                                System.out.println("voce nao pode sacar esse valor\n" +
                                        "por favor verifique o valor digitado e o saldo em conta");
                            }
                            cpfExistente = 1;
                            break;
                        }

                    }
                    if (cpfExistente == 0) {
                        System.out.println("Conta nao encontrada por favor tente novamente\n\n");
                    }

                    break;
                case 4:
                    Scanner scDestino = new Scanner(System.in);
                    Scanner scOrigem = new Scanner(System.in);
                    System.out.println("Por favor informe o CPF do titular da conta para qual deseja transferir:");
                    String contaDestino = scDestino.nextLine();
                    System.out.println("por favor informe o CPF do titular da conta origem que deseja fazer a trasnferencia:");
                    String contaOrigem = scOrigem.nextLine();
                    System.out.printf("qual valor deseja transferir ?");
                    double valor = dado.nextDouble();
                    int contaO, contaD;
                    contaO = contaD = 0;
                    //verifica se o valor da transferencia é positivo
                    if(valor < 0){
                        System.out.println("valor invalido por favor digite um valor valido\n\n");
                        break;
                    }

                    /*primeiro faz a verificaçao se o cpf de da conta de origem existe
                    * caso o cpf exista ele vai verificar se o cpf da conta destino existe
                    * os dois CPFs existindo ele vai realizar a transferencia da conta Oirgem para a destino
                    * as variaveis contaO e contaD são para fazer o check (estao inicializadas com 0 para caso nao exista
                    * assim podemos controlar qual conta esta com a entrada invalida*/

                    for (Conta a : contas) {
                     if(contaOrigem.intern() == a.cliente.getCPF().intern()){
                         contaO=1;
                         for(Conta c: contas){
                             if(contaDestino.intern() == c.cliente.getCPF().intern()){
                                 a.transferir(valor,a,c);

                                 contaD=1;
                                 break;
                             }
                         }
                     }

                    }
                    if(contaD==0){
                        System.out.printf("conta destino nao encontrada");
                    }
                    if(contaO==0){
                        System.out.println("conta origem nao encontrada");
                    }

                    break;
                case 5:
                    /*imprime o extrato de uma conta especifica */
                    System.out.println("Entre com o cpf do titular para poder mostrar o extrato: ");
                    String cpf =extrato.nextLine();
                    for (Conta c : contas){
                        if(cpf.intern() == c.cliente.getCPF().intern()) {
                            c.imprimirInformacoes();
                            cpfExistente=1;
                            break;
                        }
                    }
                    if (cpfExistente !=1){
                        System.out.println("conta nao encontrada no systema");
                    }


                    break;
                case 6:
                    /*imprime o extrato de todas as contas */
                    for (Conta c : contas){
                        c.imprimirInformacoes();
                    }
                    System.out.println("teste6");
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
            System.out.println("$$$$$$$$$$ B E M   V I N D O   A O   B A N C O   D I O $$$$$$$$$$$$\n\n" +
                    "                   Por favor escolha uma opcao:\n" +
                    " ***************** 1- Cria uma nova conta: \n" +
                    " ***************** 2- Depositar: \n" +
                    " ***************** 3- Sacar: \n" +
                    " ***************** 4- Transferir: \n" +
                    " ***************** 5- Exibir Extrato da conta \n" +
                    " ***************** 6- Exibir todas as contas do banco:\n" +
                    " ***************** 7- SAIR: ");
            opcao = sc.nextInt();
        }


    }

}
