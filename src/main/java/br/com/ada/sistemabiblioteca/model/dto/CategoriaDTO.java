package br.com.ada.sistemabiblioteca.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoriaDTO {
    private Long id;

    @NotBlank(message = "nome da categoria não pode ser branco")
    @Size(max = 100, message = "Tamanho acima do permitido. Máximo de 100 caracteres.")
    private String nomeCategoria;
}
