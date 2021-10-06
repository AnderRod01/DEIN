package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Olimpiada;
import model.Participacion;

public class ParticipacionDAO {

	ConexionDB conBD;

	public ArrayList<Participacion> getEquipos() {
		conBD = new ConexionDB();
		ArrayList<Participacion> deportes = new ArrayList<Participacion>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_deportista, id_evento, id_equipo, edad, medalla FROM Participacion";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return deportes;
	}
}
