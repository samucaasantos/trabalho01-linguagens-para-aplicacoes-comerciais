package com.linguagenscomerciais.trabalho01.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.linguagenscomerciais.trabalho01.models.enums.Priority;
import com.linguagenscomerciais.trabalho01.models.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "support_tickets")
public class SupportTicket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @JsonAlias({"titulo", "título"})
    private String title;

    @Setter
    @JsonAlias("solicitante")
    private String requester;

    @Setter
    @JsonAlias({"setor", "departamento"})
    private String department;

    @Setter
    @JsonAlias("prioridade")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Setter
    @JsonAlias("estado")
    @Enumerated(EnumType.STRING)
    private Status status;

    public SupportTicket() {
    }

    public SupportTicket(Long id, String title, String requester, String department, Priority priority, Status status) {
        this.id = id;
        this.title = title;
        this.requester = requester;
        this.department = department;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        SupportTicket that = (SupportTicket) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
