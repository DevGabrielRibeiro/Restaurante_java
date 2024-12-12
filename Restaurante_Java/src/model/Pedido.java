package model;

import java.util.List;
import java.util.Date;

public class Pedido {
    private Cliente cliente;
    private Garcom garcom;
    private List<Prato> pratos;
    private Date dataPedido;
    private String status;

    // Construtores, getters e setters
    public Pedido(Cliente cliente, Garcom garcom, List<Prato> pratos, Date dataPedido, String status) {
        this.cliente = cliente;
        this.garcom = garcom;
        this.pratos = pratos;
        this.dataPedido = dataPedido;
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
