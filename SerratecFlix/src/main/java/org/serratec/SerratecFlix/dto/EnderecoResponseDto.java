package org.serratec.SerratecFlix.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.SerratecFlix.domain.Endereco;

@JsonPropertyOrder({"id", "pessoaId", "cep", "logradouro", "bairro", "cidade", "uf"})
@Schema(description = "Dados de um endereço")
public class EnderecoResponseDto {

    @Schema(description = "ID do endereço", example = "1")
    private Long id;

    @Schema(description = "CEP", example = "25780-000")
    private String cep;

    @Schema(description = "Logradouro", example = "Rua Francisco")
    private String logradouro;

    @Schema(description = "Bairro", example = "Centro")
    private String bairro;

    @Schema(description = "Cidade", example = "Sao Jose")
    private String cidade;

    @Schema(description = "UF", example = "RJ")
    private String uf;


    @Schema(description = "ID da pessoa dona do endereço", example = "1")
    private Long pessoaId;

    public EnderecoResponseDto() {
    }

    public static EnderecoResponseDto from(Endereco endereco) {
        EnderecoResponseDto dto = new EnderecoResponseDto();
        dto.id = endereco.getId();
        dto.logradouro = endereco.getLogradouro();
        dto.bairro = endereco.getBairro();
        dto.cidade = endereco.getCidade();
        dto.uf = endereco.getUf();
        dto.cep = endereco.getCep();
        dto.pessoaId = endereco.getUsuario().getId();
        if (endereco.getUsuario() != null)
            dto.pessoaId = endereco.getUsuario().getId();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
