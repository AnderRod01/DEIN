package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;
import model.Deportista;

public class DeportistaDAO {

	ConexionDB cn;

	public ArrayList<Deportista> getDeportista() {
		PreparedStatement ps;
		ArrayList <Deportista> lstDeportistas = new ArrayList <Deportista>();
		
		try {
			ps=cn.getConexion().prepareStatement("select *  from Deportista");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				lstDeportistas.add(new Deportista (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lstDeportistas;
	}
	
	public void insertDeportista (Deportista deportista) {
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		
		try {
			ps= cn.getConexion().prepareStatement("insert into Deportista (nombre, sexo, peso, altura) values (?,?,?,?)");
			ps.setString(1, deportista.getNombre());
			ps.setString(2, deportista.getSexo());
			ps.setInt(3, deportista.getPeso());
			ps.setInt(4, deportista.getAltura());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateDeportista (Deportista deportista) {
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		
		try {
			ps= cn.getConexion().prepareStatement("update Deportista set nombre = ?, sexo= ?, peso = ?, altura = ? where id_deportista = ?");
			ps.setString(1, deportista.getNombre());
			ps.setString(2, deportista.getSexo());
			ps.setInt(3, deportista.getPeso());
			ps.setInt(4, deportista.getAltura());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
