package repository;

import model.Prato;
import java.util.ArrayList;
import java.util.List;

public class PratoRepository {
    private List<Prato> pratos = new ArrayList<>();

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public List<Prato> listarPratos() {
        return pratos;
    }
}
