package be.artusvranken.ticketscanbackend.db;

import be.artusvranken.ticketscanbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
