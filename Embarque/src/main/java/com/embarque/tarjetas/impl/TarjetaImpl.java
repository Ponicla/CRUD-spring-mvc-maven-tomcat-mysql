package com.embarque.tarjetas.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.embarque.tarjetas.models.Tarjeta;
import com.embarque.tarjetas.models.TarjetaDao;

public class TarjetaImpl implements TarjetaDao{
	
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	} 

	@Override
	public List<Tarjeta> getAll() {
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("SELECT * FROM tarjetas");
			rs = ps.executeQuery();
			while(rs.next()) {
				tarjetas.add(new Tarjeta(rs.getString("id"),rs.getString("origen"),rs.getString("destino"),rs.getString("transporte"),rs.getString("fecha"),rs.getString("hora")));
			} 
			rs.close();
			ps.close();
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tarjetas;
	}

	@Override
	public Tarjeta getById(String tarjetaId) {
		Tarjeta tarjeta = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("SELECT * FROM tarjetas WHERE id = ?");
			ps.setString(1, tarjetaId);
			rs = ps.executeQuery();
			while(rs.next()) {
				tarjeta = new Tarjeta(rs.getString("id"),rs.getString("origen"),rs.getString("destino"),rs.getString("transporte"),rs.getString("fecha"),rs.getString("hora"));
			} 
			rs.close();
			ps.close();
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tarjeta;
	}

	@Override
	public String insert(Tarjeta tarjeta) {
		String mensaje = "";
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("INSERT INTO tarjetas (origen, destino, transporte, fecha, hora) VALUES(?,?,?,?,?)");
			ps.setString(1, tarjeta.getOrigen());
			ps.setString(2, tarjeta.getDestino());
			ps.setString(3, tarjeta.getTransporte());
			ps.setString(4, tarjeta.getFecha());
			ps.setString(5, tarjeta.getHora());
			int id = ps.executeUpdate();
			ps.close();
			mensaje = "AGREGADA LA " + tarjeta.toString() +" ID: "+ id;
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mensaje;
	}

	@Override
	public String update(Tarjeta tarjeta) {
		String mensaje = "";
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("UPDATE tarjetas SET origen = ?, destino = ?, transporte = ?, fecha = ?, hora = ? WHERE id = ?");
			ps.setString(1, tarjeta.getOrigen());
			ps.setString(2, tarjeta.getDestino());
			ps.setString(3, tarjeta.getTransporte());
			ps.setString(4, tarjeta.getFecha());
			ps.setString(5, tarjeta.getHora());
			ps.setString(6, tarjeta.getTarjetaId());
			ps.executeUpdate();
			ps.close();
			mensaje = "ACTUALIZADA LA " + tarjeta.toString() +" ID: "+ tarjeta.getTarjetaId();
			
		} catch (SQLException sqle) {
			mensaje = sqle.getMessage();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mensaje;
	}

	@Override
	public String delete(String tarjetaId) {
		String mensaje = "";
	try {
		conn = dataSource.getConnection();
		ps = conn.prepareStatement("DELETE FROM tarjetas WHERE id = ?");
		ps.setString(1, tarjetaId);
		ps.executeUpdate();
		ps.close();
		mensaje = "ELIMINADA LA TARJETA CON EL ID: "+ tarjetaId;
		
	} catch (SQLException sqle) {
		mensaje = sqle.getMessage();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return mensaje;
	}
}
