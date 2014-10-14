package springintegration.ticketint.router;

import org.springframework.integration.annotation.Router;
import org.springframework.stereotype.Component;

import springintegration.ticketint.to.Ticket;
import springintegration.ticketint.to.Ticket.Prioridad;

@Component
public class TicketRouter {
	@Router
	public String route(Ticket t) {
		if (t.getPrioridad().equals(Prioridad.low))
			return "ticketPrioridadBaja";
		else // high y emergency
			return "ticketPrioridadAlta";
	}
}
