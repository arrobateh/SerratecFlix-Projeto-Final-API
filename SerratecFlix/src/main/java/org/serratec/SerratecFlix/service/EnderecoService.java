package org.serratec.SerratecFlix.service;

import org.serratec.SerratecFlix.domain.Endereco;
import org.serratec.SerratecFlix.domain.Usuario;
import org.serratec.SerratecFlix.dto.EnderecoRequestDto;
import org.serratec.SerratecFlix.dto.EnderecoResponseDto;
import org.serratec.SerratecFlix.exception.RecursoNaoEncontradoException;
import org.serratec.SerratecFlix.repository.EndereceRepository;
import org.serratec.SerratecFlix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EndereceRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<EnderecoResponseDto> findAll() {
        return enderecoRepository.findAll()
                .stream()
                .map(EnderecoResponseDto::from)
                .collect(Collectors.toList());
    }

    public EnderecoResponseDto findById(Long id) {
        Endereco e = enderecoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Endereço"));
        return EnderecoResponseDto.from(e);
    }

    public EnderecoResponseDto salvar(EnderecoRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa"));

        Endereco e = new Endereco();
        e.setUsuario(usuario);
        e.setCep(dto.getCep());
        e.setLogradouro(dto.getLogradouro());
        e.setBairro(dto.getBairro());
        e.setCidade(dto.getCidade());
        e.setUf(dto.getUf());
        return EnderecoResponseDto.from(enderecoRepository.save(e));
    }

    public EnderecoResponseDto atualizar(Long id, EnderecoRequestDto dto) {
        Endereco e = enderecoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Endereço"));
        e.setLogradouro(dto.getLogradouro());
        e.setCep(dto.getCep());
        e.setBairro(dto.getBairro());
        e.setCidade(dto.getCidade());
        e.setUf(dto.getUf());
        return EnderecoResponseDto.from(enderecoRepository.save(e));
    }

    public void delete(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Endereço");
        }
        enderecoRepository.deleteById(id);
    }
}
