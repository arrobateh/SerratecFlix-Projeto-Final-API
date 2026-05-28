package org.serratec.SerratecFlix.dto;

import org.serratec.SerratecFlix.domain.StatusAssistido;

public class HistoricoRequestDTO {

    private Long usuarioId;
    private Long idFilme;
    private Long idSerie;
    private StatusAssistido status;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public StatusAssistido getStatus() {
        return status;
    }

    public void setStatus(StatusAssistido status) {
        this.status = status;
    }
}
