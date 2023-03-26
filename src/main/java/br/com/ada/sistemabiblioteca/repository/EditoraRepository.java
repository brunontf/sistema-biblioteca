package br.com.ada.sistemabiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ada.sistemabiblioteca.model.entity.EditoraEntity;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity,Long> {
    
}
