package org.serratec.SerratecFlix.repository;

import org.serratec.SerratecFlix.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndereceRepository extends JpaRepository<Endereco,Long> {
}
