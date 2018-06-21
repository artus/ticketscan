package be.artusvranken.ticketscanbackend.web;

import be.artusvranken.ticketscanbackend.db.TicketRepository;
import be.artusvranken.ticketscanbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(this.ticketRepository.findById(id).get());
    }

    @PostMapping("/ticket")
    public ResponseEntity addTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(this.ticketRepository.save(ticket));
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
