package br.com.ada.sistemabiblioteca.model.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ada.sistemabiblioteca.model.dto.LivroDTO;
import br.com.ada.sistemabiblioteca.model.entity.LivroEntity;

@Component
public class LivroMapper {
    private EditoraMapper editoraMapper = new EditoraMapper();
    private CategoriaMapper categoriaMapper = new CategoriaMapper();

    public LivroEntity update(LivroDTO livroDTO) {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setNome(livroDTO.getNome());
        livroEntity.setIsbn(livroDTO.getIsbn());
        livroEntity.setEditoraEntity(editoraMapper.update(livroDTO.getEditora()));
        livroEntity.setCategoriaEntity(categoriaMapper.update(livroDTO.getCategoria()));
        return livroEntity;
    }

    public LivroDTO update(LivroEntity livroEntity) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livroEntity.getId());
        livroDTO.setNome(livroEntity.getNome());
        livroDTO.setIsbn(livroEntity.getIsbn());
        livroDTO.setEditora(editoraMapper.update(livroEntity.getEditoraEntity()));
        livroDTO.setCategoria(categoriaMapper.update(livroEntity.getCategoriaEntity()));
        return livroDTO;
    }

    public List<LivroDTO> updateListaLivroDTO (List<LivroEntity> listaLivroEntity) {
        return listaLivroEntity.stream().map(livroEntity -> this.update(livroEntity)).toList();
    }

    public List<LivroEntity> updateListaLivroEntity (List<LivroDTO> listaLivroDTO) {
        return listaLivroDTO.stream().map(livroDTO -> this.update(livroDTO)).toList();
    }
}
