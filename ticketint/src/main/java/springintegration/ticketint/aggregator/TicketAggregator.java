package springintegration.ticketint.aggregator;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.stereotype.Component;

import springintegration.ticketint.to.Ticket;

@Component
public class TicketAggregator {
	private static final String ARCHIVO = "output/totalTickets.csv"; 
	
	@Aggregator
	public String escribir(List<Ticket> tickets) {
		int totalTickets = tickets.size();
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(ARCHIVO));
			pw.println("totalTickets," + totalTickets);
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
		}
		
		return "";
	}
}
