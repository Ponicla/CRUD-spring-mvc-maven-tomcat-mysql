package com.embarque.tarjetas.models;

import java.util.List;

public interface TarjetaDao {
	public List<Tarjeta> getAll();
	public Tarjeta getById(String tarjetaId);
	public String insert(Tarjeta tarjeta);
	public String update(Tarjeta tarjeta);
	public String delete(String tarjetaId);
	
}
