package BancoDigital;

public class ContaPoupanca extends Conta {
    String info;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.numero += 20000;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Poupan�a");
        super.imprimirInformacoes();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
     }


}
