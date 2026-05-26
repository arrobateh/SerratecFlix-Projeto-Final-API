package org.serratec.SerratecFlix.repository;

import org.serratec.SerratecFlix.domain.AvaliacaoSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoSerieRepository extends JpaRepository<AvaliacaoSerie, Long> {

    @Query("SELECT AVG(a.notaAvaliacaoSerie) FROM AvaliacaoSerie a WHERE a.serie.idSerie = :idSerie")
    Double calcularMediaNotaSerie(@Param("idSerie") Long idSerie);
}