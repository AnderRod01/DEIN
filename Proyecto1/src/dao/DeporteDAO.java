package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;

public class DeporteDAO {
	
	ConexionDB cn;

	public ArrayList<Deporte> getDeportes() {
		PreparedStatement ps;
		ArrayList <Deporte> lstDeportes = new ArrayList <Deporte>();
		
		try {
			ps=cn.getConexion().prepareStatement("select *  from Deporte");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				lstDeportes.add(new Deporte (rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lstDeportes;
	}
	
	public void insertDeporte (Deporte deporte) {
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		
		try {
			ps= cn.getConexion().prepareStatement("insert into Deporte (nombre) values (?)");
			ps.setString(1, deporte.getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateDeporte (Deporte deporte) {
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		
		try {
			ps= cn.getConexion().prepareStatement("update Deporte set nombre = ? where id_deporte = ?");
			ps.setString(1, deporte.getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
