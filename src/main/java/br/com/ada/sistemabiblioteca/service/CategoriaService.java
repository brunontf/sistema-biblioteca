package br.com.ada.sistemabiblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ada.sistemabiblioteca.model.dto.CategoriaDTO;
import br.com.ada.sistemabiblioteca.model.entity.CategoriaEntity;
import br.com.ada.sistemabiblioteca.model.mapper.CategoriaMapper;
import br.com.ada.sistemabiblioteca.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    CategoriaMapper categoriaMapper;
    
    public List<CategoriaDTO> listarTodos() {
        List<CategoriaEntity> listaEntities = categoriaRepository.findAll();
        return categoriaMapper.updateListaCategoriaDTO(listaEntities);
    }

    public CategoriaDTO listarUm(Long id) {
        Optional<CategoriaEntity> categoriaOp = categoriaRepository.findById(id);
        if(categoriaOp.isPresent()){
            CategoriaEntity categoriaEntity = categoriaOp.get();
            return categoriaMapper.update(categoriaEntity);
        }
        throw new EntityNotFoundException("Categoria não encontrada");
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = categoriaMapper.update(categoriaDTO);
        categoriaEntity = categoriaRepository.save(categoriaEntity);
        return categoriaMapper.update(categoriaEntity);
    }

    public CategoriaDTO editar(CategoriaDTO categoriaDTO, Long id) {

        if (categoriaRepository.existsById(id)) {
            CategoriaEntity categoria = categoriaMapper.update(categoriaDTO);
            categoria.setId(id);
            categoria = categoriaRepository.save(categoria);

            return categoriaMapper.update(categoria);
        }
        throw new EntityNotFoundException("Categoria não encontrada!");
    }

    public void deletar(Long id){
        Optional<CategoriaEntity> categoriaEntityOp = categoriaRepository.findById(id);

        if (categoriaEntityOp.isPresent()) {
            CategoriaEntity categoriaEntity = categoriaEntityOp.get();
            categoriaRepository.delete(categoriaEntity);
            return;
        }
        throw new EntityNotFoundException("Categoria não encontrada!");
    }
}
