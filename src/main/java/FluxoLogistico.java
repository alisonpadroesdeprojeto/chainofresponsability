import java.util.ArrayList;

public class FluxoLogistico {
    private final ArrayList<EstagioLogistico> estagiosLogisticos = new ArrayList<>();

    public ArrayList<EstagioLogistico> getEstagiosLogisticos() {
        return estagiosLogisticos;
    }

    public void adicionarEstagio(Integer posicao, EstagioLogistico estagio) {
        if (posicao != null && posicao >= 0 && posicao < estagiosLogisticos.size()) {
            estagiosLogisticos.add(posicao, estagio);
        } else {
            estagiosLogisticos.add(estagio);
        }
        for (int i = 0; i < estagiosLogisticos.size(); i++) {
            if (i - 1 >= 0) {
                estagiosLogisticos.get(i).setEstagioAnterior(estagiosLogisticos.get(i - 1));
            }
            if (i + 1 < estagiosLogisticos.size()) {
                estagiosLogisticos.get(i).setEstagioSeguinte(estagiosLogisticos.get(i + 1));
            }
        }
    }

    public String getExibicao() {
        StringBuilder exibicao = new StringBuilder();
        for (int i = 0; i < estagiosLogisticos.size(); i++) {
            exibicao.append(estagiosLogisticos.get(i).getNome());
            if (i < estagiosLogisticos.size() - 1) {
                exibicao.append(" > ");
            }
        }
        return exibicao.toString();
    }

}
