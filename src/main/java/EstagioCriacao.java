public class EstagioCriacao extends EstagioLogisticoBase {
    @Override
    public String getNome() {
        return "Criação";
    }

    protected String processar(Pedido pedido) {
        pedido.setEstagioLogistico(this);
        return "Realizando a criação do pedido: " + pedido.getIdentificacao();
    }
}
