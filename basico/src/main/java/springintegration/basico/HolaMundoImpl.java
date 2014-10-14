package springintegration.basico;

import org.springframework.stereotype.Component;

@Component
public class HolaMundoImpl implements HolaMundo {

	public String saludar(String nombre) {
		return "Hola " + nombre;
	}
}
