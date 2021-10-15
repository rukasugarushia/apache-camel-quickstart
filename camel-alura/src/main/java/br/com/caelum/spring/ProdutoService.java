package br.com.caelum.spring;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:pedidos?delay=5s&noop=true").
                log("Enviando pedido para a fila: ${id} - ${body}").
                to("activemq:queue:pedidos");
    }
}
