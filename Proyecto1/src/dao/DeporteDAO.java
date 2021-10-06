package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;

public class DeporteDAO {
	
	ConexionDB conBD;

	public ArrayList<Deporte> getDeportes() {
		conBD = new ConexionDB();
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_deporte, nombre FROM Deporte";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return deportes;
	}
}
