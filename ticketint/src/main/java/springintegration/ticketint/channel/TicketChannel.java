package springintegration.ticketint.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.jms.SubscribableJmsChannel;
import org.springframework.stereotype.Component;

import springintegration.ticketint.to.Ticket;

@Component
public class TicketChannel implements MessageHandler {
	private SubscribableJmsChannel canal;
	
	@Value("#{ticket}") // spEl
	public void setCanal(SubscribableJmsChannel canal) {
		this.canal = canal;
	}
	
	public void suscribir() {
		canal.subscribe(this);
	}
	
	@SuppressWarnings("unchecked")
	public void handleMessage(Message<?> msg) throws MessagingException {
		System.out.println("TicketChannel...");
		List<Ticket> tickets = (List<Ticket>)msg.getPayload();
		for (Ticket t : tickets) 
			System.out.println(t);
	}
	
}
