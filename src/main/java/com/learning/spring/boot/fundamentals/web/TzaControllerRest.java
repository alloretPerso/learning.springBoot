package com.learning.spring.boot.fundamentals.web;

import com.learning.spring.boot.fundamentals.entity.Application;
import com.learning.spring.boot.fundamentals.entity.Ticket;
import com.learning.spring.boot.fundamentals.service.ApplicationService;
import com.learning.spring.boot.fundamentals.service.ReleaseService;
import com.learning.spring.boot.fundamentals.service.TicketService;
import com.learning.spring.boot.fundamentals.errors.ApplicationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/tza")
public class TzaControllerRest {
    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> list = (List<Application>) applicationService.listApplications();
        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<Application>(applicationService.findApplication(id),
                    HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
        }
    }

    @GetMapping("/tickets")
    public HttpEntity<List<Ticket>> retrieveTickets(Model model){
        List<Ticket> tickets = (List<Ticket>) ticketService.listTickets();
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

/*    @GetMapping("/releases")
    public String retrieveReleases(Model model){
        model.addAttribute("releases", releaseService.listReleases());
        return "releases";
    }*/


}