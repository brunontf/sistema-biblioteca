package br.com.ada.sistemabiblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ada.sistemabiblioteca.model.dto.LivroDTO;
import br.com.ada.sistemabiblioteca.model.dto.MensagemDTO;
import br.com.ada.sistemabiblioteca.service.LivroService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/livros")
@Slf4j
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping()
    public ResponseEntity<Object> listarTodos(
        @RequestParam(name = "numeroPagina",defaultValue = "0") int numeroPagina, 
        @RequestParam(name = "elementosPorPagina",defaultValue = "-1") int nElemPorPag) {
        try {
            return ResponseEntity.ok(livroService.listarTodos(numeroPagina,nElemPorPag));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> pegarUm(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(livroService.listarUm(id));
        } catch (EntityNotFoundException ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(new MensagemDTO(ex.getMessage()));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid LivroDTO livroDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(livroService.criar(livroDTO));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(
            @RequestBody @Valid LivroDTO livroDTO,
            @PathVariable("id") Long id) {

        try {
            return ResponseEntity.ok(livroService.editar(livroDTO, id));
        } catch (EntityNotFoundException ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(
            @PathVariable("id") Long id) {
        try{
            livroService.deletar(id);
            return ResponseEntity.ok(new MensagemDTO("Livro com id [" + id + "] removido com sucesso! "));
        } catch (EntityNotFoundException ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MensagemDTO(ex.getMessage()));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }

    @GetMapping("/filtrar")
    public ResponseEntity<Object> filtrarPorNomeOuIsbn(
        @RequestParam(name = "nome",defaultValue = "") String nome,
        @RequestParam(name = "isbn",defaultValue = "") String isbn
    ) {
        try {
            return ResponseEntity.ok(livroService.filtrarPorNomeOuIsbn(nome,isbn));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }

    @GetMapping("/filtrarPorEditora")
    public ResponseEntity<Object> filtrarPorEditora(
        @RequestParam(name = "editoraId",defaultValue = "") Long editoraId
    ) {
        try {
            return ResponseEntity.ok(livroService.filtrarPorEditora(editoraId));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }

    @GetMapping("/filtrarPorCategoria")
    public ResponseEntity<Object> filtrarPorCategoria(
        @RequestParam(name = "categoriaId",defaultValue = "") Long categoriaId
    ) {
        try {
            return ResponseEntity.ok(livroService.filtrarPorCategoria(categoriaId));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(ex.getMessage()));
        }
    }


}
