public class Servico {
    
    private String nomeServico;
    private double precoServico;
    private String id;
    
    
    public String getNomeServico() {
        return nomeServico;
    }
    
    public double getPrecoServico() {
        return precoServico;
    }
    
    public String getID() {
        return id;
    }
    
    public Servico(String nome, double preco, String id) {
        this.nomeServico = nome;
        this.precoServico = preco;
        this.id = id;
    }
    
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public void setPrecoServico(double precoServico) {
        this.precoServico = precoServico;
    }
    
}