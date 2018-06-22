package be.artusvranken.ticketscanbackend.db;

import be.artusvranken.ticketscanbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, String> {

    public Optional<Ticket> findByUserId(String userId);

}
