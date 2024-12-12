package main;

import model.Cliente;
import model.Garcom;
import model.Prato;
import model.Pedido;
import repository.ClienteRepository;
import repository.GarcomRepository;
import repository.PratoRepository;
import repository.PedidoRepository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criar repositórios
        ClienteRepository clienteRepo = new ClienteRepository();
        GarcomRepository garcomRepo = new GarcomRepository();
        PratoRepository pratoRepo = new PratoRepository();
        PedidoRepository pedidoRepo = new PedidoRepository();

        Scanner scanner = new Scanner(System.in);

        // Menu de opções
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Garçom");
            System.out.println("3. Adicionar Prato");
            System.out.println("4. Realizar Pedido");
            System.out.println("5. Exibir Todos os Pedidos");
            System.out.println("6. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    // Adicionar Cliente
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();

                    System.out.print("Digite o telefone do cliente: ");
                    String telefoneCliente = scanner.nextLine();

                    System.out.print("Digite o email do cliente: ");
                    String emailCliente = scanner.nextLine();

                    System.out.print("Digite o endereço do cliente: ");
                    String enderecoCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente, emailCliente, enderecoCliente);
                    clienteRepo.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 2:
                    // Adicionar Garçom
                    System.out.print("Digite o nome do garçom: ");
                    String nomeGarcom = scanner.nextLine();

                    System.out.print("Digite o código do garçom: ");
                    int codigoGarcom = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Digite o telefone do garçom: ");
                    String telefoneGarcom = scanner.nextLine();

                    System.out.print("Digite o email do garçom: ");
                    String emailGarcom = scanner.nextLine();

                    Garcom garcom = new Garcom(nomeGarcom, codigoGarcom, telefoneGarcom, emailGarcom);
                    garcomRepo.adicionarGarcom(garcom);
                    System.out.println("Garçom adicionado com sucesso!");
                    break;

                case 3:
                    // Adicionar Prato
                    System.out.print("Digite o nome do prato: ");
                    String nomePrato = scanner.nextLine();

                    System.out.print("Digite a descrição do prato: ");
                    String descricaoPrato = scanner.nextLine();

                    System.out.print("Digite o preço do prato: ");
                    double precoPrato = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer

                    Prato prato = new Prato(nomePrato, descricaoPrato, precoPrato);
                    pratoRepo.adicionarPrato(prato);
                    System.out.println("Prato adicionado com sucesso!");
                    break;

                case 4:
                    // Realizar Pedido
                    System.out.println("Escolha o cliente:");
                    List<Cliente> clientes = clienteRepo.listarClientes();
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println((i + 1) + ". " + clientes.get(i).getNome());
                    }
                    int clienteEscolhido = scanner.nextInt() - 1;
                    scanner.nextLine();  // Limpar o buffer

                    Cliente clientePedido = clientes.get(clienteEscolhido);

                    System.out.println("Escolha o garçom:");
                    List<Garcom> garcons = garcomRepo.listarGarcons();
                    for (int i = 0; i < garcons.size(); i++) {
                        System.out.println((i + 1) + ". " + garcons.get(i).getNome());
                    }
                    int garcomEscolhido = scanner.nextInt() - 1;
                    scanner.nextLine();  // Limpar o buffer

                    Garcom garcomPedido = garcons.get(garcomEscolhido);

                    System.out.println("Escolha os pratos (digite o número e pressione Enter. Digite '0' para finalizar):");
                    List<Prato> pratos = pratoRepo.listarPratos();
                    for (int i = 0; i < pratos.size(); i++) {
                        System.out.println((i + 1) + ". " + pratos.get(i).getNome());
                    }

                    scanner.nextLine();  // Limpar o buffer
                    System.out.println("Digite os números dos pratos escolhidos separados por vírgula:");
                    String pratosEscolhidosStr = scanner.nextLine();
                    String[] pratosSelecionados = pratosEscolhidosStr.split(",");

                    // Selecionar os pratos
                    List<Prato> pratosPedido = new java.util.ArrayList<>();
                    for (String pratoStr : pratosSelecionados) {
                        int pratoIndex = Integer.parseInt(pratoStr.trim()) - 1;
                        if (pratoIndex >= 0 && pratoIndex < pratos.size()) {
                            pratosPedido.add(pratos.get(pratoIndex));
                        }
                    }

                    if (pratosPedido.isEmpty()) {
                        System.out.println("Erro: pelo menos um prato deve ser escolhido.");
                    } else {
                        Pedido pedido = new Pedido(clientePedido, garcomPedido, pratosPedido, new Date(), "Em preparo");
                        pedidoRepo.adicionarPedido(pedido);
                        System.out.println("Pedido realizado com sucesso!");
                    }
                    break;

                case 5:
                    // Exibir todos os pedidos
                    System.out.println("Lista de todos os pedidos:");
                    List<Pedido> pedidos = pedidoRepo.listarPedidos();
                    for (Pedido p : pedidos) {
                        System.out.println("Cliente: " + p.getCliente().getNome() +
                                ", Garçom: " + p.getGarcom().getNome() +
                                ", Status: " + p.getStatus() +
                                ", Data: " + p.getDataPedido());
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
