package com.linguagenscomerciais.trabalho01.repositories;

import com.linguagenscomerciais.trabalho01.models.SupportTicket;
import com.linguagenscomerciais.trabalho01.models.enums.Priority;
import com.linguagenscomerciais.trabalho01.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {

    List<SupportTicket> findByDepartment(String department);

    List<SupportTicket> findByPriority(Priority priority);

    Optional<SupportTicket> findByTitle(String title);

    List<SupportTicket> findByPriorityAndStatusNot(Priority priority, Status status);

    Long countByStatus(Status status);

}
