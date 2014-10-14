package springintegration.ticketint.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import springintegration.ticketint.to.Ticket;
import springintegration.ticketint.to.Ticket.Prioridad;

@Component
public class ByteToTicketService {
	@ServiceActivator
	public List<Ticket> toTickets(byte[] bytes) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new ByteArrayInputStream(bytes)
					));
			
			String linea = br.readLine();
			Ticket t = null;
			while (linea != null) {
				t = new Ticket();
				int contador = 0;
				StringTokenizer tokenizer = new StringTokenizer(linea, "|");
				
				while (tokenizer.hasMoreElements()) {
					String campo = (String)tokenizer.nextElement();
					
					if (contador == 0)
						t.setId(Integer.parseInt(campo));
					else if (contador == 1) 
						t.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(campo));
					else if (contador == 2)
						t.setDescripcion(campo);
					else if (contador == 3)
						t.setPrioridad(Prioridad.valueOf(campo));
					
					contador++;
				}
				
				tickets.add(t);
				
				linea = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return tickets;
	}
}
