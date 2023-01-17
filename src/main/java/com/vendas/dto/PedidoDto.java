package com.vendas.dto;

import java.math.BigDecimal;
import java.util.List;

//{
//    "cliente": 1,
//    "total": 100,
//    "itens": [
//        {
//            "produto": 31,
//            "quantidade": 14
//        }
//    ]
//}
public class PedidoDto {
	
	private Integer cliente;
	private BigDecimal total;
	private List<ItemProdutoDto> itens;
	

}
