package br.com.ada.sistemabiblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ada.sistemabiblioteca.model.dto.LivroDTO;
import br.com.ada.sistemabiblioteca.model.entity.LivroEntity;
import br.com.ada.sistemabiblioteca.model.mapper.LivroMapper;
import br.com.ada.sistemabiblioteca.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    LivroMapper livroMapper;
    
    public List<LivroDTO> listarTodos() {
        List<LivroEntity> listaEntities = livroRepository.findAll();
        return livroMapper.updateListaLivroDTO(listaEntities);
    }

    public LivroDTO listarUm(Long id) {
        Optional<LivroEntity> livroOp = livroRepository.findById(id);
        if(livroOp.isPresent()){
            LivroEntity livroEntity = livroOp.get();
            return livroMapper.update(livroEntity);
        }
        throw new EntityNotFoundException("Livro não encontrado");
    }

    public LivroDTO criar(LivroDTO livroDTO) {
        LivroEntity livroEntity = livroMapper.update(livroDTO);
        livroEntity = livroRepository.save(livroEntity);
        return livroMapper.update(livroEntity);
    }

    public LivroDTO editar(LivroDTO livroDTO, Long id) {

        if (livroRepository.existsById(id)) {
            LivroEntity livro = livroMapper.update(livroDTO);
            livro.setId(id);
            livro = livroRepository.save(livro);

            return livroMapper.update(livro);
        }
        throw new EntityNotFoundException("Livro não encontrado!");
    }

    public void deletar(Long id){
        Optional<LivroEntity> livroEntityOp = livroRepository.findById(id);

        if (livroEntityOp.isPresent()) {
            LivroEntity livroEntity = livroEntityOp.get();
            livroRepository.delete(livroEntity);
            return;
        }
        throw new EntityNotFoundException("Livro não encontrado!");
    }
}
