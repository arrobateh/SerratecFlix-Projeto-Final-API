package org.serratec.SerratecFlix.service;

import org.serratec.SerratecFlix.domain.AvaliacaoSerie;
import org.serratec.SerratecFlix.dto.AvaliacaoSerieRequestDTO;
import org.serratec.SerratecFlix.dto.AvaliacaoSerieResponseDTO;
import org.serratec.SerratecFlix.repository.AvaliacaoSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoSerieService {

    @Autowired
    private AvaliacaoSerieRepository avaliacaoSerieRepository;

    // 1. Selecionar todas as avaliações
    public List<AvaliacaoSerieResponseDTO> listarTodas() {
        return avaliacaoSerieRepository.findAll().stream()
                .map(AvaliacaoSerieResponseDTO::new)
                .toList();
    }

    // 2. Selecionar avaliação por ID
    public AvaliacaoSerieResponseDTO buscarPorId(Long id) {
        AvaliacaoSerie avaliacaoSerie = avaliacaoSerieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException ("Avaliação não encontrada com ID" + id));
        return new AvaliacaoSerieResponseDTO(avaliacaoSerie);
    }

    // 3. Cadastrar avaliação
    public AvaliacaoSerieResponseDTO cadastrarAvaliacao(AvaliacaoSerieRequestDTO avaliacaoSerieRequest) {
        AvaliacaoSerie avaliacaoSerie = new AvaliacaoSerie();
        avaliacaoSerie.setNotaSerie(avaliacaoSerieRequest.getNotaSerie());
        avaliacaoSerie.setComentario(avaliacaoSerieRequest.getComentarioSerie());

        avaliacaoSerieRepository.save(avaliacaoSerie);

        return new AvaliacaoSerieResponseDTO(avaliacaoSerie);
    }

    // 4. Remover avaliação
    public void removerAvaliacao(Long id) {
        if(!avaliacaoSerieRepository.existsById(id)) {
            throw new RuntimeException("Avaliação não encontrada com ID: " + id);
        }
        avaliacaoSerieRepository.deleteById(id);
    }
}
