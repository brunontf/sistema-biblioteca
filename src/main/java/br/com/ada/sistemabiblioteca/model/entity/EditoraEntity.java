package br.com.ada.sistemabiblioteca.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "editoras")
public class EditoraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nome", nullable = false, unique = true)
    private String nomeEditora;
    @Column(name = "descricao")
    private String descricaoEditora;
    
    @OneToMany(mappedBy = "editoraEntity" )
    private List<LivroEntity> listaLivros;
}
