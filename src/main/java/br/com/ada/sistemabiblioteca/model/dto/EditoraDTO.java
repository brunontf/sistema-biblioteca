package br.com.ada.sistemabiblioteca.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditoraDTO {
    private Long id;

    @NotBlank(message = "nome da editora não pode ser branco")
    private String nomeEditora;

    @Size(max = 255, message = "Tamanho acima do permitido. Máximo de 255 caracteres.")
    private String descricaoEditora;
}
