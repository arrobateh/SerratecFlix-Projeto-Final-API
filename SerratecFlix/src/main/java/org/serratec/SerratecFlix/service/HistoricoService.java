package org.serratec.SerratecFlix.service;

import org.serratec.SerratecFlix.domain.Filme;
import org.serratec.SerratecFlix.domain.Historico;
import org.serratec.SerratecFlix.domain.Serie;
import org.serratec.SerratecFlix.domain.Usuario;
import org.serratec.SerratecFlix.dto.HistoricoRequestDTO;
import org.serratec.SerratecFlix.dto.HistoricoResponseDTO;
import org.serratec.SerratecFlix.exception.ConflitoException;
import org.serratec.SerratecFlix.repository.FilmeRepository;
import org.serratec.SerratecFlix.repository.HistoricoRepository;
import org.serratec.SerratecFlix.repository.SerieRepository;
import org.serratec.SerratecFlix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SerieRepository serieRepository;

    public HistoricoResponseDTO adicionar(HistoricoRequestDTO dto) {
        if (dto.getIdFilme() == null && dto.getIdSerie() == null) {
            throw new ConflitoException("Informe ao menos um filme ou série.");
        }
        if (dto.getIdFilme() != null && dto.getIdSerie() != null) {
            throw new ConflitoException("Informe apenas filme OU série, não os dois.");
        }

        Historico historico = new Historico();

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new ConflitoException("Usuário não encontrado."));
        historico.setUsuario(usuario);

        if (dto.getIdFilme() != null) {
            Filme filme = filmeRepository.findById(dto.getIdFilme()).orElseThrow(() -> new ConflitoException("Filme não encontrado."));
            historico.setFilme(filme);
        }
        if (dto.getIdSerie() != null) {
            Serie serie = serieRepository.findById(dto.getIdSerie()).orElseThrow(() -> new ConflitoException("Série não encontrada."));
            historico.setSerie(serie);
        }
        historico.setStatus(dto.getStatus());
        historico.setDataAssistido(LocalDate.now());

        return HistoricoResponseDTO.from(historicoRepository.save(historico));
    }

    public List<HistoricoResponseDTO> buscarPorUsuario(Long usuarioId) {
        return historicoRepository
                .findByUsuarioIdOrderByDataAssistidoDesc(usuarioId)
                .stream()
                .map(HistoricoResponseDTO::from)
                .toList();
    }

    public void remover(Long id) {
        if (!historicoRepository.existsById(id)) {
            throw new ConflitoException("Histórico não encontrado.");
        }
        historicoRepository.deleteById(id);
    }
}
