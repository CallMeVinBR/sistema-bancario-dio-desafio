public class Main {

    public static void main(String[] args) throws IllegalArgumentException {

        Banco banco = new Banco("Banco 1");
        Cliente vinicius = new Cliente("Vinicius");
        Cliente alex = new Cliente("Alex");

        Conta correnteVinicius = new ContaCorrente(vinicius);
        Conta salarioAlex = new ContaSalario(alex);

        banco.adicionarConta(correnteVinicius);
        banco.adicionarConta(salarioAlex);

        correnteVinicius.depositar(100);
        salarioAlex.depositar(80);

        correnteVinicius.sacar(10);
        salarioAlex.sacar(10.5);

        correnteVinicius.imprimirExtrato();
        salarioAlex.imprimirExtrato();

        correnteVinicius.transferir(15, salarioAlex);
        salarioAlex.transferir(40, correnteVinicius);

        correnteVinicius.imprimirExtrato();
        salarioAlex.imprimirExtrato();

        banco.obterContas();
    }

}
