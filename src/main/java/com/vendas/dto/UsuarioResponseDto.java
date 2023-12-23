package com.vendas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDto {
    private Integer id;
    private String username;
    private String senha;
    private boolean admin;

}
