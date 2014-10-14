package springintegration.ticketint.channel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.AbstractSubscribableChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.stereotype.Component;

@Component
public class TicketPrioridadBajaChannel implements MessageHandler {
	private AbstractSubscribableChannel canal;
	
	@Value("#{ticketPrioridadBaja}") // spEl
	public void setCanal(AbstractSubscribableChannel canal) {
		this.canal = canal;
	}
	
	public void suscribir() {
		canal.subscribe(this);
	}
	
	public void handleMessage(Message<?> msg) throws MessagingException {
		System.out.println("TicketPrioridadBajaChannel: " + msg);
	}
	
}
