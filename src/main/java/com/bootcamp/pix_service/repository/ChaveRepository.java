package com.bootcamp.pix_service.repository;

import com.bootcamp.pix_service.model.Chave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, UUID> {

    boolean existsByChave(final String chave);

    Optional<Chave> findByChave(final String chavePesquisada);


}
