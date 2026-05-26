package org.serratec.SerratecFlix.repository;

import java.util.List;

import org.serratec.SerratecFlix.domain.AvaliacaoFilme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFilmeRepository extends JpaRepository<AvaliacaoFilme, Long> {

    List<AvaliacaoFilme> findByFilmeId(Long filmeId);

    List<AvaliacaoFilme> findByUsuarioId(Long usuarioId);

    @Query("SELECT AVG(a.nota) FROM AvaliacaoFilme a WHERE a.filme.id = :filmeId")
    Double calcularMediaNotasPorFilme(@Param("filmeId") Long filmeId);

}