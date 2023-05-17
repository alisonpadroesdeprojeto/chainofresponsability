public class EstagioEmbalagem extends EstagioLogisticoBase {
    @Override
    public String getNome() {
        return "Embalagem";
    }

    protected String processar(Pedido pedido) {
        pedido.setEstagioLogistico(this);
        return "Realizando a embalagem do pedido: " + pedido.getIdentificacao();
    }
}
