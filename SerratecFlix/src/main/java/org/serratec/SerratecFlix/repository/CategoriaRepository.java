package org.serratec.SerratecFlix.repository;

import java.util.List;

import org.serratec.SerratecFlix.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findByNome(String nome);
	
}
