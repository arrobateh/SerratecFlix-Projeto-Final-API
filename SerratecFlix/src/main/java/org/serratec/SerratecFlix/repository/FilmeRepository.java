package org.serratec.SerratecFlix.repository;

import java.util.List;

import org.serratec.SerratecFlix.domain.ClassificacaoIndicativa;
import org.serratec.SerratecFlix.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> findByClassificacaoIndicativa(ClassificacaoIndicativa classificacao);

	List<Filme> findByCategorias_Id(Long categoriaId);


}
