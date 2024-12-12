package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void atualizarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cliente.getCpf())) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    public void excluirCliente(String cpf) {
        clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    public boolean verificarCpfExistente(String cpf) {
        return clientes.stream().anyMatch(cliente -> cliente.getCpf().equals(cpf));
    }
}
