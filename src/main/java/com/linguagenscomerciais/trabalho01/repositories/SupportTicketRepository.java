package com.linguagenscomerciais.trabalho01.repositories;

import com.linguagenscomerciais.trabalho01.models.SupportTicket;
import com.linguagenscomerciais.trabalho01.models.enums.Priority;
import com.linguagenscomerciais.trabalho01.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {

    List<SupportTicket> findByDepartmentIgnoreCase(String department);

    List<SupportTicket> findByPriority(Priority priority);

    List<SupportTicket> findByTitleContainingIgnoreCase(String title);

    List<SupportTicket> findByPriorityAndStatusNot(Priority priority, Status status);

    long countByStatus(Status status);

}
