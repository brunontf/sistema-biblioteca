package br.com.ada.sistemabiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ada.sistemabiblioteca.model.entity.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity,Long> {
    
}
