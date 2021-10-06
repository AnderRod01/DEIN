package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Equipo;
import model.Evento;

public class EventoDAO {

	ConexionDB conBD;

	public EventoDAO() {
		conBD = new ConexionDB();
	}

	public ArrayList<Evento> getEquipos() {
		ArrayList<Evento> deportes = new ArrayList<Evento>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_evento, nombre, id_olimpiada, id_deporte FROM Evento";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return deportes;
	}
}
