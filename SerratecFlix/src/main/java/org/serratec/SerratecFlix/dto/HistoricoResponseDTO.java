package org.serratec.SerratecFlix.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.serratec.SerratecFlix.domain.Historico;
import org.serratec.SerratecFlix.domain.StatusAssistido;

import java.time.LocalDate;

public class HistoricoResponseDTO {

    private Long id;
    private String nomeUsuario;
    private String tituloFilme;
    private String tituloSerie;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAssistido;
    private StatusAssistido status;

    public static HistoricoResponseDTO from(Historico historico) {
        HistoricoResponseDTO dto = new HistoricoResponseDTO();
        dto.id = historico.getId();
        dto.nomeUsuario = historico.getUsuario().getNome();
        dto.tituloFilme = historico.getFilme() != null ? historico.getFilme().getTitulo() : null;
        dto.tituloSerie = historico.getSerie() != null ? historico.getSerie().getTituloSerie() : null;
        dto.dataAssistido = LocalDate.from(historico.getDataAssistido());
        dto.status = historico.getStatus();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getTituloSerie() {
        return tituloSerie;
    }

    public void setTituloSerie(String tituloSerie) {
        this.tituloSerie = tituloSerie;
    }

    public LocalDate getDataAssistido() {
        return dataAssistido;
    }

    public void setDataAssistido(LocalDate dataAssistido) {
        this.dataAssistido = dataAssistido;
    }

    public StatusAssistido getStatus() {
        return status;
    }

    public void setStatus(StatusAssistido status) {
        this.status = status;
    }
}
