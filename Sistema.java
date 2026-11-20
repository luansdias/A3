import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Atendimento> atendimentos = new ArrayList<>();
    private ArrayList<Servico> servicos = new ArrayList<>();
    private int idCliente = 1;
    private int idServico = 1;
    private int idAtendimento = 1;
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
        System.out.println("Cliente removido com sucesso!");
    }
    
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }
    
    public void removerServico(Servico servico) {
        servicos.remove(servico);
        System.out.println("Serviço removido com sucesso!");
    }
    
    public void adicionarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }
    
     public void removerAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
    }
    
    public String gerarIDCliente() {
        return String.valueOf(idCliente++);
    }
    
    public String gerarIDServico() {
        return String.valueOf(idServico++);
    }
    
    public String gerarIDAtendimento() {
        return String.valueOf(idAtendimento++);
    }
    
    
    public void consultarClientes() {
        
        if(clientes.isEmpty()) {
            System.out.println("Nenhum cliente foi cadastrado.");
        }
        
        else {
            
        for(int x = 0; x < clientes.size(); x++) {
            System.out.println("=====Cliente " + (x+1) + "=====");
            System.out.println("Nome: " + clientes.get(x).getNome());
            System.out.println("Data Nascimento: " + clientes.get(x).getNascimento());
            System.out.println("Telefone: " + clientes.get(x).getTelefone());
            System.out.println("Email: " + clientes.get(x).getEmail());
            System.out.println("ID: " + clientes.get(x).getID());
            System.out.println("Hora do cadastro: " + clientes.get(x).getHoraRegistro());
            
        }
        
        }
    }
    
    public void consultarServicos() {

        if(servicos.isEmpty()) {
            System.out.println("Nenhum serviço foi cadastrado.");
      
        }

    else {
        
        for(int x = 0; x < servicos.size(); x++) {
            System.out.println("Serviço " + (x+1) + ":");
            System.out.println("Nome: " + servicos.get(x).getNomeServico());
            System.out.println("Preço: R$ " + servicos.get(x).getPrecoServico());
            System.out.println("ID: " + servicos.get(x).getID());
        }
        
        }
    }
    
    public void consultarAtendimentos() {

        if(atendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento foi cadastrado.");
   
        }

        else {
            
           for(int x = 0; x < atendimentos.size(); x++) {
               System.out.println("Atendimento " + (x+1) + ":");
               System.out.println("Cliente: " + atendimentos.get(x).getCliente().getNome());
               System.out.println("Serviço: " + atendimentos.get(x).getServico().getNomeServico());
               System.out.println("Data do atendimento: " + atendimentos.get(x).getHoraAtendimento());
               System.out.println("Pagamento realizado: " + atendimentos.get(x).getPagou());
               System.out.println("ID: " + atendimentos.get(x).getID());

                if(atendimentos.get(x).getPagou()) {
                   System.out.println("Data do pagamento: " + atendimentos.get(x).getHoraPagamento());
                   System.out.println("Método de pagamento: " + atendimentos.get(x).getMetodo());
            }
        }
    }
    
    }
    
    public void atualizarCliente(Cliente cliente, String nome, LocalDate nascimento, String telefone, String email) {

    cliente.setNome(nome);
    cliente.setNascimento(nascimento);
    cliente.setTelefone(telefone);
    cliente.setEmail(email);

    System.out.println("Cliente atualizado com sucesso!");
    
    }
    
    public void atualizarServico(Servico servico, String nome, double preco) {

    servico.setNomeServico(nome);
    servico.setPrecoServico(preco);

    System.out.println("Serviço atualizado com sucesso!");

    }
    
    public void consultarFaturas() {

    double totalRecebido = 0;

    System.out.println("=====FATURAS=====");

    for(int x = 0; x < atendimentos.size(); x++) {

        if(atendimentos.get(x).getPagou()) {

            System.out.println("\nCliente: " + atendimentos.get(x).getCliente().getNome());
            System.out.println("Serviço: " + atendimentos.get(x).getServico().getNomeServico());
            System.out.println("Valor Pago: R$ " + atendimentos.get(x).getPrecoCobrado());
            System.out.println("Método de pagamento: " + atendimentos.get(x).getMetodo());
            System.out.println("Data do pagamento: " + atendimentos.get(x).getHoraPagamento());

            totalRecebido += atendimentos.get(x).getPrecoCobrado();
        }
    }

    System.out.println("\nTotal recebido pela loja: R$ " + totalRecebido);
   
    }
    
    public Cliente buscarCliente(String id) {

    for(int x = 0; x < clientes.size(); x++) {

        if(clientes.get(x).getID().equals(id)) {
            return clientes.get(x);
        }
    }
    return null;
    
    }
    
    public Servico buscarServico(String id) {
        
        for(int x = 0; x < servicos.size(); x++) {
            if(servicos.get(x).getID().equals(id)) {
                return servicos.get(x);
            }
        }
        return null;
    }
    
    public Atendimento buscarAtendimento(String id) {
        
        for(int x = 0; x < atendimentos.size(); x++) {
            if(atendimentos.get(x).getID().equals(id)) {
                return atendimentos.get(x); 
               
            } 
        }
            return null; 
    }
}
        
    


        
        
            
        
    
       
    

    