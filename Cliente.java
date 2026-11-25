import java.time.LocalDateTime;
import java.time.LocalDate;

public class Cliente extends Pessoa {

    private LocalDateTime horaRegistro;
    private LocalDate nascimento;

    public Cliente(String nome, LocalDate nascimento, String telefone, String email, String id) {
        super(nome, telefone, email, id);
        this.nascimento = nascimento;
        this.horaRegistro = LocalDateTime.now();
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public LocalDateTime getHoraRegistro() {
        return horaRegistro;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        System.out.println("ID: " + getID());
        System.out.println("Nascimento: " + nascimento);
        System.out.println("Hora do registro: " + horaRegistro);
    }
}
