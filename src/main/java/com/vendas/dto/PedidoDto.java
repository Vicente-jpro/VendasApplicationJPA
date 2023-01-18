package com.vendas.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
	
	private Integer cliente;
	private BigDecimal total;
	private List<ItemPedidoDto> itens;
	

}
