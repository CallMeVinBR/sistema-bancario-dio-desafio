import lombok.Data;

@Data
public class Cliente {
    private String nome;

    public Cliente(String nome) throws IllegalArgumentException {
        if (!nome.isEmpty())
            setNome(nome.trim().toUpperCase());
        else
            throw new IllegalArgumentException("O nome deve ser preenchido.");
    }
}
