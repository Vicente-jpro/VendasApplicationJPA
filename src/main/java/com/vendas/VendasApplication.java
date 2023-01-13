package com.vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendasApplication {
//
//	@Autowired 
//	private ClienteService clienteService;
//	
//	@Autowired
//	private PedidoService pedidoService;
//	
//	@Bean
//	public CommandLineRunner create(
//			
//			@Autowired PedidoRepository pedidoRepository
//			) {
//		return args ->{
//			
//			Cliente fulano = new Cliente();
//			fulano.setNome("Fulano");
//			
//			this.clienteService.create(fulano);
//			
//			Pedido p = new Pedido();
//			p.setCliente(fulano);
//			p.setDataPedido( LocalDate.now() );
//			p.setTotal( BigDecimal.valueOf( 14444) );
//			
//			System.out.println("Criando pedido...");
//			pedidoService.create(p);
//			
//			System.out.println("Encontrar o cliente com pedidos.");
//			Cliente cliente2 = clienteService.findClienteFetchPedidos( fulano.getIdCliente() );
//			System.out.println( cliente2 );
//			
//			List<Pedido> listaPedido = pedidoRepository.findByCliente(cliente2);
//			for(Pedido pd: listaPedido ) {
//				System.out.println( pd );
//			}
//			
//		};
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
