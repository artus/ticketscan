package be.artusvranken.ticketscanbackend.web;

import be.artusvranken.ticketscanbackend.db.TicketRepository;
import be.artusvranken.ticketscanbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/ticket")
    public List<Ticket> getAll() {
        return this.ticketRepository.findAll();
    }
}
