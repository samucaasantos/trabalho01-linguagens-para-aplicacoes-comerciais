package com.linguagenscomerciais.trabalho01.controllers;

import com.linguagenscomerciais.trabalho01.models.SupportTicket;
import com.linguagenscomerciais.trabalho01.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/chamados")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;

    @GetMapping
    public ResponseEntity<List<SupportTicket>> findAll() {
        List<SupportTicket> tickets = supportTicketService.findAll();
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SupportTicket> findById(@PathVariable Long id) {
        SupportTicket ticket = supportTicketService.findById(id);
        return ResponseEntity.ok().body(ticket);

    }

    @PostMapping
    public ResponseEntity<SupportTicket> insert(@RequestBody SupportTicket supportTicket) {
        supportTicket = supportTicketService.insert(supportTicket);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(supportTicket.getId()).toUri();
        return ResponseEntity.created(uri).body(supportTicket);
    }

    @GetMapping("/setor")
    public ResponseEntity<List<SupportTicket>> findByDepartment(@RequestParam("nome") String department) {
        List<SupportTicket> departmentTickets = supportTicketService.findByDepartment(department);
        return ResponseEntity.ok().body(departmentTickets);
    }

    @GetMapping("/prioridade")
    public ResponseEntity<List<SupportTicket>> findByPriority(@RequestParam("nivel") String level) {
        List<SupportTicket> priorityTickets = supportTicketService.findByPriority(level);
        return ResponseEntity.ok().body(priorityTickets);
    }

    @GetMapping("/busca")
    public ResponseEntity<List<SupportTicket>> findByTitle(@RequestParam("texto") String title) {
        List<SupportTicket> ticketTitles = supportTicketService.findByTitle(title);
        return ResponseEntity.ok().body(ticketTitles);
    }

    @GetMapping("/criticos")
    public ResponseEntity<List<SupportTicket>> findCriticalTickets() {
        List<SupportTicket> criticalTickets = supportTicketService.findCriticalTickets();
        return ResponseEntity.ok().body(criticalTickets);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Map<String, Long>> getTicketsSummary() {
        Map<String, Long> summary = supportTicketService.getTicketsSummary();
        return ResponseEntity.ok().body(summary);
    }
}
