package org.serratec.SerratecFlix.repository;

import org.serratec.SerratecFlix.domain.ListaFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaFavoritosRepository extends JpaRepository<ListaFavoritos, Long> {
    boolean existsByNomeLista(String nomeLista);
    boolean existsByNomeListaAndIdNot(String nomeLista, Long id);
}
