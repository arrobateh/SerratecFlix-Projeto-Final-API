package org.serratec.SerratecFlix.service;

import org.serratec.SerratecFlix.domain.ListaFavoritos;
import org.serratec.SerratecFlix.domain.Usuario;
import org.serratec.SerratecFlix.dto.ListaFavoritosRequestDto;
import org.serratec.SerratecFlix.dto.ListaFavoritosResponseDto;
import org.serratec.SerratecFlix.repository.ListaFavoritosRepository;
import org.serratec.SerratecFlix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaFavoritosService {
    
    @Autowired
    private ListaFavoritosRepository listaFavoritosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ListaFavoritosResponseDto> findAll() {
        return listaFavoritosRepository.findAll()
                .stream()
                .map(ListaFavoritosResponseDto::from)
                .collect(Collectors.toList());
    }

    public ListaFavoritosResponseDto findById(Long id) {
        return listaFavoritosRepository.findById(id)
                .map(ListaFavoritosResponseDto::from)
                .orElseThrow(() -> new RuntimeException("Nenhuma Lista Favorita foi encontrada"));
    }

    public ListaFavoritosResponseDto criar(ListaFavoritosRequestDto listaFavoritosRequestDto) {
        Usuario usuario = usuarioRepository.findById(listaFavoritosRequestDto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (listaFavoritosRepository.existsByNomeLista(listaFavoritosRequestDto.getNomeLista())) {
            throw new RuntimeException("Já existe uma lista com esse nome");
        }
        ListaFavoritos listaFavoritos = new ListaFavoritos();
        listaFavoritos.setUsuario(usuario);
        listaFavoritos.setNomeLista(listaFavoritosRequestDto.getNomeLista());
        return ListaFavoritosResponseDto.from(listaFavoritosRepository.save(listaFavoritos));
    }

    public ListaFavoritosResponseDto atualizar(Long id, ListaFavoritosRequestDto listaFavoritosRequestDto) {
        ListaFavoritos listaFavoritos = listaFavoritosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        if (listaFavoritosRepository.existsByNomeListaAndIdNot(listaFavoritosRequestDto.getNomeLista(), id)) {
            throw new RuntimeException("Já existe uma lista com esse nome");
        }
        listaFavoritos.setNomeLista(listaFavoritosRequestDto.getNomeLista());

        return ListaFavoritosResponseDto.from(listaFavoritosRepository.save(listaFavoritos));
    }

    public void deletar(Long id) {
        if (!listaFavoritosRepository.existsById(id)) {
            throw new RuntimeException("Nenhum ListaFavorito foi encontrado");
        }
        listaFavoritosRepository.deleteById(id);
    }
}
