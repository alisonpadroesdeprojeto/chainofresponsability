public interface EstagioLogistico {
    String getNome();
    void setEstagioAnterior(EstagioLogistico estagioAnterior);
    void setEstagioSeguinte(EstagioLogistico estagioSeguinte);
    String processarPedido(Pedido pedido);
}
