public class EstagioColeta extends EstagioLogisticoBase {
    @Override
    public String getNome() {
        return "Coleta";
    }

    protected String processar(Pedido pedido) {
        pedido.setEstagioLogistico(this);
        return "Realizando a coleta do pedido: " + pedido.getIdentificacao();
    }
}
