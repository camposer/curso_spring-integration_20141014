package springintegration.ticketint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springintegration.ticketint.channel.TicketChannel;
import springintegration.ticketint.channel.TicketPrioridadAltaChannel;
import springintegration.ticketint.channel.TicketPrioridadBajaChannel;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("ticket-ctx.xml");
    	ctx.getBean(TicketChannel.class).suscribir();
    	ctx.getBean(TicketPrioridadBajaChannel.class).suscribir();
    	ctx.getBean(TicketPrioridadAltaChannel.class).suscribir();
    }
}
