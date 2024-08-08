import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public abstract class Conta implements IConta {

    protected Cliente cliente;
    private int agencia;
    private int numero;
    private double saldo;

    protected static final int AGENCIA_PADRAO = 1;
    protected static final AtomicInteger AUTO = new AtomicInteger(1);

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        // Adicionar 1 para cada get, em ".getAndIncrement()"
        // Mesma coisa que o AUTO_INCREMENT em SQL
        // Thread-safe
        this.numero = AUTO.getAndIncrement();
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor){
        if(valor <= 0 || valor > saldo)
            throw new IllegalArgumentException("Valor invalido para saque!");
        else
            saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if(valor <= 0)
            throw new IllegalArgumentException("Valor invalido para deposito!");
        else
            saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino){
        if(valor <= 0 || valor > saldo)
            throw new IllegalArgumentException("Valor invalido para transferencia!");
        else {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    protected void infosConta() {
        System.out.printf("Titular: %s\n", cliente.getNome());
        System.out.printf("Agencia: %d\n", getAgencia());
        System.out.printf("Numero: %d\n", getNumero());
        System.out.printf("Saldo: %.2f\n", getSaldo());
    }
}
