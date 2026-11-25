public abstract class Pessoa {

    private String nome, telefone, email, id;

    public Pessoa(String nome, String telefone, String email, String id) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.id = id;
    }

    public abstract void exibirInformacoes();
    
        public String getNome() {
        return nome;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public String getID() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
