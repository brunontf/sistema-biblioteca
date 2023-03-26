package br.com.ada.sistemabiblioteca.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LivroDTO {
    private Long id;

    @NotBlank(message = "nome não pode ser branco")
    private String nome;

    @NotBlank(message = "isbn não pode ser branco")
    private String isbn;

    private EditoraDTO editora;
    private CategoriaDTO categoria;
}
