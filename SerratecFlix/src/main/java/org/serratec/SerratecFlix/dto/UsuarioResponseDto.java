package org.serratec.SerratecFlix.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.Endereco;
import org.serratec.SerratecFlix.domain.Usuario;

@JsonPropertyOrder({"id", "nome", "email", "username", "endereco"})
public class UsuarioResponseDto {

    @Schema(description = "ID da usuario", example = "1")
    private Long id;

    @Schema(description = "Nome completo", example = "Igor Brian")
    private String nome;

    @Schema(description = "Email", example = "igor@email.com")
    private String email;

    @Schema(description = "nome usuario", example = "IgorBraia")
    private String username;

    @Schema(description = "Endereco do usuario")
    private Endereco endereco;

    public UsuarioResponseDto() {
    }

    public static UsuarioResponseDto from(Usuario usuario) {
        UsuarioResponseDto usuarioDto = new UsuarioResponseDto();
        usuarioDto.id = usuario.getId();
        usuarioDto.nome = usuario.getNome();
        usuarioDto.email = usuario.getEmail();
        usuarioDto.username = usuario.getUsername();
        usuarioDto.endereco = usuario.getEndereco();
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
