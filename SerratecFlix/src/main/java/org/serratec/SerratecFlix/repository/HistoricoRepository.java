package org.serratec.SerratecFlix.repository;

import org.serratec.SerratecFlix.domain.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    List<Historico> findByUsuarioIdOrderByDataAssistidoDesc(Long usuarioId);
}
