package com.learning.spring.boot.fundamentals.service;


import com.learning.spring.boot.fundamentals.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}


