public abstract class EstagioLogisticoBase implements EstagioLogistico {
    private EstagioLogistico estagioAnterior;
    private EstagioLogistico estagioSeguinte;

    public EstagioLogistico getEstagioAnterior() {
        return estagioAnterior;
    }

    public void setEstagioAnterior(EstagioLogistico estagioAnterior) {
        this.estagioAnterior = estagioAnterior;
    }

    public EstagioLogistico getEstagioSeguinte() {
        return estagioSeguinte;
    }

    @Override
    public void setEstagioSeguinte(EstagioLogistico estagioSeguinte) {
        this.estagioSeguinte = estagioSeguinte;
    }

    public String processarPedido(Pedido pedido) {
        if (podeProcessar(pedido)) {
            return processar(pedido);
        } else if (this.getEstagioSeguinte() != null) {
            return this.getEstagioSeguinte().processarPedido(pedido);
        } else {
            return "Nenhum estágio seguinte para processar o pedido.";
        }
    }

    protected boolean podeProcessar(Pedido pedido) {
        return pedido.getEstagioLogistico() == this.getEstagioAnterior();
    }

    protected abstract String processar(Pedido pedido);
}