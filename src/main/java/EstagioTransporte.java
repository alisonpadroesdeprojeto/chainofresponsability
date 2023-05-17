public class EstagioTransporte extends EstagioLogisticoBase {
    @Override
    public String getNome() {
        return "Transporte";
    }

    protected String processar(Pedido pedido) {
        pedido.setEstagioLogistico(this);
        return "Realizando o transporte do pedido: " + pedido.getIdentificacao();
    }
}
