package springintegration.ticketint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springintegration.ticketint.channel.TicketChannel;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("ticket-ctx.xml");
    	
    	TicketChannel tch = ctx.getBean(TicketChannel.class);
    	tch.suscribir();
    }
}
