package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deportista;

public class DeportistaDAO {

	ConexionDB conBD;

	public ArrayList<Deportista> getDeportistas() {
		//conBD = new ConexionDB();
		ArrayList<Deportista> deportes = new ArrayList<Deportista>();
		try (Connection conexion = ConexionDB.getConexion()){
			String sql = "SELECT id_deportista, nombre, sexo, peso, altura FROM Deportista";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return deportes;
	}
	
	public void insertDeportes() {
		
	}
	
	
}
