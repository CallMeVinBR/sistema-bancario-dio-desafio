import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) throws IllegalArgumentException {
        if(!nome.isEmpty()) {
            setNome(nome.trim());
            this.contas = new ArrayList<>();
        }
        else
            throw new IllegalArgumentException("O nome deve ser preenchido.");
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public void obterContas(){
        System.out.println(contas);
    }
}
