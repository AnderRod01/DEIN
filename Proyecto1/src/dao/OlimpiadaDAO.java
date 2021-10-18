package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Evento;
import model.Olimpiada;

public class OlimpiadaDAO {

	ConexionDB cn;


	public ArrayList <Olimpiada> getOlimpiadas() {
		PreparedStatement ps;
		ArrayList <Olimpiada> lstOlimpiadas= new ArrayList<Olimpiada>();
		try {
			ps=cn.getConexion().prepareStatement("select * from Olimpiada");
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				lstOlimpiadas.add(new Olimpiada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstOlimpiadas;
	}
	
	public ArrayList <Olimpiada> getOlimpiadasInvierno (){
		PreparedStatement ps;
		ArrayList <Olimpiada> lstOlimpiadas= new ArrayList<Olimpiada>();
		try {
			ps=cn.getConexion().prepareStatement("select * from Olimpiada where temporada = ?");
			ps.setString(1, "Winter");
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				lstOlimpiadas.add(new Olimpiada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstOlimpiadas;
	}
	
	public ArrayList <Olimpiada> getOlimpiadasVerano (){
		PreparedStatement ps;
		ArrayList <Olimpiada> lstOlimpiadas= new ArrayList<Olimpiada>();
		try {
			ps=cn.getConexion().prepareStatement("select * from Olimpiada where temporada = ?");
			ps.setString(1, "Summer");
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				lstOlimpiadas.add(new Olimpiada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstOlimpiadas;
	}
	
	public void insertOlimpiada (Olimpiada olimpiada) {
		
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		try {
			ps=cn.getConexion().prepareStatement("insert into Olimpiada (nombre, anio, temporada, ciudad) values (?,?,?,?)");
			ps.setString(1, olimpiada.getNombre());
			ps.setInt(2, olimpiada.getAnio());
			ps.setString(3, olimpiada.getTemporada());
			ps.setString(4, olimpiada.getCiudad());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateOlimpiada (Olimpiada olimpiada) {
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		
		try {
			ps= cn.getConexion().prepareStatement("update Olimpiada set nombre = ?, anio = ?, temporada = ?, ciudad = ? where id_olimpida = ?");
			ps.setString(1, olimpiada.getNombre());
			ps.setInt(2, olimpiada.getAnio());
			ps.setString(3, olimpiada.getTemporada());
			ps.setString(4, olimpiada.getCiudad());
			ps.setInt(5, olimpiada.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
