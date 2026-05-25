package org.serratec.SerratecFlix.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.SerratecFlix.domain.Categoria;
import org.serratec.SerratecFlix.domain.Filme;
import org.serratec.SerratecFlix.dto.FilmeDTORequest;
import org.serratec.SerratecFlix.dto.FilmeDTOResponse;
import org.serratec.SerratecFlix.repository.CategoriaRepository;
import org.serratec.SerratecFlix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;
	
	
    public List<FilmeDTOResponse> findAll() {

        List<Filme> filmes = filmeRepository.findAll();

        List<FilmeDTOResponse> filmesDTO = new ArrayList<>();

        for (Filme filme : filmes) {

            FilmeDTOResponse filmesDTOResponse = new FilmeDTOResponse();
            filmesDTOResponse.setId(filme.getId());
            filmesDTOResponse.setTitulo(filme.getTitulo());
            filmesDTOResponse.setDescricao(filme.getDescricao());
            filmesDTOResponse.setDuracao(filme.getDuracao());
            filmesDTOResponse.setDataLancamento(filme.getDataLancamento());
            filmesDTOResponse.setNotaMedia(filme.getNotaMedia());
            filmesDTOResponse.setClassificacaoIndicativa(filme.getClassificacaoIndicativa());
           
            filmesDTOResponse.setCategorias(mapCategorias(filme));
            
            filmesDTO.add(filmesDTOResponse);
        }

        return filmesDTO;
    }
    
    public FilmeDTOResponse buscar(Long id) {

        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado com id: " + id));

        FilmeDTOResponse filmeDTOResponse = new FilmeDTOResponse();

        filmeDTOResponse.setId(filme.getId());
        filmeDTOResponse.setTitulo(filme.getTitulo());
        filmeDTOResponse.setDescricao(filme.getDescricao());
        filmeDTOResponse.setDuracao(filme.getDuracao());
        filmeDTOResponse.setDataLancamento(filme.getDataLancamento());
        filmeDTOResponse.setNotaMedia(filme.getNotaMedia());
        filmeDTOResponse.setClassificacaoIndicativa(filme.getClassificacaoIndicativa());
        
        filmeDTOResponse.setCategorias(mapCategorias(filme));

        return filmeDTOResponse;
    }
    
    
    
    public FilmeDTOResponse inserir(FilmeDTORequest dto) {

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Filme filme = new Filme();
        filme.setTitulo(dto.getTitulo());
        filme.setDescricao(dto.getDescricao());
        filme.setDuracao(dto.getDuracao());
        filme.setDataLancamento(dto.getDataLancamento());
        filme.setNotaMedia(dto.getNotaMedia());
        filme.setClassificacaoIndicativa(dto.getClassificacaoIndicativa());

        filme.getCategorias().add(categoria);

        filme = filmeRepository.save(filme);

        FilmeDTOResponse filmeDTOResponse = new FilmeDTOResponse();
        filmeDTOResponse.setId(filme.getId());
        filmeDTOResponse.setTitulo(filme.getTitulo());
        filmeDTOResponse.setDescricao(filme.getDescricao());
        filmeDTOResponse.setDuracao(filme.getDuracao());
        filmeDTOResponse.setDataLancamento(filme.getDataLancamento());
        filmeDTOResponse.setNotaMedia(filme.getNotaMedia());
        filmeDTOResponse.setClassificacaoIndicativa(filme.getClassificacaoIndicativa());

        filmeDTOResponse.setCategorias(mapCategorias(filme));
       
        return filmeDTOResponse;
    }
    
    
    public FilmeDTOResponse atualizar(Long id, FilmeDTORequest dto) {

        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado com id: " + id));
        
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        filme.getCategorias().clear();
        filme.getCategorias().add(categoria);

        filme.setTitulo(dto.getTitulo());
        filme.setDescricao(dto.getDescricao());
        filme.setDuracao(dto.getDuracao());
        filme.setDataLancamento(dto.getDataLancamento());
        filme.setNotaMedia(dto.getNotaMedia());
        filme.setClassificacaoIndicativa(dto.getClassificacaoIndicativa());

        filme = filmeRepository.save(filme);

        FilmeDTOResponse filmeDTOResponse = new FilmeDTOResponse();

        filmeDTOResponse.setId(filme.getId());
        filmeDTOResponse.setTitulo(filme.getTitulo());
        filmeDTOResponse.setDescricao(filme.getDescricao());
        filmeDTOResponse.setDuracao(filme.getDuracao());
        filmeDTOResponse.setDataLancamento(filme.getDataLancamento());
        filmeDTOResponse.setNotaMedia(filme.getNotaMedia());
        filmeDTOResponse.setClassificacaoIndicativa(filme.getClassificacaoIndicativa());

        filmeDTOResponse.setCategorias(mapCategorias(filme));

        return filmeDTOResponse;
    }
    
    public void deletar(Long id) {

        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado com id: " + id));

        filmeRepository.delete(filme);
    }
    
    
    private java.util.Set<String> mapCategorias(Filme filme) {

        return filme.getCategorias()
                .stream()
                .map(Categoria::getNome)
                .collect(java.util.stream.Collectors.toSet());
    }
    
    
    
    
}
