package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deportista;
import model.Equipo;

public class EquipoDAO {

	ConexionDB conBD;


	public ArrayList<Equipo> getEquipos() {
		conBD = new ConexionDB();
		ArrayList<Equipo> deportes = new ArrayList<Equipo>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_equipo, nombre, iniciales FROM Equipo";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return deportes;
	}
}
