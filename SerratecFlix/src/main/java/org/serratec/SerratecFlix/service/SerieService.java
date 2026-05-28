package org.serratec.SerratecFlix.service;

import org.serratec.SerratecFlix.domain.Categoria;
import org.serratec.SerratecFlix.domain.Serie;
import org.serratec.SerratecFlix.dto.SerieRequestDTO;
import org.serratec.SerratecFlix.dto.SerieResponseDTO;
import org.serratec.SerratecFlix.exception.RecursoNaoEncontradoException;
import org.serratec.SerratecFlix.repository.CategoriaRepository;
import org.serratec.SerratecFlix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String OMDB_KEY = "5a59a414";

    // 1. Selecionar todas as séries
    public List<SerieResponseDTO> listarTodos() {
        return serieRepository.findAll().stream()
                .map(SerieResponseDTO::new)
                .collect(Collectors.toList());
    }

    // 2. Buscar a série pelo ID
    public SerieResponseDTO buscarPorId(Long id) {
        Serie serie = serieRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Série não encontrada com ID: " + id));
        return new SerieResponseDTO(serie);
    }

    // 3. Cadastrar serie
    public SerieResponseDTO cadastrarSerie(SerieRequestDTO serieRequest) {
        Categoria categoria = categoriaRepository.findById(serieRequest.getIdCategoria())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com ID: " + serieRequest.getIdCategoria()));

        Serie serie = new Serie();
        serie.setTituloSerie(serieRequest.getTituloSerie());
//        serie.setTemporadas(serieRequest.getTemporadas());
        serie.setEpisodios(serieRequest.getEpisodios());
        serie.setDataLancamento(serieRequest.getDataLancamento());
        serie.setCategorias(new HashSet<>(Set.of(categoria)));

        try {
            String tituloCodificado = URLEncoder.encode(serieRequest.getTituloSerie().trim(), "UTF-8");
            String url = "http://www.omdbapi.com/?t=" + tituloCodificado + "&apikey=" + OMDB_KEY;
            JsonNode jsonResponse = restTemplate.getForObject(url, JsonNode.class);

            if (jsonResponse != null && "True".equals(jsonResponse.get("Response").asText())) {
                String sinopseIngles = jsonResponse.get("Plot").asText();

                // Extrair o numero de temporadas
                String temporadas = jsonResponse.get("totalSeasons").asText();
                if (temporadas != null && !temporadas.isEmpty()) {
                    serie.setTemporadas(Integer.parseInt(temporadas));
                }
                

                try {
                    String urlTradutor = "https://api.mymemory.translated.net/get?q=" + URLEncoder.encode(sinopseIngles, "UTF-8") + "&langpair=en|pt-BR";
                    JsonNode tradutorResponse = restTemplate.getForObject(urlTradutor, JsonNode.class);
                    if (tradutorResponse != null && tradutorResponse.has("responseData")) {
                        String sinopsePtBr = tradutorResponse.get("responseData").get("translatedText").asText();
                        serie.setDescricaoSerie(sinopsePtBr);
                    } else {
                        serie.setDescricaoSerie(sinopseIngles);
                    }
                } catch (Exception e) {
                    serie.setDescricaoSerie(sinopseIngles);
                }
            } else {
                serie.setDescricaoSerie("Sem descrição disponível.");
            }
        } catch (Exception e) {
            serie.setDescricaoSerie("Erro ao acessar a API.");
        }

        Serie serieSalva = serieRepository.save(serie);

        return new SerieResponseDTO(serieSalva);
    }

    // 4. Atualizar série
    public SerieResponseDTO atualizarSerie(Long id, SerieRequestDTO serieRequest) {
        Categoria categoria = categoriaRepository.findById(serieRequest.getIdCategoria())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com ID: " + serieRequest.getIdCategoria()));

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
            throw new RecursoNaoEncontradoException("Série não encontrada com ID: " + id);
        }
        serieRepository.deleteById(id);
    }
}
