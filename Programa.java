import java.time.LocalDate;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        
        Sistema sistema = new Sistema();
        
        Scanner leia = new Scanner(System.in);
        
        while(true) {
            
            System.out.println("BEM-VINDO A BARBEARIA! \n-----–---------------- \nESCOLHA UMA DAS SEGUINTES OPÇÕES: " +
            "\n1: Cadastrar um cliente, serviço ou atendimento. \n2: Gerenciar clientes, serviços, faturas ou atendimentos." +
            "\n3: Encerrar o programa. \n----------------------");
            
            int resposta = leia.nextInt();
            
            while(resposta != 1 && resposta != 2 && resposta != 3) {
                System.out.println("Opção Inválida. Por favor, digite novamente.");
                resposta = leia.nextInt();
            }
            
            if(resposta == 3) {
                break;
            }
            
            
            if(resposta == 1) {
                System.out.println("Se deseja cadastrar um cliente, digite 1. \nSe deseja cadastrar um serviço, digite 2"
                + "\n3: Se deseja cadastrar um atendimento, digite 3.");
                int a = leia.nextInt();
                while(a != 1 && a != 2 && a != 3) {
                    System.out.println("Opção inválida. Por favor, digite novamente.");
                    a = leia.nextInt();
                }
                
                leia.nextLine();
                
                if(a == 1) {
                    System.out.println("Digite o nome do cliente:");
                    String nome = leia.nextLine();
                    System.out.println("Digite a data de nascimento do cliente:");
                    LocalDate nascimento = LocalDate.parse(leia.nextLine());
                    System.out.println("Digite o telefone do cliente:");
                    String telefone = leia.nextLine();
                    System.out.println("Digite o email do cliente:");
                    String email = leia.nextLine();
                    
                    Cliente cliente = new Cliente(nome, nascimento, telefone, email, sistema.gerarIDCliente());
                    sistema.adicionarCliente(cliente);
                }
                
                if(a == 2) {
                    System.out.println("Digite o nome do serviço:");
                    String ns = leia.nextLine();
                    System.out.println("Digite o valor do serviço:");
                    double vs = leia.nextDouble();
                    while(vs <= 0) {
                        System.out.println("O valor do serviço não pode ser menor ou igual a 0.");
                        vs = leia.nextDouble();
                    }
                    
                    leia.nextLine();
                    
                    Servico servico = new Servico(ns, vs, sistema.gerarIDServico());
                    sistema.adicionarServico(servico);
                }
                
                if(a == 3) {
                    while(true) {
                    System.out.println("Digite o ID do cliente, ou 0 para encerrar:");
                    String id = leia.nextLine();
                    if(id.equals("0")) {
                        break;
                    }
                    Cliente cliente = sistema.buscarCliente(id);
                    if(cliente == null) {
                        System.out.println("Cliente não encontrado.");
                    }
                    else {
                        System.out.println("Digite a ID do serviço, ou 0 para encerrar:");
                        String idS = leia.nextLine();
                        if(idS.equals("0")) {
                            break;
                        }
                        Servico servico = sistema.buscarServico(idS);
                        if(servico == null) {
                            System.out.println("Serviço não encontrado.");
                        }
                        
                        else {
                            Atendimento atendimento = new Atendimento(cliente, servico, sistema.gerarIDAtendimento());
                            sistema.adicionarAtendimento(atendimento);
                            System.out.println("Atendimento cadastrado!");
                        }
                    }
                }
            }
        }
            
            if(resposta == 2) {
                
                System.out.println("Escolha uma das opções: \n1: Gerenciar Clientes. \n2: Gerenciar Serviços." +
                "\n3: Gerenciar Atendimentos \n4: Gerenciar Faturas.");
                int b = leia.nextInt();
                while(b != 1 && b != 2 && b!= 3 && b != 4) {
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    b = leia.nextInt();
                }
                
                leia.nextLine();
                
                if(b == 1) {
                    while(true) {
                    System.out.println("Escolha uma opção: \n1: Consultar Clientes. \n2: Editar um cliente." +
                    "\n3: Excluir um cliente. \n4: Encerrar operação.");
                    int opcao = leia.nextInt();
                    while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        opcao = leia.nextInt();
                    }
                    
                    leia.nextLine();
                    
                    if(opcao == 4) {
                        break;
                    }
                    
                    if(opcao == 1) {
                        sistema.consultarClientes();
                    }
                    
                    else if(opcao == 2) {
                        System.out.println("Digite o ID do usuário que deseja editar.");
                        String id = leia.nextLine();
                        
                        Cliente cliente = sistema.buscarCliente(id);
                        
                        if(cliente == null) {
                            System.out.println("Cliente não encontrado.");
                        }
                        
                        else {
                            System.out.println("Digite o nome");
                            String novoNome = leia.nextLine();
                            System.out.println("Digite a data de nascimento:");
                            LocalDate novoNascimento = LocalDate.parse(leia.nextLine());
                            System.out.println("Digite o telefone:");
                            String novoTelefone = leia.nextLine();
                            System.out.println("Digite o email:");
                            String novoEmail = leia.nextLine();
                            
                            sistema.atualizarCliente(cliente, novoNome, novoNascimento, novoTelefone, novoEmail);
                            
                        }
                    }
                    
                    if(opcao == 3) {
                        System.out.println("Digite a ID do cliente que deseja excluir");
                        String id = leia.nextLine();
                        
                        Cliente cliente = sistema.buscarCliente(id);
                        
                        if(cliente == null) {
                            System.out.println("Cliente não encontrado.");
                        }
                        
                        else {
                            sistema.removerCliente(cliente);
                        }
                    }
                    
                }
                
                }
                
                
                else if(b == 2) {
                while(true) {

                System.out.println("Escolha uma opção: \n1: Consultar Serviços. \n2: Editar um serviço."
                + "\n3: Excluir um serviço. \n4: Encerrar operação.");
                int opcao = leia.nextInt();

                while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {

                System.out.println("Opção inválida. Por favor, escolha novamente.");
                opcao = leia.nextInt();
                }

                leia.nextLine();

                if(opcao == 4) {
                   break;
                }

                if(opcao == 1) {
                   sistema.consultarServicos();  
                }

                else if(opcao == 2) {

                System.out.println("Digite o ID do serviço que deseja editar:");
                String id = leia.nextLine();
                Servico servico = sistema.buscarServico(id);

                if(servico == null) {
                System.out.println("Serviço não encontrado.");
                }

                else {

                System.out.println("Digite o nome do serviço:");
                String novoNome = leia.nextLine();
                System.out.println("Digite o preço do serviço:");
                double novoPreco = leia.nextDouble();
                while(novoPreco <= 0) {
                    System.out.println("O valor do serviço não pode ser menor ou igual a 0.");
                    novoPreco = leia.nextDouble();
                }

                leia.nextLine();

                sistema.atualizarServico(servico, novoNome, novoPreco);

                }

                }

              else if(opcao == 3) {

              System.out.println("Digite o ID do serviço que deseja excluir:");
              String id = leia.nextLine();

              Servico servico = sistema.buscarServico(id);

              if(servico == null) {

              System.out.println("Serviço não encontrado.");
              }
              
               else {

                sistema.removerServico(servico);
                
               }
               
             }
           }
            
         }

                else if(b == 3) {
                    while(true) {
                        System.out.println("Escolha uma opção: \n1: Consultar atendimentos. \n2: Realizar pagamentos. \n3: Encerrar operação.");
                        int opcao = leia.nextInt();
                           while(opcao != 1 && opcao != 2 && opcao != 3) {
                            System.out.println("Opção inválida. Por favor, escolha novamente.");
                            opcao = leia.nextInt();
                        }
                        if(opcao == 3) {
                            break;
                        }
                        
                        leia.nextLine();
                        
                        if(opcao == 1) {
                            sistema.consultarAtendimentos();
                        }
                        
                        else if(opcao == 2) {
                            System.out.println("Digite a ID do atendimento que deseja realizar o pagamento.");
                            String id = leia.nextLine();
                            Atendimento atendimento = sistema.buscarAtendimento(id);
                            if(atendimento == null) {
                                System.out.println("O atendimento não foi encontrado.");
                            }
                            else {
                                System.out.println("Digite o valor do pagamento:");
                                double valor = leia.nextDouble();
                                leia.nextLine();
                                System.out.println("Digite o método de pagamento:");
                                String metodo = leia.nextLine();
                                atendimento.realizarPagamento(valor, metodo);
                            }
                                
                        }
                        
                    }
                }
                
                else {
                    sistema.consultarFaturas();
                }
                
                
                
            }
            
            
        }
    }
}