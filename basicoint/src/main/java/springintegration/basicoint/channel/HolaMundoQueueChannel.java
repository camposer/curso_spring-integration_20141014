package springintegration.basicoint.channel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class HolaMundoQueueChannel {
	private final long TIMEOUT = 1000;
	private QueueChannel canal;

	@Value("#{canalCola}")
	public void setCanal(QueueChannel canal) {
		this.canal = canal;
	}

	public void enviar(String mensaje) {
		canal.send(MessageBuilder.withPayload(mensaje).build());
	}

	public void recibir() {
		Message<?> msg = canal.receive(TIMEOUT);
		if (msg != null)
			System.out.println("HolaMundoQueueReader: " + msg);
	}
}