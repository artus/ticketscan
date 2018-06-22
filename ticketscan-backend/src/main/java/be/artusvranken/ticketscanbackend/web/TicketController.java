package be.artusvranken.ticketscanbackend.web;

import be.artusvranken.ticketscanbackend.db.TicketRepository;
import be.artusvranken.ticketscanbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.ticketRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicket(@PathVariable String id) {
        Optional<Ticket> retrievedTicket = this.ticketRepository.findById(id);

        if (retrievedTicket.isPresent()) return ResponseEntity.ok(retrievedTicket.get());
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity addTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = this.ticketRepository.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @PostMapping("/{id}")
    public ResponseEntity scanTicket(@PathVariable String id) {

        Optional<Ticket> optionalTicket = this.ticketRepository.findById(Long.parseLong(id));
        Ticket concreteTicket;
        if (optionalTicket.isPresent()) concreteTicket = optionalTicket.get();
        else {
            optionalTicket = this.ticketRepository.findByUserId(id);
            if (optionalTicket.isPresent()) concreteTicket = optionalTicket.get();
            else return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        concreteTicket.setScanned(true);
        Ticket savedTicket = this.ticketRepository.save(concreteTicket);

        return ResponseEntity.ok(savedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable String id) {
        Optional<Ticket> retrievedTicket = this.ticketRepository.findById(id);
        if (retrievedTicket.isPresent()) {
            this.ticketRepository.delete(retrievedTicket.get());
            return ResponseEntity.ok(retrievedTicket);
        }
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
