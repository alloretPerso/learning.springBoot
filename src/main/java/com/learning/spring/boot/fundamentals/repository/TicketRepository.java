package com.learning.spring.boot.fundamentals.repository;

import com.learning.spring.boot.fundamentals.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
