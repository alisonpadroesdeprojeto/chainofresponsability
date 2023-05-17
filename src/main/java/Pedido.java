public class Pedido {
    private String identificacao;
    private FluxoLogistico fluxoLogistico;
    private EstagioLogistico estagioLogistico;

    public Pedido(String identificacao) {
        this.setIdentificacao(identificacao);
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public FluxoLogistico getFluxoLogistico() {
        return fluxoLogistico;
    }

    public void setFluxoLogistico(FluxoLogistico fluxoLogistico) {
        this.fluxoLogistico = fluxoLogistico;
    }

    public EstagioLogistico getEstagioLogistico() {
        return estagioLogistico;
    }

    public void setEstagioLogistico(EstagioLogistico estagioLogistico) {
        this.estagioLogistico = estagioLogistico;
    }

    public String processarPedido() {
        if (fluxoLogistico != null) {
            if (estagioLogistico != null) {
                return estagioLogistico.processarPedido(this);
            } else {
                if (fluxoLogistico.getEstagiosLogisticos().size() > 0) {
                    EstagioLogistico primeiroEstagio = fluxoLogistico.getEstagiosLogisticos().get(0);
                    return primeiroEstagio.processarPedido(this);
                } else {
                    throw new NullPointerException("Fluxo logístico sem estágios.");
                }
            }
        } else {
            throw new NullPointerException("Pedido sem fluxo logístico definido.");
        }
    }
}
