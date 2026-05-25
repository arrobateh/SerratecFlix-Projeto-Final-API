package org.serratec.SerratecFlix.repository;

import org.serratec.SerratecFlix.domain.AvaliacaoSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoSerieRepository extends JpaRepository<AvaliacaoSerie, Long> {
}
