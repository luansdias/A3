import java.time.LocalDateTime;
import java.time.LocalDate;
public class Cliente {
    
    private String nome, telefone, email, id;
    private LocalDateTime horaRegistro;
    private LocalDate nascimento;
    
    
    public Cliente(String nome, LocalDate nascimento, String telefone, String email, String id) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.email = email;
        this.id = id;
        this.horaRegistro = LocalDateTime.now();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    public LocalDate getNascimento() {
        return nascimento;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getID() {
        return id;
    }
    
    public LocalDateTime getHoraRegistro() {
        return horaRegistro;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
