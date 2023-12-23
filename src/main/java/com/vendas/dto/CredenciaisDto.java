package com.vendas.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CredenciaisDto {
	private String email;
	private String senha;

}
