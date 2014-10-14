package springintegration.basicoint.service;

import org.springframework.stereotype.Component;

import springintegration.basicoint.to.Envoltorio;

@Component
public class CanalService {
	public void canalPS(String msg) {
		System.out.println("CanalService.canalPS: " + msg);
	}
	
	public Envoltorio traductor(String msg) {
		return new Envoltorio(msg);
	}
}

