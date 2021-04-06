package com.robaswix.appWeb2.cadastros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
//	@Query("select new br.com.robaswix.appWeb2.cadastros.dtos.PessoaListaDTO(p.id, p.nome, p.telefone, p.email)"
//			+ " from Pessoa ")
//	List<PessoaListaDTO> findAllPessoaLista();

//	@Query("select p from Pessoa where p.id = :id")
//	Optional<Pessoa> findCompletoById(@Param("id") Long id);	

}