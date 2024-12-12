package repository;

import model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}
