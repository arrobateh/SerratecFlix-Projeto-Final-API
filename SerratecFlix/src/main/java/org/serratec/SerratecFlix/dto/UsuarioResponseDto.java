package org.serratec.SerratecFlix.dto;

import org.serratec.SerratecFlix.domain.Usuario;

public class UsuarioResponseDto {

    private Long id;

    private String nome;

    private String email;

    private String username;

    public static UsuarioResponseDto from(Usuario usuario) {
        UsuarioResponseDto usuarioDto = new UsuarioResponseDto();
        usuarioDto.id = usuario.getId();
        usuarioDto.nome = usuario.getNome();
        usuarioDto.email = usuario.getEmail();
        usuarioDto.username = usuario.getUsername();
        return usuarioDto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
