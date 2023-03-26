package br.com.ada.sistemabiblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ada.sistemabiblioteca.model.dto.EditoraDTO;
import br.com.ada.sistemabiblioteca.model.entity.EditoraEntity;
import br.com.ada.sistemabiblioteca.model.mapper.EditoraMapper;
import br.com.ada.sistemabiblioteca.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EditoraService {
    @Autowired
    EditoraRepository editoraRepository;
    @Autowired
    EditoraMapper editoraMapper;
    
    public List<EditoraDTO> listarTodos() {
        List<EditoraEntity> listaEntities = editoraRepository.findAll();
        return editoraMapper.updateListaEditoraDTO(listaEntities);
    }

    public EditoraDTO listarUm(Long id) {
        Optional<EditoraEntity> editoraOp = editoraRepository.findById(id);
        if(editoraOp.isPresent()){
            EditoraEntity editoraEntity = editoraOp.get();
            return editoraMapper.update(editoraEntity);
        }
        throw new EntityNotFoundException("Editora não encontrada");
    }

    public EditoraDTO criar(EditoraDTO editoraDTO) {
        EditoraEntity editoraEntity = editoraMapper.update(editoraDTO);
        editoraEntity = editoraRepository.save(editoraEntity);
        return editoraMapper.update(editoraEntity);
    }

    public EditoraDTO editar(EditoraDTO editoraDTO, Long id) {

        if (editoraRepository.existsById(id)) {
            EditoraEntity editora = editoraMapper.update(editoraDTO);
            editora.setId(id);
            editora = editoraRepository.save(editora);

            return editoraMapper.update(editora);
        }
        throw new EntityNotFoundException("Editora não encontrada!");
    }

    public void deletar(Long id){
        Optional<EditoraEntity> editoraEntityOp = editoraRepository.findById(id);

        if (editoraEntityOp.isPresent()) {
            EditoraEntity editoraEntity = editoraEntityOp.get();
            editoraRepository.delete(editoraEntity);
            return;
        }
        throw new EntityNotFoundException("Editora não encontrada!");
    }
    
}
