public class EstagioFinalizado extends EstagioLogisticoBase {
    @Override
    public String getNome() {
        return "Finalizado";
    }

    protected String processar(Pedido pedido) {
        pedido.setEstagioLogistico(this);
        return "Logística finalizada no pedido: " + pedido.getIdentificacao();
    }
}
