package model;

public class Evento {

	private int evento;
	private String nombre;
	private Olimpiada olimpiada;
	private Deporte deporte;
	
	public Evento(int evento, String nombre, Olimpiada olimpiada, Deporte deporte) {
		super();
		this.evento = evento;
		this.nombre = nombre;
		this.olimpiada = olimpiada;
		this.deporte = deporte;
	}

	public Evento() {
		super();
	}
	
	
}
