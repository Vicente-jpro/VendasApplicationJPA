package com.vendas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoInfoDto {
	private Integer id;
    private String nomeCliente;
    private String bi;  
    private BigDecimal total;
    private LocalDate dataPedido;
    private List<ItemPedidoInfoDto> itens;
}
