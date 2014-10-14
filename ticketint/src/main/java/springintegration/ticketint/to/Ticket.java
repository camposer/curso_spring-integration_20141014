package springintegration.ticketint.to;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date fecha;
	private String descripcion;
	private Prioridad prioridad;
	
	public static enum Prioridad {
		low, high, emergency; 
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Prioridad getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", fecha=" + fecha + ", descripcion="
				+ descripcion + ", prioridad=" + prioridad + "]";
	}
}
