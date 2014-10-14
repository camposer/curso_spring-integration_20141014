package springintegration.ticketint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import springintegration.ticketint.to.Ticket;

@Component
public class ByteToTicketService {
	@ServiceActivator
	public List<Ticket> toTickets(byte[] bytes) {
		List<Ticket> tickets = new ArrayList<Ticket>();

		
		
		tickets.add(new Ticket());
		
		return tickets;
	}
}
