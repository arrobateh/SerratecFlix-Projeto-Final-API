package org.serratec.SerratecFlix.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.serratec.SerratecFlix.domain.Categoria;
import org.serratec.SerratecFlix.domain.Serie;
import org.serratec.SerratecFlix.dto.SerieRequestDTO;
import org.serratec.SerratecFlix.dto.SerieResponseDTO;
import org.serratec.SerratecFlix.repository.CategoriaRepository;
import org.serratec.SerratecFlix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    // 1. Selecionar todas as séries
    public List<SerieResponseDTO> listarTodos() {
        return serieRepository.findAll().stream()
                .map(SerieResponseDTO::new)
                .collect(Collectors.toList());
    }

    // 2. Buscar a série pelo ID
    public SerieResponseDTO buscarPorId(Long id) {
        Serie serie = serieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Série não encontrada com ID: " + id));
        return new SerieResponseDTO(serie);
    }

    // 3. Cadastrar serie
    public SerieResponseDTO cadastrarSerie(SerieRequestDTO serieRequest) {
        Categoria categoria = categoriaRepository.findById(serieRequest.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + serieRequest.getIdCategoria()));

        Serie serie = new Serie();
        serie.setTituloSerie(serieRequest.getTituloSerie());
        serie.setDescricaoSerie(serieRequest.getDescricaoSerie());
        serie.setTemporadas(serieRequest.getTemporadas());
        serie.setEpisodios(serieRequest.getEpisodios());
        serie.setDataLancamento(serieRequest.getDataLancamento());
        serie.setCategorias(new HashSet<>(Set.of(categoria)));

        serieRepository.save(serie);

        return new SerieResponseDTO(serie);
    }

    // 4. Atualizar série
    public SerieResponseDTO atualizarSerie(Long id, SerieRequestDTO serieRequest) {
        Categoria categoria = categoriaRepository.findById(serieRequest.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + serieRequest.getIdCategoria()));

        Serie serie = serieRepository.findById(id).orElseThrow(() -> new RuntimeException("Série não encontrada com ID: " + id));
        
        serie.setTituloSerie(serieRequest.getTituloSerie());
        serie.setDescricaoSerie(serieRequest.getDescricaoSerie());
        serie.setTemporadas(serieRequest.getTemporadas());
        serie.setEpisodios(serieRequest.getEpisodios());
        serie.setDataLancamento(serieRequest.getDataLancamento());
        serie.setCategorias(new HashSet<>(Set.of(categoria)));

        serieRepository.save(serie);

        return new SerieResponseDTO(serie);
    }

    // 5. Deletar série
    public void removerSerie (Long id) {
        if(!serieRepository.existsById(id)) {
            throw new RuntimeException("Série não encontrada com ID: " + id);
        }
        serieRepository.deleteById(id);
    }
}
