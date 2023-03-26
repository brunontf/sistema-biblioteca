package br.com.ada.sistemabiblioteca.model.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ada.sistemabiblioteca.model.dto.CategoriaDTO;
import br.com.ada.sistemabiblioteca.model.entity.CategoriaEntity;

@Component
public class CategoriaMapper {
    public CategoriaEntity update(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoriaDTO.getId());
        categoriaEntity.setNomeCategoria(categoriaDTO.getNomeCategoria());
        return categoriaEntity;
    }

    public CategoriaDTO update(CategoriaEntity categoriaEntity) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoriaEntity.getId());
        categoriaDTO.setNomeCategoria(categoriaEntity.getNomeCategoria());
        return categoriaDTO;
    }

    public List<CategoriaDTO> updateListaCategoriaDTO (List<CategoriaEntity> listacategoriaEntity) {
        return listacategoriaEntity.stream().map(categoriaEntity -> this.update(categoriaEntity)).toList();
    }

    public List<CategoriaEntity> updateListacategoriaEntity (List<CategoriaDTO> listaCategoriaDTO) {
        return listaCategoriaDTO.stream().map(categoriaDTO -> this.update(categoriaDTO)).toList();
    }
}
