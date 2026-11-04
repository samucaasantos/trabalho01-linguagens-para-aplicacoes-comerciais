package com.linguagenscomerciais.trabalho01.service;

import com.linguagenscomerciais.trabalho01.models.SupportTicket;
import com.linguagenscomerciais.trabalho01.models.enums.Priority;
import com.linguagenscomerciais.trabalho01.models.enums.Status;
import com.linguagenscomerciais.trabalho01.repositories.SupportTicketRepository;
import com.linguagenscomerciais.trabalho01.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository repository;

    public List<SupportTicket> findAll() {
        return repository.findAll();
    }

    public SupportTicket findById(Long id) {
        Optional<SupportTicket> supportTicket = repository.findById(id);
        return supportTicket.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public SupportTicket insert(SupportTicket supportTicket) {
        if (supportTicket.getStatus() == null) {
            supportTicket.setStatus(Status.ABERTO);
        }
        return repository.save(supportTicket);
    }

    public List<SupportTicket> findByDepartment(String department) {
        return repository.findByDepartmentIgnoreCase(department);
    }

    public List<SupportTicket> findByPriority(String level) {
        try {
            Priority priority = Priority.valueOf(level.toUpperCase());
            return repository.findByPriority(priority);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Prioridade inválida: " + level);
        }

    }

    public List<SupportTicket> findByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<SupportTicket> findCriticalTickets() {
        return repository.findByPriorityAndStatusNot(Priority.ALTA, Status.RESOLVIDO);
    }

    public Map<String, Long> getTicketsSummary(){
        Map<String, Long> summary = new LinkedHashMap<>();
        long opened = repository.countByStatus(Status.ABERTO);
        long solving = repository.countByStatus(Status.EM_ANDAMENTO);
        long solved = repository.countByStatus(Status.RESOLVIDO);
        long total = repository.count();

        summary.put("abertos", opened);
        summary.put("emAndamento", solving);
        summary.put("resolvidos", solved);
        summary.put("total", total);

        return summary;
    }
}
