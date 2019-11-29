package com.embarque.tarjetas.models;

public class Tarjeta implements Comparable<Tarjeta>{
	private String tarjetaId;
	private String origen;
	private String destino;
	private String transporte;
	private String fecha;
	private String hora;
	
	public Tarjeta() {
		super();
	}
	
	public Tarjeta(String tarjetaId, String origen, String destino, String transporte, String fecha, String hora) {
		super();
		this.tarjetaId = tarjetaId;
		this.origen = origen;
		this.destino = destino;
		this.transporte = transporte;
		this.fecha = fecha;
		this.hora = hora;
	}

	public String getTarjetaId() {
		return tarjetaId;
	}

	public void setTarjetaId(String tarjetaId) {
		this.tarjetaId = tarjetaId;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Tarjeta [tarjetaId=" + tarjetaId + ", origen=" + origen + ", destino=" + destino + ", transporte="
				+ transporte + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

	@Override
	public int compareTo(Tarjeta o) {
		
		return hora.compareTo(o.getHora());
	}
	
}
