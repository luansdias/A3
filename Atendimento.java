import java.time.LocalDateTime;
public class Atendimento {
    
    private Cliente cliente;
    private Servico servico;
    private LocalDateTime horaAtendimento;
    private boolean pagou;
    private LocalDateTime horaPagamento;
    private String metodo;
    private String id;
    private double precoCobrado;
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public Servico getServico() {
        return servico;
    }
    
    public LocalDateTime getHoraAtendimento() {
        return horaAtendimento;
    }
    
    public boolean getPagou() {
        return pagou;
    }

    public LocalDateTime getHoraPagamento() {
        return horaPagamento;
    }

    public String getMetodo() {
        return metodo;
    }
    
    public String getID() {
        return id;
    }
    
    public double getPrecoCobrado() {
        return precoCobrado;
    }
    
    public Atendimento(Cliente cliente, Servico servico, String id) {
       
        this.cliente = cliente;
        this.servico = servico;
        this.id = id; 
        this.precoCobrado = servico.getPrecoServico();
        this.horaAtendimento = LocalDateTime.now();
    }
    
    public void realizarPagamento(double valorPago, String metodo) {
        
         if(pagou == true) {
            System.out.println("O pagamento já foi realizado.");
            return;
        }
        
        if(valorPago < precoCobrado) {
            System.out.println("Pagamento insuficiente.");
            pagou = false;
        }
        
        else if (valorPago > precoCobrado) {
            System.out.println("Pagamento realizado! \nSeu troco é: " + (valorPago - precoCobrado));
            this.pagou = true;
            horaPagamento = LocalDateTime.now();
            this.metodo = metodo;
        }
        
        else if (valorPago == precoCobrado) {
            System.out.println("Pagamento realizado!");
            this.pagou = true;
            horaPagamento = LocalDateTime.now();
            this.metodo = metodo;
        }
    }
    
    
}