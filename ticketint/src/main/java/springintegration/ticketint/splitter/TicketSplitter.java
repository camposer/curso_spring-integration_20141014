package springintegration.ticketint.splitter;

import java.util.List;

import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import springintegration.ticketint.to.Ticket;

@Component
public class TicketSplitter {
	@Splitter
	public List<Ticket> split(List<Ticket> tickets) {
		return tickets;
	}
}
