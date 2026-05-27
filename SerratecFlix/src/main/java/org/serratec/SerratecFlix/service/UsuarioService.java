package org.serratec.SerratecFlix.service;

import org.serratec.SerratecFlix.domain.Endereco;
import org.serratec.SerratecFlix.domain.Usuario;
import org.serratec.SerratecFlix.dto.UsuarioRequestDto;
import org.serratec.SerratecFlix.dto.UsuarioResponseDto;
import org.serratec.SerratecFlix.exception.ConflitoException;
import org.serratec.SerratecFlix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ViaCepService viaCepService;

    public List<UsuarioResponseDto> listaUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponseDto::from)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDto findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
        return UsuarioResponseDto.from(usuario);
    }

    public UsuarioResponseDto salvar(UsuarioRequestDto usuarioRequestDto) {
        if (usuarioRepository.existsByEmail(usuarioRequestDto.getEmail())) {
            throw new ConflitoException("Email já cadastrado");
        }

        ViaCepDto viaCep = viaCepService.buscarViaCep(usuarioRequestDto.getCep());

        Endereco endereco = new Endereco();

        endereco.setCep(viaCep.getCep());
        endereco.setLogradouro(viaCep.getLogradouro());
        endereco.setBairro(viaCep.getBairro());
        endereco.setCidade(viaCep.getCidade());
        endereco.setUf(viaCep.getUf());

        Usuario usuario = new Usuario();

        usuario.setNome(usuarioRequestDto.getNome());
        usuario.setEmail(usuarioRequestDto.getEmail());
        usuario.setUsername(usuarioRequestDto.getUsername()); 
        return UsuarioResponseDto.from(usuarioRepository.save(usuario));
    }

    public UsuarioResponseDto atualizar(Long id, UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
        usuario.setNome(usuarioRequestDto.getNome());
        usuario.setSenha(usuarioRequestDto.getSenha());
        usuario.setEmail(usuarioRequestDto.getEmail());
        return UsuarioResponseDto.from(usuarioRepository.save(usuario));
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usario");
        }
        usuarioRepository.deleteById(id);
    }
}
