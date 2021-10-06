package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Evento;
import model.Olimpiada;

public class OlimpiadaDAO {

	ConexionDB conBD;


	public ArrayList<Olimpiada> getEquipos() {
		conBD = new ConexionDB();
		ArrayList<Olimpiada> deportes = new ArrayList<Olimpiada>();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_olimpiada, nombre, anio, temporada, ciudad FROM Olimpiada";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return deportes;
	}
}
