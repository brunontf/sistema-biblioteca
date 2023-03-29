package br.com.ada.sistemabiblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ada.sistemabiblioteca.model.entity.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    @Query("SELECT a FROM LivroEntity a "
            + "WHERE UPPER(a.nome) LIKE CONCAT('%',UPPER(:nome),'%') "
            + "OR (a.isbn) LIKE CONCAT('%',(:isbn),'%')")
    List<LivroEntity> findByNomeOrIsbn(@Param("nome") String nome,@Param("isbn") String isbn );

    @Query("SELECT a FROM LivroEntity a "
            + "WHERE (a.editoraEntity.id) LIKE CONCAT('%',(:editoraId),'%') ")
    List<LivroEntity> findByEditoraId(@Param("editoraId") Long editoraId);

    @Query("SELECT a FROM LivroEntity a "
            + "WHERE (a.categoriaEntity.id) LIKE CONCAT('%',(:categoriaId),'%') ")
    List<LivroEntity> findByCategoriaId(@Param("categoriaId") Long categoriaId);

//     4 - Crie um endpoint que possa buscar o livro pelo nome ou pelo número isbn ou pelos dois
//     Crie a parte de autenticação de usuário e faça endpoints para salvar e buscar os livros favoritos do usuário logado
}
