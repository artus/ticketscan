package be.artusvranken.ticketscanbackend.web;

import be.artusvranken.ticketscanbackend.db.TicketRepository;
import be.artusvranken.ticketscanbackend.model.Ticket;
import ch.qos.logback.core.CoreConstants;
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
		
		if (this.ticketRepository.findByUserId(ticket.getUserId()).isPresent()) return new ResponseEntity(HttpStatus.CONFLICT);

        Ticket savedTicket = this.ticketRepository.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @PostMapping("/{id}")
    public ResponseEntity scanTicket(@PathVariable String id) {

        Optional<Ticket> optionalTicket = null;
        Ticket concreteTicket;

        try {
            optionalTicket =  this.ticketRepository.findById(Long.parseLong(id));
        }
        catch (Exception e) {
            // Heh
        }

        if (optionalTicket != null && optionalTicket.isPresent()) concreteTicket = optionalTicket.get();
        else {
            optionalTicket = this.ticketRepository.findByUserId(id);
            if (optionalTicket.isPresent()) concreteTicket = optionalTicket.get();
            else return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        if (concreteTicket.isScanned()) return new ResponseEntity(HttpStatus.CONFLICT);

        concreteTicket.setScanned(true);
        Ticket savedTicket = this.ticketRepository.save(concreteTicket);

        return ResponseEntity.ok(savedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable String id) {
        Optional<Ticket> optionalTicket = null;
        Ticket concreteTicket;

        try {
            optionalTicket =  this.ticketRepository.findById(Long.parseLong(id));
        }
        catch (Exception e) {
            // Heh
        }

        if (optionalTicket != null && optionalTicket.isPresent()) concreteTicket = optionalTicket.get();
        else {
            optionalTicket = this.ticketRepository.findByUserId(id);
            if (optionalTicket.isPresent()) concreteTicket = optionalTicket.get();
            else return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        this.ticketRepository.delete(concreteTicket);
		return ResponseEntity.ok(concreteTicket);
    }
}
