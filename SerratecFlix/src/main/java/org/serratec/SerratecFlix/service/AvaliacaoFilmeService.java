package org.serratec.SerratecFlix.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.SerratecFlix.domain.AvaliacaoFilme;
import org.serratec.SerratecFlix.domain.Filme;
import org.serratec.SerratecFlix.domain.Usuario;
import org.serratec.SerratecFlix.dto.AvaliacaoFilmeDTORequest;
import org.serratec.SerratecFlix.dto.AvaliacaoFilmeDTOResponse;
import org.serratec.SerratecFlix.exception.RecursoNaoEncontradoException;
import org.serratec.SerratecFlix.repository.AvaliacaoFilmeRepository;
import org.serratec.SerratecFlix.repository.FilmeRepository;
import org.serratec.SerratecFlix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoFilmeService {

    @Autowired
    private AvaliacaoFilmeRepository avaliacaoFilmeRepository;

    @Autowired
    private FilmeRepository filmeRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<AvaliacaoFilmeDTOResponse> findAll() {
        List<AvaliacaoFilme> avaliacoes = avaliacaoFilmeRepository.findAll();
        List<AvaliacaoFilmeDTOResponse> avaliacoesDTO = new ArrayList<>();
        for (AvaliacaoFilme avaliacao : avaliacoes) {
            AvaliacaoFilmeDTOResponse dto = new AvaliacaoFilmeDTOResponse();
            dto.setId(avaliacao.getId());
            dto.setNota(avaliacao.getNota());
            dto.setComentario(avaliacao.getComentario());
            dto.setDataAvaliacao(avaliacao.getDataAvaliacao());
            dto.setFilmeId(avaliacao.getFilme().getIdFilme());
            dto.setFilmeTitulo(avaliacao.getFilme().getTitulo());
            dto.setNomeUsuario(avaliacao.getUsuario().getNome());
            avaliacoesDTO.add(dto);
        }
        return avaliacoesDTO;
    }

    public List<AvaliacaoFilmeDTOResponse> findByFilmeIdFilme(Long filmeId) {
        List<AvaliacaoFilme> avaliacoes = avaliacaoFilmeRepository.findByFilmeIdFilme(filmeId);
        List<AvaliacaoFilmeDTOResponse> avaliacoesDTO = new ArrayList<>();
        for (AvaliacaoFilme avaliacao : avaliacoes) {
            AvaliacaoFilmeDTOResponse dto = new AvaliacaoFilmeDTOResponse();
            dto.setId(avaliacao.getId());
            dto.setNota(avaliacao.getNota());
            dto.setComentario(avaliacao.getComentario());
            dto.setDataAvaliacao(avaliacao.getDataAvaliacao());
            dto.setFilmeId(avaliacao.getFilme().getIdFilme());
            dto.setFilmeTitulo(avaliacao.getFilme().getTitulo());
            dto.setNomeUsuario(avaliacao.getUsuario().getNome());
            avaliacoesDTO.add(dto);
        }
        return avaliacoesDTO;
    }

    public AvaliacaoFilmeDTOResponse inserir(AvaliacaoFilmeDTORequest dto) {
        Filme filme = filmeRepository.findById(dto.getFilmeId())
        		.orElseThrow(() -> new RecursoNaoEncontradoException("Filme não encontrado com id: " + dto.getFilmeId()));
        
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + dto.getUsuarioId()));
     
        AvaliacaoFilme avaliacao = new AvaliacaoFilme();
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setDataAvaliacao(LocalDate.now());
        avaliacao.setFilme(filme);
        avaliacao.setUsuario(usuario);
        
        
        avaliacao = avaliacaoFilmeRepository.save(avaliacao);

        Double media = avaliacaoFilmeRepository.calcularMediaNotasPorFilme(filme.getIdFilme());
        filme.setNotaMedia(media);
        filmeRepository.save(filme);
        
    
        AvaliacaoFilmeDTOResponse response = new AvaliacaoFilmeDTOResponse();
        response.setId(avaliacao.getId());
        response.setNota(avaliacao.getNota());
        response.setComentario(avaliacao.getComentario());
        response.setDataAvaliacao(avaliacao.getDataAvaliacao());
        response.setFilmeId(filme.getIdFilme());
        response.setFilmeTitulo(filme.getTitulo());
        response.setNomeUsuario(avaliacao.getUsuario().getNome());

        return response;
    }
    
    public AvaliacaoFilmeDTOResponse atualizar(Long id, AvaliacaoFilmeDTORequest dto) {
        AvaliacaoFilme avaliacao = avaliacaoFilmeRepository.findById(id)
        		.orElseThrow(() -> new RecursoNaoEncontradoException("Avaliação não encontrada com id: " + id));

        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());

        avaliacao = avaliacaoFilmeRepository.save(avaliacao);
        
        Double media = avaliacaoFilmeRepository.calcularMediaNotasPorFilme(avaliacao.getFilme().getIdFilme());
        avaliacao.getFilme().setNotaMedia(media);
        filmeRepository.save(avaliacao.getFilme());

        AvaliacaoFilmeDTOResponse response = new AvaliacaoFilmeDTOResponse();
        response.setId(avaliacao.getId());
        response.setFilmeId(avaliacao.getFilme().getIdFilme());
        response.setFilmeTitulo(avaliacao.getFilme().getTitulo());
        response.setNota(avaliacao.getNota());
        response.setComentario(avaliacao.getComentario());
        response.setDataAvaliacao(avaliacao.getDataAvaliacao());
        response.setNomeUsuario(avaliacao.getUsuario().getNome());

        return response;
    }  

    public void deletar(Long id) {
        AvaliacaoFilme avaliacao = avaliacaoFilmeRepository.findById(id)
        		.orElseThrow(() -> new RecursoNaoEncontradoException("Avaliação não encontrada com id: " + id));

        Filme filme = avaliacao.getFilme();
        avaliacaoFilmeRepository.delete(avaliacao);

     
        Double media = avaliacaoFilmeRepository.calcularMediaNotasPorFilme(filme.getIdFilme());
        filme.setNotaMedia(media);
        filmeRepository.save(filme);
    }
}