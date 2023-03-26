package br.com.ada.sistemabiblioteca.model.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ada.sistemabiblioteca.model.dto.EditoraDTO;
import br.com.ada.sistemabiblioteca.model.entity.EditoraEntity;

@Component
public class EditoraMapper {
    public EditoraEntity update(EditoraDTO editoraDTO) {
        EditoraEntity editoraEntity = new EditoraEntity();
        editoraEntity.setId(editoraDTO.getId());
        editoraEntity.setNomeEditora(editoraDTO.getNomeEditora());
        editoraEntity.setDescricaoEditora(editoraDTO.getDescricaoEditora());
        return editoraEntity;
    }

    public EditoraDTO update(EditoraEntity editoraEntity) {
        EditoraDTO editoraDTO = new EditoraDTO();
        editoraDTO.setId(editoraEntity.getId());
        editoraDTO.setNomeEditora(editoraEntity.getNomeEditora());
        editoraDTO.setDescricaoEditora(editoraEntity.getDescricaoEditora());
        return editoraDTO;
    }

    public List<EditoraDTO> updateListaEditoraDTO (List<EditoraEntity> listaEditoraEntity) {
        return listaEditoraEntity.stream().map(editoraEntity -> this.update(editoraEntity)).toList();
    }

    public List<EditoraEntity> updateListaEditoraEntity (List<EditoraDTO> listaEditoraDTO) {
        return listaEditoraDTO.stream().map(editoraDTO -> this.update(editoraDTO)).toList();
    }
}
