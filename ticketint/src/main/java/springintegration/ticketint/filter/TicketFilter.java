package springintegration.ticketint.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import springintegration.ticketint.to.Ticket;

@Component
public class TicketFilter {
	public boolean filtrar(Ticket t) {
		try {
			return (t.getFecha().getTime() >= 
					new SimpleDateFormat("yyyy-MM-dd")
						.parse("2013-03-01").getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
