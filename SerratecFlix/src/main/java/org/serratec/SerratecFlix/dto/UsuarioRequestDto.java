package org.serratec.SerratecFlix.dto;

import jakarta.validation.constraints.*;

public class UsuarioRequestDto {

    @NotNull(message = "Nome dever ser preenchido")
    @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "email dever ser preenchido")
    private String email;

    @NotBlank(message = "username dever ser preenchido")
    private String username;

    @NotBlank(message = "senha dever ser preenchida")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
