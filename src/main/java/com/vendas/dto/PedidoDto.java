package com.vendas.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class PedidoDto {
	private Integer id;
	@NotNull (message = "Informe o código do cliente.")
	private Integer cliente;
	
	@NotNull (message = "Campo total é obrigatório.")
	private BigDecimal total;
	private List<ItemPedidoDto> itens;
	

}
