public class ContaSalario extends Conta {

    public ContaSalario(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        infosConta();
    }
}
