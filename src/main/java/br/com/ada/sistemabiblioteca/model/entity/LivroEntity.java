package br.com.ada.sistemabiblioteca.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "livros")
public class LivroEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "isbn",nullable = false)
    private String isbn;
    
    // @Column(name = "editora",nullable = false)
    @ManyToOne
    @JoinColumn(name = "editoras")
    private EditoraEntity editoraEntity;
    
    // @Column(name = "categoria",nullable = false)
    @ManyToOne
    @JoinColumn(name = "categorias")
    private CategoriaEntity categoriaEntity;
}
