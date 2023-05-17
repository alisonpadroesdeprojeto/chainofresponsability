import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Pedido pedido;
    FluxoLogistico fluxoLogistico;

    @BeforeEach
    void setUp() {
        fluxoLogistico = new FluxoLogistico();

        EstagioCriacao estagioCriacao = new EstagioCriacao();
        fluxoLogistico.adicionarEstagio(null, estagioCriacao);
        EstagioColeta estagioColeta = new EstagioColeta();
        fluxoLogistico.adicionarEstagio(null, estagioColeta);
        EstagioTransporte estagioTransporte = new EstagioTransporte();
        fluxoLogistico.adicionarEstagio(null, estagioTransporte);
        EstagioFinalizado estagioFinalizado = new EstagioFinalizado();
        fluxoLogistico.adicionarEstagio(null, estagioFinalizado);

        pedido = new Pedido("2023.05-0001");
        pedido.setFluxoLogistico(fluxoLogistico);
    }

    @Test
    void deveExibirFluxoLogistico() {
        assertEquals("Criação > Coleta > Transporte > Finalizado", pedido.getFluxoLogistico().getExibicao());
    }

    @Test
    void deveRealizarCriacaoPedido() {
        assertEquals("Realizando a criação do pedido: 2023.05-0001", pedido.processarPedido());
    }

    @Test
    void deveRealizarColetaPedido() {
        pedido.processarPedido();
        assertEquals("Realizando a coleta do pedido: 2023.05-0001", pedido.processarPedido());
    }

    @Test
    void deveRealizarTransportePedido() {
        pedido.processarPedido();
        pedido.processarPedido();
        assertEquals("Realizando o transporte do pedido: 2023.05-0001", pedido.processarPedido());
    }

    @Test
    void deveRealizarEmbalagemPedido() {
        EstagioEmbalagem estagioEmbalagem = new EstagioEmbalagem();
        pedido.getFluxoLogistico().adicionarEstagio(2, estagioEmbalagem);
        assertEquals("Criação > Coleta > Embalagem > Transporte > Finalizado", pedido.getFluxoLogistico().getExibicao());
        pedido.processarPedido();
        pedido.processarPedido();
        assertEquals("Realizando a embalagem do pedido: 2023.05-0001", pedido.processarPedido());
    }

    @Test
    void deveRealizarFinalizacaoPedido() {
        pedido.processarPedido();
        pedido.processarPedido();
        pedido.processarPedido();
        assertEquals("Logística finalizada no pedido: 2023.05-0001", pedido.processarPedido());
    }

    @Test
    void deveVerificarFluxoPedidoSemEstagioSeguinte() {
        pedido.processarPedido();
        pedido.processarPedido();
        pedido.processarPedido();
        pedido.processarPedido();
        assertEquals("Nenhum estágio seguinte para processar o pedido.", pedido.processarPedido());
    }

    @Test
    void deveVerificarPedidoSemFluxoLogistico() {
        try {
            Pedido pedido = new Pedido("2023.05-0001");
            assertEquals("Nenhum estágio seguinte para processar o pedido.", pedido.processarPedido());
            pedido.processarPedido();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Pedido sem fluxo logístico definido.", e.getMessage());
        }
    }

    @Test
    void deveVerificarFluxoLogisticoPedidoSemEstagio() {
        try {
            Pedido pedido = new Pedido("2023.05-0001");
            FluxoLogistico fluxoLogistico = new FluxoLogistico();
            pedido.setFluxoLogistico(fluxoLogistico);
            pedido.processarPedido();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Fluxo logístico sem estágios.", e.getMessage());
        }
    }
}