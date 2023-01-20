package com.vendas.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoInfoDto {

	private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}
