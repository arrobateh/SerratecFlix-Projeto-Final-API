package org.serratec.SerratecFlix.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.Usuario;

public class UsuarioResponseDto {

    @Schema(description = "ID da usuario", example = "1")
    private Long id;

    @Schema(description = "Nome completo", example = "Igor Brian")
    private String nome;

    @Schema(description = "Email", example = "igor@email.com")
    private String email;

    @Schema(description = "nome usuario", example = "IgorBraia")
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
