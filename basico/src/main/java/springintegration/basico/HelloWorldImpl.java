package springintegration.basico;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl implements HolaMundo {

	public String saludar(String nombre) {
		return "Hello " + nombre;
	}

}
