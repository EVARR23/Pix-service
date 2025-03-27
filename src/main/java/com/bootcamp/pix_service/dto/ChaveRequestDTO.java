package com.bootcamp.pix_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class ChaveRequestDTO {
    private String chave;
    private Boolean ativa;
}
