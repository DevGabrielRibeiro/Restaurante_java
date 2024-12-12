package repository;

import model.Garcom;
import java.util.ArrayList;
import java.util.List;

public class GarcomRepository {
    private List<Garcom> garcons = new ArrayList<>();

    public void adicionarGarcom(Garcom garcom) {
        garcons.add(garcom);
    }

    public List<Garcom> listarGarcons() {
        return garcons;
    }

    public boolean verificarCodigoExistente(int codigo) {
        return garcons.stream().anyMatch(garcom -> garcom.getCodigo() == codigo);
    }
}
