package springintegration.basicoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springintegration.basicoint.channel.HolaMundoDirectoChannel;
import springintegration.basicoint.channel.HolaMundoPSChannel;
import springintegration.basicoint.channel.HolaMundoQueueChannel;
import springintegration.basicoint.channel.HolaMundoSalidaChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basico-ctx.xml");
        
        // DirectChannel
        HolaMundoDirectoChannel hmdc = ctx.getBean(HolaMundoDirectoChannel.class);
        hmdc.suscribir(); // Suscribiendo para leer
        
        hmdc.enviar("Hola");
        hmdc.enviar("Juan");
        hmdc.enviar("María");
        
        // QueueChannel
        HolaMundoQueueChannel hmqc = ctx.getBean(HolaMundoQueueChannel.class);
        new Thread(new HolaMundoQueueChannelThread(hmqc)).start(); // Desprende un hilo para leer  
        
        hmqc.enviar("Hola");
        hmqc.enviar("Juan");
        hmqc.enviar("María");
        
        // PublishSubscribeChannel
        HolaMundoPSChannel hmpsc1 = ctx.getBean(HolaMundoPSChannel.class);
        hmpsc1.suscribir();
        HolaMundoPSChannel hmpsc2 = ctx.getBean(HolaMundoPSChannel.class);
        hmpsc2.suscribir();
        HolaMundoPSChannel hmpsc3 = ctx.getBean(HolaMundoPSChannel.class);
        hmpsc3.suscribir();
        
        hmpsc1.enviar("Para todos");
        
        // DirectChannel - HolaMundoSalidaChannel
        HolaMundoSalidaChannel hmsc = ctx.getBean(HolaMundoSalidaChannel.class);
        hmsc.suscribir();
    }
    
    public static class HolaMundoQueueChannelThread implements Runnable {
    	private HolaMundoQueueChannel hmqc;
    	
		public HolaMundoQueueChannelThread(HolaMundoQueueChannel hmqc) {
			this.hmqc = hmqc;
		}

		public void run() {
			while (true)
				hmqc.recibir();
		}
    	
    }
}
