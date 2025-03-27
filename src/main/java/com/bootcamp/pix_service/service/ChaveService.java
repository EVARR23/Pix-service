package com.bootcamp.pix_service.service;

import com.bootcamp.pix_service.dto.ChaveRequestDTO;
import com.bootcamp.pix_service.dto.ChaveResponseDTO;
import com.bootcamp.pix_service.model.Chave;
import com.bootcamp.pix_service.repository.ChaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChaveService {

   private final ChaveRepository chaveRepository;

   public ChaveResponseDTO criarChave(final ChaveRequestDTO chaveRequestDTO) {
       Chave chave = Chave.builder()
               .chave(chaveRequestDTO.getChave())
               .ativa(chaveRequestDTO.getAtiva())
               .build();
       chave = chaveRepository.save(chave);

       return ChaveResponseDTO.builder()
               .chave(chave.getChave())
               .ativa(chave.getAtiva())
               .build();
   }

    public ChaveResponseDTO buscarChave(final String chavePesquisada) {
        Chave chave = chaveRepository.findByChave(chavePesquisada)
                .orElseThrow(() -> new RuntimeException("Chave não encontrada: " + chavePesquisada));

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }


}
