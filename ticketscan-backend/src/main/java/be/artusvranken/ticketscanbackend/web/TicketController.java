package be.artusvranken.ticketscanbackend.web;

import be.artusvranken.ticketscanbackend.db.TicketRepository;
import be.artusvranken.ticketscanbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/ticket")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.ticketRepository.findAll());
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity getTicket(@PathVariable String id) {
        Optional<Ticket> retrievedTicket = this.ticketRepository.findById(id);

        if (retrievedTicket.isPresent()) return ResponseEntity.ok(retrievedTicket.get());
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path= "/ticket", consumes = "application/json", produces = "application/json")
    public ResponseEntity addTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = this.ticketRepository.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @PostMapping("/ticket/{id}")
    public ResponseEntity scanTicket(@PathVariable String id) {
        Ticket retrievedTicket = this.ticketRepository.findById(id).get();
        Ticket savedTicket = new Ticket();
        if (retrievedTicket.isScanned()) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else {
            retrievedTicket.setScanned(true);
            savedTicket = this.ticketRepository.save(retrievedTicket);
        }
        return new ResponseEntity<>(retrievedTicket, HttpStatus.OK);
    }
}
